import javax.swing.*;
import java.awt.*;

public class SimulationFrame extends JFrame {
    protected JLabel lable1 = new JLabel("Maximum arrival time:");
    protected JLabel lable2 = new JLabel("Minimum arrival time:");
    protected JLabel lable3 = new JLabel("Maximum service time:");
    protected JLabel lable4 = new JLabel("Minimum service time:");
    protected JLabel lable5 = new JLabel("Simulation time:");
    protected JLabel lable6 = new JLabel("Number of queues:");
    protected JLabel lable7 = new JLabel("Number of clients:");
    protected JTextField textField1 = new JTextField();
    protected JTextField textField2 = new JTextField();
    protected JTextField textField3 = new JTextField();
    protected JTextField textField4 = new JTextField();
    protected JTextField textField5 = new JTextField();
    protected JTextField textField6 = new JTextField();
    protected JTextField textField7 = new JTextField();
    protected JButton startButton = new JButton("Start");
    protected JTextArea textArea = new JTextArea();
    protected JScrollPane scrollPane = new JScrollPane(textArea);

    public SimulationFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 300, 1000, 500);
        this.setTitle("Queue Simulator");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        this.setContentPane(mainPanel);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.setLayout(new GridLayout(7,1));
        panel1.add(lable1);
        panel1.add(lable2);
        panel1.add(lable3);
        panel1.add(lable4);
        panel1.add(lable5);
        panel1.add(lable6);
        panel1.add(lable7);
        panel2.setLayout((new GridLayout(7,1)));
        panel2.add(textField1);
        panel2.add(textField2);
        panel2.add(textField3);
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(textField6);
        panel2.add(textField7);
        panel4.setLayout(new GridLayout(1,2));
        panel4.add(panel1);
        panel4.add(panel2);
        mainPanel.add(panel4);
        mainPanel.add(startButton);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);

        this.setVisible(true);
    }


}
