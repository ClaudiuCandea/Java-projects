import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CalcView extends JFrame {
    protected JLabel l = new JLabel("Polynomial Calculator");
    protected JLabel l1 = new JLabel("First Polynomial=");
    protected JLabel l2 = new JLabel("Second Polynomial=");
    protected JLabel l3 = new JLabel("Result=");
    protected JButton mul = new JButton("Multiplicate");
    protected JButton div = new JButton("Divide");
    protected JButton add = new JButton("Add");
    protected JButton sub = new JButton("Substract");
    protected JButton deriv = new JButton("Derivare");
    protected JButton integ = new JButton("Integrare");
    protected JButton b1 = new JButton("1");
    protected JButton b2 = new JButton("2");
    protected JButton b3 = new JButton("3");
    protected JButton b4 = new JButton("4");
    protected JButton b5 = new JButton("5");
    protected JButton b6 = new JButton("6");
    protected JButton b7 = new JButton("7");
    protected JButton b8 = new JButton("8");
    protected JButton b9 = new JButton("9");
    protected JButton b0 = new JButton("0");
    protected ArrayList<JButton> bb = new ArrayList<JButton>(10);
    protected JButton badd = new JButton("+");
    protected JButton bsub = new JButton("-");
    protected JButton bputer = new JButton("^");
    protected JButton bpct = new JButton(".");
    protected JButton bx = new JButton("x");
    protected JButton bdel = new JButton("del");
    protected JTextField t1 = new JTextField();
    protected JTextField t2 = new JTextField();
    protected JTextField t3 = new JTextField();

    public CalcView (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 500);
        this.setTitle("Polynomial Calculator");
        JButton b0 = new JButton("0");
        bb.add(b0);
        JButton b1 = new JButton("1");
        bb.add(b1);
        JButton b2 = new JButton("2");
        bb.add(b2);
        JButton b3 = new JButton("3");
        bb.add(b3);
        JButton b4 = new JButton("4");
        bb.add(b4);
        JButton b5 = new JButton("5");
        bb.add(b5);
        JButton b6 = new JButton("6");
        bb.add(b6);
        JButton b7 = new JButton("7");
        bb.add(b7);
        JButton b8 = new JButton("8");
        bb.add(b8);
        JButton b9 = new JButton("9");
        bb.add(b9);


        JPanel p = new JPanel();
        setContentPane(p);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3,1));
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(3,1));
        p3.add(mul);
        p3.add(div);
        p3.add(add);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3,1));
        p4.add(sub);
        p4.add(deriv);
        p4.add(integ);

        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout(2,5));
        p5.add(bb.get(1));
        p5.add(bb.get(2));
        p5.add(bb.get(3));
        p5.add(bb.get(4));
        p5.add(bb.get(5));
        p5.add(bb.get(6));
        p5.add(bb.get(7));
        p5.add(bb.get(8));
        p5.add(bb.get(9));
        p5.add(bb.get(0));

        JPanel p6 = new JPanel();
        p6.setLayout(new GridLayout(2,3));
        p6.add(badd);
        p6.add(bsub);
        p6.add(bputer);
        p6.add(bpct);
        p6.add(bx);
        p6.add(bdel);

        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(l);
        JPanel pButton = new JPanel(new GridLayout(3,3));
        pButton.add(p1);
        pButton.add(p2);
        pButton.add(p3);
        pButton.add(p4);
        pButton.add(p5);
        pButton.add(p6);
        p.add(pButton);

        this.setVisible(true);
    }

}


