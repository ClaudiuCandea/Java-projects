package Presentation;

import Bll.ClientBLL;
import Bll.OrderBLL;
import Bll.ProductBLL;
import Model.Client;
import Model.Orders;
import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Class that controll the UI Classes and implements ActionListener interface
 */

public class Controller implements ActionListener {

    private View view;
    private ClientView clientView;
    private ProductView productView;
    private OrderView orderView;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;
    private OrderBLL orderBLL;
    private TableView<Client> table1;
    private TableView<Product> table2;

    public Controller(){
        this.view = new View();
        clientView = new ClientView();
        orderView = new OrderView();
        productView = new ProductView();
        clientBLL = new ClientBLL();
        productBLL = new ProductBLL();
        orderBLL = new OrderBLL();
        view.getCreateOrder().addActionListener(this);
        view.getProductOp().addActionListener(this);
        view.getClientOp().addActionListener(this);
        clientView.getInsert().addActionListener(this);
        clientView.getDelete().addActionListener(this);
        clientView.getUpdate().addActionListener(this);
        clientView.getFindAll().addActionListener(this);
        clientView.getFindByID().addActionListener(this);
        clientView.getExit().addActionListener(this);

        productView.getInsert().addActionListener(this);
        productView.getDelete().addActionListener(this);
        productView.getUpdate().addActionListener(this);
        productView.getFindAll().addActionListener(this);
        productView.getFindByID().addActionListener(this);
        productView.getExit().addActionListener(this);

        orderView.getInsert().addActionListener(this);
        orderView.getExit().addActionListener(this);
        orderView.getFindAll().addActionListener(this);
    }

    /**
     * The actionPerformed method from the interface ActionListener
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getClientOp()){
            view.setVisible(false);
            clientView.setVisible(true);
        }
        if(e.getSource() == view.getProductOp()){
            view.setVisible(false);
            productView.setVisible(true);
        }
        if(e.getSource() == view.getCreateOrder()){
            view.setVisible(false);
            orderView.setVisible(true);
            ArrayList<Client> list1 =(ArrayList<Client>) clientBLL.findAllClient();
            table1 = new TableView(list1);
            ArrayList<Product> list2 =(ArrayList<Product>) productBLL.findAllProduct();
            table2 = new TableView(list2);
        }
        if(e.getSource()==clientView.getInsert()){
            int id =1;
            String name = clientView.getNameField().getText();
            String email = clientView.getEmailField().getText();
            int age = Integer.parseInt(clientView.getAgeField().getText());
            try {
                Client client = new Client(id, age, name, email);
                clientBLL.insertClient(client);
            }catch(IllegalArgumentException exception){
                clientView.getMessage().setText(exception.getMessage());
            }
        }
        if(e.getSource()==clientView.getDelete()) {
            int id = Integer.parseInt(clientView.getIdField().getText());
            clientBLL.deleteClient(id);
        }
        if(e.getSource()==clientView.getUpdate()){
            int id = Integer.parseInt(clientView.getIdField().getText());
            String name = clientView.getNameField().getText();
            String email = clientView.getEmailField().getText();
            int age = Integer.parseInt(clientView.getAgeField().getText());
            try {
                Client client = new Client(id, age, name, email);
                clientBLL.updateClient(client);
            }catch(IllegalArgumentException exception){
                this.clientView.getMessage().setText(exception.getMessage());
            }
        }
        if(e.getSource()==clientView.getFindByID()){
            int id = Integer.parseInt(clientView.getIdField().getText());
            Client client=clientBLL.findClientById(id);
            ArrayList<Client> list = new ArrayList<Client>();
            list.add(client);
            TableView tableView = new TableView(list);

        }
        if(e.getSource()== clientView.getFindAll()){
            ArrayList<Client> list =(ArrayList<Client>) clientBLL.findAllClient();
            TableView tableView = new TableView(list);
        }
        if(e.getSource() == clientView.getExit()){
            clientView.setVisible(false);
            view.setVisible(true);
        }
        if(e.getSource()==productView.getInsert()){
            int id = 1;
            String name = productView.getNameField().getText();
            int quantity = Integer.parseInt(productView.getQuantityField().getText());
            int price = Integer.parseInt(productView.getPriceField().getText());
            try {
                Product product = new Product(id, name, quantity, price);
                productBLL.insertProduct(product);
            }catch(IllegalArgumentException exception){
                productView.getMessage().setText(exception.getMessage());
            }
        }
        if(e.getSource()==productView.getDelete()){
            int id = Integer.parseInt(productView.getIdField().getText());
            productBLL.deleteProduct(id);
        }
        if(e.getSource()==productView.getUpdate()){
            int id = Integer.parseInt(productView.getIdField().getText());
            String name = productView.getNameField().getText();
            int quantity = Integer.parseInt(productView.getQuantityField().getText());
            int price = Integer.parseInt(productView.getPriceField().getText());
            try {
                Product product = new Product(id, name, quantity, price);
                productBLL.updateProduct(product);
            }catch(IllegalArgumentException exception){
                productView.getMessage().setText(exception.getMessage());
            }
        }
        if(e.getSource()==productView.getFindByID()){
            int id = Integer.parseInt(productView.getIdField().getText());
            Product product=productBLL.findProductById(id);
            ArrayList<Product> list = new ArrayList<Product>();
            list.add(product);
            TableView tableView = new TableView(list);

        }
        if(e.getSource()== productView.getFindAll()){
            ArrayList<Product> list =(ArrayList<Product>) productBLL.findAllProduct();
            TableView tableView = new TableView(list);
        }
        if(e.getSource() == productView.getExit()){
            productView.setVisible(false);
            view.setVisible(true);
        }
        if(e.getSource()==orderView.getInsert()){
            int clientRow = table1.getTable().getSelectedRow();
            int productRow = table2.getTable().getSelectedRow();
            int quantity = Integer.parseInt(orderView.getQuantityField().getText());
            Client client = new Client();
            Product product = new Product();
            client.setId(Integer.parseInt(table1.getTable().getModel().getValueAt(clientRow,0).toString()));
            client.setName(table1.getTable().getModel().getValueAt(clientRow,1).toString());
            client.setEmail(table1.getTable().getModel().getValueAt(clientRow,2).toString());
            client.setAge(Integer.parseInt(table1.getTable().getModel().getValueAt(clientRow,3).toString()));
            product.setId(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow,0).toString()));
            product.setName(table2.getTable().getModel().getValueAt(productRow,1).toString());
            product.setQuantity(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow,2).toString()));
            product.setPrice(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow,3).toString()));
            product.setQuantity(product.getQuantity()-quantity);
            try {
                productBLL.updateProduct(product);
                Orders order = new Orders(1,quantity,product.getName(),client.getName());
                order.setId(orderBLL.insertOrder(order));
                orderBLL.creatPDF(order, order.getQuantity() * product.getPrice());
            }catch(IllegalArgumentException exception){
                orderView.getMessage().setText(exception.getMessage());
            }

        }
        if(e.getSource()== orderView.getFindAll()){
            ArrayList<Orders> list =(ArrayList<Orders>) orderBLL.findAllOrder();
            TableView tableView = new TableView(list);
        }
        if(e.getSource() == orderView.getExit()){
            orderView.setVisible(false);
            view.setVisible(true);

        }
    }
}
