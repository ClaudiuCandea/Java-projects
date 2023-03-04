package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * UI Class for select the operation on Orders table
 */

public class OrderView extends JFrame {

    private JLabel quantity;
    private JTextField quantityField;
    private JButton insert;
    private JButton findAll;
    private JButton exit;
    private JTextField message;

    public JTextField getMessage() {
        return message;
    }


    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getFindAll() {
        return findAll;
    }
    /**
     * Return exit button
     * @return JButton
     */
    public JButton getExit() {
        return exit;
    }

    /**
     * Return quantityField
     * @return JTextField
     */
    public JTextField getQuantityField() {
        return quantityField;
    }
    /**
     * Return insert button
     * @return JButton
     */
    public JButton getInsert() {
        return insert;
    }


    public OrderView(){
        quantity = new JLabel("quantity=");
        quantityField = new JTextField();
        insert = new JButton("INSERT");
        exit = new JButton("EXIT");
        findAll = new JButton("FIND ALL");
        message = new JTextField();

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Order view");
        getContentPane().setBounds(0,0,600,600);
        getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.setBounds(50,50,300,50);
        panel.add(quantity);
        panel.add(quantityField);
        getContentPane().add(panel);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
        buttons.setBounds(150,0,600,600);
        buttons.add(insert);
        buttons.add(findAll);
        buttons.add(exit);
        getContentPane().add(buttons);
        message.setBounds(0,350,600,200);
        getContentPane().add(message);
        this.setVisible(false);


    }
}
