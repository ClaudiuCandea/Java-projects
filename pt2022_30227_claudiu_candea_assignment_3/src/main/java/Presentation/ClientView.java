package Presentation;

import javax.swing.*;
import java.awt.*;

/**
 * UI Class for select the operation on Client table
 */

public class ClientView extends JFrame {
    private JLabel id;
    private JLabel name;
    private JLabel email;
    private JLabel age;
    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField ageField;
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
     * Return emailField
     * @return JTextField
     */
    public JTextField getEmailField() {
        return emailField;
    }
    /**
     * Return ageField
     * @return JTextField
     */
    public JTextField getAgeField() {
        return ageField;
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
     * Return update  button
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


    public ClientView(){
        id = new JLabel("ID");
        name = new JLabel("name");
        email = new JLabel("email");
        age = new JLabel("age");
        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        ageField = new JTextField();
        insert = new JButton("INSERT");
        delete = new JButton("DELETE");
        findByID = new JButton("FIND BY ID");
        update  = new JButton("UPDATE");
        findAll  = new JButton("FIND ALL");
        exit = new JButton("EXIT");
        message = new JTextField();

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Client view");
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
        panel2.add(email);
        panel2.add(emailField);
        panel2.add(age);
        panel2.add(ageField);

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
