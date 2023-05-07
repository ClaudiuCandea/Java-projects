package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.User;
import DataLayer.Serializator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller implements ActionListener {
    LogInView logInView;
    ClientView clientView;
    AdministratorView administratorView;
    EmployeeView employeeView;
    RegisterView registerView;
    DeliveryService deliveryService;
    Serializator serializator;
    String name;

    public Controller(){

        serializator = new Serializator();
        deliveryService = new DeliveryService();
        deliveryService=serializator.deserialization();

        logInView = new LogInView();
        clientView = new ClientView();
        administratorView = new AdministratorView();
        employeeView = new EmployeeView();
        registerView = new RegisterView();
        logInView.logIn.addActionListener(this);
        logInView.register.addActionListener(this);
        administratorView.createProduct.addActionListener(this);
        administratorView.importProduct.addActionListener(this);
        administratorView.modify.addActionListener(this);
        administratorView.insert.addActionListener(this);
        administratorView.delete.addActionListener(this);
        administratorView.report.addActionListener(this);
        administratorView.view.addActionListener(this);
        clientView.createOrder.addActionListener(this);
        clientView.search.addActionListener(this);
        clientView.view.addActionListener(this);
        registerView.register.addActionListener(this);
        deliveryService.registerObserver(employeeView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerView.register){
            try {
                deliveryService.registerClient(registerView.usernameField.getText(), registerView.passwordField.getText());
            }catch (IllegalArgumentException exception){
                registerView.message.setText(exception.getMessage());
            }
            serializator.serialization(deliveryService);
        }
        if(e.getSource()==logInView.register){
            registerView.setVisible(true);
        }
        if(e.getSource()==logInView.logIn){
            String username = logInView.usernameText.getText();
            String password = logInView.passwordText.getText();
            User user;
            try{
                user = deliveryService.findUser(username,password);
                if(user.getRole().equals("Admin")){
                    administratorView.setVisible(true);
                }
                if(user.getRole().equals("Client")){
                    clientView.setVisible(true);
                    name=user.getUsername();
                }
                if(user.getRole().equals("Employee")){
                    employeeView = new EmployeeView();
                    deliveryService.registerObserver(employeeView);
                    employeeView.setVisible(true);
                }
            }catch (IllegalArgumentException exception){
                logInView.message.setText(exception.getMessage());
            }
        }
        if(e.getSource()==clientView.search){
            String keyword = clientView.titleField.getText();
            double rating=0, calories=0, protein=0, fat=0, sodium=0, price=0;
            if(!clientView.ratingField.getText().equals(""))
                 rating = Double.parseDouble(clientView.ratingField.getText());
            else rating = -1;
            if(!clientView.caloriesField.getText().equals(""))
                calories = Double.parseDouble(clientView.caloriesField.getText());
            else calories = -1;
            if(!clientView.proteinField.getText().equals(""))
                protein = Double.parseDouble(clientView.proteinField.getText());
            else protein = -1;
            if(!clientView.fatField.getText().equals(""))
                fat = Double.parseDouble(clientView.fatField.getText());
            else fat = -1;
            if(!clientView.sodiumField.getText().equals(""))
                sodium = Double.parseDouble(clientView.sodiumField.getText());
            else sodium = -1;
            if(!clientView.priceField.getText().equals(""))
                price = Double.parseDouble(clientView.priceField.getText());
            else price = -1;
            List<MenuItem> list = deliveryService.searchProducts(keyword,rating,calories,protein,fat,sodium,price);
            clientView.createTable(list);
        }
        if(e.getSource()==clientView.view){
            clientView.createTable(deliveryService.getMenu());
        }
        if(e.getSource()==clientView.createOrder){
            int[] rowsIndex =  clientView.table.getSelectedRows();
            ArrayList<MenuItem> productList = new ArrayList<MenuItem>();
            for(int i=0;i<rowsIndex.length;i++){
                MenuItem item = deliveryService.getMenu().get(rowsIndex[i]);
                productList.add(item);
            }
            deliveryService.createOrder(productList,name);
            serializator.serialization(deliveryService);

        }
        if(e.getSource()==administratorView.view){
            administratorView.createTable(deliveryService.getMenu());
        }
        if(e.getSource()==administratorView.importProduct){
            deliveryService.importProduct();
            serializator.serialization(deliveryService);
        }
        if(e.getSource()==administratorView.delete){
            deliveryService.deleteProduct(administratorView.titleField.getText());
            serializator.serialization(deliveryService);
        }
        if(e.getSource()==administratorView.insert){
            String keyword = administratorView.titleField.getText();
            double rating=0, calories=0, protein=0, fat=0, sodium=0, price=0;
            rating = Double.parseDouble(administratorView.ratingField.getText());
            calories = Double.parseDouble(administratorView.caloriesField.getText());
            protein = Double.parseDouble(administratorView.proteinField.getText());
            fat = Double.parseDouble(administratorView.fatField.getText());
            sodium = Double.parseDouble(administratorView.sodiumField.getText());
            price = Double.parseDouble(administratorView.priceField.getText());
            BaseProduct baseProduct = new BaseProduct(keyword,rating,calories,protein,fat,sodium,price);
            deliveryService.addProduct(baseProduct);
            serializator.serialization(deliveryService);
        }
        if(e.getSource()==administratorView.modify){
            deliveryService.modifyProduct(administratorView.titleField.getText(),Double.parseDouble(administratorView.priceField.getText()));
            serializator.serialization(deliveryService);
        }
        if(e.getSource()==administratorView.createProduct){
           int[] rowsIndex =  administratorView.table.getSelectedRows();
           List<BaseProduct> productList = new ArrayList<>();
           for(int i=0;i<rowsIndex.length;i++){
               MenuItem item = deliveryService.getMenu().get(rowsIndex[i]);
               if(item instanceof BaseProduct){
                   productList.add((BaseProduct) item);
               }
           }
           deliveryService.createCompositeProduct(productList,administratorView.titleField.getText());
           serializator.serialization(deliveryService);
        }
        if(e.getSource()==administratorView.report){
            int startHour = Integer.parseInt(administratorView.startHourField.getText());
            int endHour = Integer.parseInt(administratorView.endHourField.getText());
            int nrOrders = Integer.parseInt(administratorView.minNumberOfOrdersField.getText());
            double totalPrice = Double.parseDouble(administratorView.minTotalSumField.getText());
            String dateStr = administratorView.dateField.getText();
            String[] dateStrings = dateStr.split("\\.");
            System.out.println(dateStr);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = null;
            try {
                date = simpleDateFormat.parse(dateStr);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            deliveryService.generateReport1(startHour,endHour);
            deliveryService.generateReport2(nrOrders);
            deliveryService.generateReport3(totalPrice,nrOrders);
            deliveryService.generateReport4(date,nrOrders);
        }


    }
}
