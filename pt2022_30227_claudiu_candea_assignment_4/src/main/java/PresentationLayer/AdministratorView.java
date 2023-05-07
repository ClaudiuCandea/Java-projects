package PresentationLayer;

import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AdministratorView extends JFrame{

    protected JButton insert;
    protected JButton modify;
    protected JButton delete;
    protected JButton report;
    protected JButton importProduct;
    protected JButton createProduct;
    protected JButton view;

    private JLabel title;
    private JLabel rating;
    private JLabel calories;
    private JLabel protein;
    private JLabel fat;
    private JLabel sodium;
    private JLabel price;

    protected JTextField titleField;
    protected JTextField ratingField;
    protected JTextField caloriesField;
    protected JTextField proteinField;
    protected JTextField fatField;
    protected JTextField sodiumField;
    protected JTextField priceField;

    protected JTable table;
    private DefaultTableModel tmodel;
    private JScrollPane scrollPane;

    private JLabel startHour;
    private JLabel endHour;
    private JLabel minNumberOfOrders;
    private JLabel minTotalSum;
    private JLabel date;

    protected JTextField startHourField;
    protected JTextField endHourField;
    protected JTextField minNumberOfOrdersField;
    protected JTextField minTotalSumField;
    protected JTextField dateField;


    public AdministratorView(){
        this.setSize(1000,1000);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AdministratorView");
        getContentPane().setBounds(0,0,1000,1000);
        getContentPane().setLayout(null);

        insert = new JButton("insert");
        modify = new JButton("modify");
        delete = new JButton("delete");
        report = new JButton("raport");
        importProduct = new JButton("importProduct");
        createProduct = new JButton("createProduct");
        view = new JButton("view");

        title = new JLabel("title");
        rating = new JLabel("rating");
        calories = new JLabel("calories");
        protein = new JLabel("protein");
        fat = new JLabel("fat");
        sodium = new JLabel("sodium");
        price = new JLabel("price");
        titleField = new JTextField();
        ratingField = new JTextField();
        caloriesField = new JTextField();
        proteinField = new JTextField();
        fatField = new JTextField();
        sodiumField = new JTextField();
        priceField = new JTextField();

        startHour = new JLabel("StartHour");
        endHour = new JLabel("EndHour");
        minNumberOfOrders = new JLabel("Min nr of orders");
        minTotalSum = new JLabel("Min totalSum");
        date = new JLabel("date");
        startHourField = new JTextField();
        endHourField =new JTextField();
        minNumberOfOrdersField = new JTextField();
        minTotalSumField = new JTextField();
        dateField = new JTextField();
        JPanel panel3 = new JPanel();
        panel3.setBounds(500,0,300,300);
        panel3.setLayout(new GridLayout(5,2));
        panel3.add(startHour);
        panel3.add(startHourField);
        panel3.add(endHour);
        panel3.add(endHourField);
        panel3.add(minNumberOfOrders);
        panel3.add(minNumberOfOrdersField);
        panel3.add(minTotalSum);
        panel3.add(minTotalSumField);
        panel3.add(date);
        panel3.add(dateField);
        getContentPane().add(panel3);
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,300,300);
        panel1.setLayout(new GridLayout(7,2));
        panel1.add(title);
        panel1.add(titleField);
        panel1.add(rating);
        panel1.add(ratingField);
        panel1.add(calories);
        panel1.add(caloriesField);
        panel1.add(protein);
        panel1.add(proteinField);
        panel1.add(fat);
        panel1.add(fatField);
        panel1.add(sodium);
        panel1.add(sodiumField);
        panel1.add(price);
        panel1.add(priceField);

        getContentPane().add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(250,310,500,100);
        panel2.add(insert);
        panel2.add(delete);
        panel2.add(modify);
        panel2.add(report);
        panel2.add(createProduct);
        panel2.add(importProduct);
        panel2.add(view);
        getContentPane().add(panel2);

        setVisible(false);
    }
    void createTable( List<BusinessLayer.MenuItem> list){
        ArrayList<String> columnNames = new ArrayList<String>();
        int numberOfFields = 0;
        for (Field field : BusinessLayer.MenuItem.class.getDeclaredFields()) {
            field.setAccessible(true);
            columnNames.add(field.getName());
            numberOfFields++;
        }
        Object[][]  data = new Object[list.size()][numberOfFields];
        for(int i=0;i<list.size();i++){
            int j=0;
            for(Field field : MenuItem.class.getDeclaredFields()){
                try {
                    field.setAccessible(true);
                    data[i][j]=field.get(list.get(i));
                    j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if(table==null) {
            tmodel = new DefaultTableModel(data,columnNames.toArray());
            table = new JTable(tmodel);
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 380, 900, 400);
            scrollPane.setHorizontalScrollBar(new JScrollBar());
            getContentPane().add(scrollPane);
        }
        else{
            tmodel.setDataVector(data,columnNames.toArray());
            tmodel.fireTableDataChanged();
        }
    }


}
