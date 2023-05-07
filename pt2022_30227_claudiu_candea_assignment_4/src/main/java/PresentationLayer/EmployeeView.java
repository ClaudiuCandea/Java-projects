package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeView extends JFrame implements Observer {
    private JTextArea notifications;
    public EmployeeView(){
        this.setSize(1000,600);
        this.setTitle("EmployeeView");
        getContentPane().setBounds(0,0,600,600);
        getContentPane().setLayout(null);
        notifications = new JTextArea();
        notifications.setBounds(0,0,600,500);
        getContentPane().add(notifications);
    }

    @Override
    public void update(Order order,ArrayList<MenuItem> list) {
        notifications.setText(notifications.getText()+"\n" + order.toString() + "\n"+list.toString());
    }
}
