package PresentationLayer;

import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame {

    protected JButton search;
    protected JButton createOrder;
    protected JButton back;
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
    protected JScrollPane scrollPane;
    protected  DefaultTableModel tmodel;

    protected JTable table;

    public ClientView(){

        this.setSize(1000,1000);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ClientView");
        getContentPane().setBounds(0,0,1000,1000);
        getContentPane().setLayout(null);
        search = new JButton("search");
        createOrder = new JButton("createOrder");
        back = new JButton("Back");
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
        proteinField = new JTextField();;
        fatField = new JTextField();
        sodiumField = new JTextField();
        priceField = new JTextField();
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
        panel2.setBounds(400,150,500,100);
        panel2.add(search);
        panel2.add(createOrder);
        panel2.add(back);
        panel2.add(view);

        getContentPane().add(panel2);

        this.setVisible(false);

    }

    void createTable( List<MenuItem> list){
        ArrayList<String> columnNames = new ArrayList<String>();
        int numberOfFields = 0;
        for (Field field : MenuItem.class.getDeclaredFields()) {
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
            scrollPane.setBounds(0, 350, 900, 400);
            scrollPane.setHorizontalScrollBar(new JScrollBar());
            getContentPane().add(scrollPane);
        }
        else{
            tmodel.setDataVector(data,columnNames.toArray());
            tmodel.fireTableDataChanged();
        }
    }

}
