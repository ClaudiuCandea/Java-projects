package Presentation;

import javax.swing.*;
import java.awt.*;

/**
 * The main UI class
 * Use to select the table on which the queries will be executed
 */

public class View extends JFrame {
    private final JButton clientOp;
    private final JButton productOp;
    private  final JButton createOrder;


    public View(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main view");
        this.setBackground(Color.red);

        clientOp = new JButton("ClientOp");
        productOp = new JButton("ProductOp");
        createOrder = new JButton("Create Order");
        this.setLayout(null);
        this.add(clientOp);
        this.add(productOp);
        this.add(createOrder);
        clientOp.setBounds(200,50,200,50);
        productOp.setBounds(200,120,200,50);
        createOrder.setBounds(200,190,200,50);
        this.setVisible(true);
    }

    /**
     * Return clientOp button
     * @return JButton
     */
    public JButton getClientOp() {
        return clientOp;
    }
    /**
     * Return productOp button
     * @return JButton
     */
    public JButton getProductOp() {
        return productOp;
    }
    /**
     * Return orderOp button
     * @return JButton
     */
    public JButton getCreateOrder() {
        return createOrder;
    }

}
