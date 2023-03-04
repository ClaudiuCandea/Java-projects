package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * UI Class for select the operation on Product table
 */

public class ProductView extends JFrame{
    private JLabel id;
    private JLabel name;
    private JLabel quantity;
    private JLabel price;
    private JTextField idField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton insert;
    private JButton delete;
    private JButton findByID;
    private JButton update;
    private JButton findAll;
    private JButton exit;
    private JTextField message;

    public JTextField getMessage() {
        return message;
    }


    /**
     * Return exit button
     * @return JButton
     */

    public JButton getExit() {
        return exit;
    }

    /**
     * Return idField
     * @return JTextField
     */
    public JTextField getIdField() {
        return idField;
    }
    /**
     * Return nameField
     * @return JTextField
     */
    public JTextField getNameField() {
        return nameField;
    }
    /**
     * Return quantityField
     * @return JTextField
     */
    public JTextField getQuantityField() {
        return quantityField;
    }
    /**
     * Return priceField
     * @return JTextField
     */
    public JTextField getPriceField() {
        return priceField;
    }
    /**
     * Return insert button
     * @return JButton
     */
    public JButton getInsert() {
        return insert;
    }
    /**
     * Return delete button
     * @return JButton
     */
    public JButton getDelete() {
        return delete;
    }
    /**
     * Return findById button
     * @return JButton
     */
    public JButton getFindByID() {
        return findByID;
    }
    /**
     * Return update button
     * @return JButton
     */
    public JButton getUpdate() {
        return update;
    }
    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getFindAll() {
        return findAll;
    }


    public ProductView(){
        id = new JLabel("ID");
        name = new JLabel("name");
        quantity = new JLabel("quantity");
        price = new JLabel("price");
        idField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        insert = new JButton("INSERT");
        delete = new JButton("DELETE");
        findByID = new JButton("FIND BY ID");
        update  = new JButton("UPDATE");
        findAll  = new JButton("FIND ALL");
        exit = new JButton("EXIT");
        message = new JTextField();

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Product view");
        this.setBackground(Color.red);
        JPanel panel1 = new JPanel();
        this.setContentPane(panel1);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,2));
        panel2.add(id);
        panel2.add(idField);
        panel2.add(name);
        panel2.add(nameField);
        panel2.add(quantity);
        panel2.add(quantityField);
        panel2.add(price);
        panel2.add(priceField);

        JPanel panel3 = new JPanel();
        panel3.add(insert);
        panel3.add(delete);
        panel3.add(update);
        panel3.add(findByID);
        panel3.add(findAll);
        panel3.add(exit);

        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(message);

        this.setVisible(false);


    }
}
