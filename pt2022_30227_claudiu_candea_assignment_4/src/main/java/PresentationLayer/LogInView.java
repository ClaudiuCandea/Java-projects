package PresentationLayer;

import javax.swing.*;
import java.awt.*;

public class LogInView extends JFrame {

    private JLabel username;
    private JLabel password;
    protected JTextField usernameText;
    protected JTextField passwordText;
    protected JTextField message;
    protected JButton logIn;
    protected JButton register;

    public LogInView() {
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("LogIn");
        getContentPane().setBounds(0,0,600,600);
        getContentPane().setLayout(null);
        username = new JLabel("Username");
        password = new JLabel("Password");
        usernameText = new JTextField();
        passwordText = new JTextField();
        message = new JTextField();
        logIn = new JButton("Log In");
        register = new JButton("Register Client");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.setBounds(100,150,400,100);
        panel1.add(username);
        panel1.add(usernameText);
        panel1.add(password);
        panel1.add(passwordText);
        getContentPane().add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(250,300,200,200);
        panel2.add(logIn);
        panel2.add(register);
        getContentPane().add(panel2);

        message.setBounds(0,500,600,100);
        getContentPane().add(message);
        this.setVisible(true);
    }

}
