package PresentationLayer;

import BusinessLayer.DeliveryService;
import DataLayer.Serializator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame{

    JButton register;
    JLabel username;
    JLabel password;
    JTextField usernameField;
    JTextField passwordField;
    JTextField message;


    public RegisterView(){
        this.setSize(600,600);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Register");
        getContentPane().setBounds(0,0,600,600);
        getContentPane().setLayout(null);

        register = new JButton("register");
        username = new JLabel("Username:");
        password = new JLabel("Password");
        usernameField = new JTextField();
        passwordField = new JTextField();
        message = new JTextField();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.setBounds(100,150,400,100);
        panel1.add(username);
        panel1.add(usernameField);
        panel1.add(password);
        panel1.add(passwordField);
        getContentPane().add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(250,300,200,200);
        panel2.add(register);
        message.setBounds(0,400,600,100);
        getContentPane().add(panel2);
        getContentPane().add(message);
        this.setVisible(false);
    }

}
