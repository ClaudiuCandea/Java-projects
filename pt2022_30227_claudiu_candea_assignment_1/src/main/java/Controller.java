import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener, MouseListener {

    private CalcView view;
    private Polinom p1, p2,rez;
    private static boolean indic1=true, indic2=false;

    public Controller() {
        view = new CalcView();
        p1 = new Polinom();
        p2 = new Polinom();
        view.mul.addActionListener(this);
        view.add.addActionListener(this);
        view.sub.addActionListener(this);
        view.div.addActionListener(this);
        view.deriv.addActionListener(this);
        view.integ.addActionListener(this);
        for(JButton button:view.bb){
            button.addActionListener(this);
        }
        view.badd.addActionListener(this);
        view.bsub.addActionListener(this);
        view.bputer.addActionListener(this);
        view.bpct.addActionListener(this);
        view.bdel.addActionListener(this);
        view.bx.addActionListener(this);
        view.t1.addMouseListener(this);
        view.t2.addMouseListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(view.mul)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            p2.construct(view.t2);
            rez=null;
            rez=p1.mul(p2);
            view.t3.setText(rez.toString());
        }
        else if(e.getSource().equals(view.add)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            p2.construct(view.t2);
            rez=null;
            rez=p1.add(p2);
            view.t3.setText(rez.toString());
        }
        else if(e.getSource().equals(view.sub)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            p2.construct(view.t2);
            rez=null;
            rez=p1.sub(p2);
            view.t3.setText(rez.toString());
        }
        else if(e.getSource().equals(view.div)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            p2.construct(view.t2);
            rez=null;
            rez=p1.div(p2);
            view.t3.setText(rez.toString());
        }
        else if(e.getSource().equals(view.deriv)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            rez=null;
            rez=p1.derivare();
            view.t3.setText(rez.toString());
        }
        else if(e.getSource().equals(view.integ)){
            p1.reset();
            p2.reset();
            p1.construct(view.t1);
            rez=null;
            rez=p1.integrare();
            view.t3.setText(rez.toString());
        }
        for(JButton button:view.bb) {
            if (e.getSource().equals(button)) {
                if (indic1==true)
                    view.t1.setText(view.t1.getText() + button.getText());
                if (indic2 == true)
                    view.t2.setText(view.t2.getText() + button.getText());
            }
        }
        if(e.getSource().equals(view.badd)){
            if (indic1==true)
                view.t1.setText(view.t1.getText() + view.badd.getText());
            if (indic2 == true)
                view.t2.setText(view.t2.getText() + view.badd.getText());
        }
        if(e.getSource().equals(view.bsub)){
            if (indic1==true)
                view.t1.setText(view.t1.getText() + view.bsub.getText());
            if (indic2 == true)
                view.t2.setText(view.t2.getText() + view.bsub.getText());
        }
        if(e.getSource().equals(view.bputer)){
            if (indic1==true)
                view.t1.setText(view.t1.getText() + view.bputer.getText());
            if (indic2 == true)
                view.t2.setText(view.t2.getText() + view.bputer.getText());
        }
        if(e.getSource().equals(view.bpct)){
            if (indic1==true)
                view.t1.setText(view.t1.getText() + view.bpct.getText());
            if (indic2 == true)
                view.t2.setText(view.t2.getText() + view.bpct.getText());
        }
        if(e.getSource().equals(view.bx)){
            if (indic1==true)
                view.t1.setText(view.t1.getText() + view.bx.getText());
            if (indic2 == true)
                view.t2.setText(view.t2.getText() + view.bx.getText());
        }
        if(e.getSource().equals(view.bdel)){
            view.t1.setText("");
            view.t2.setText("");
        }



    }







    public static void main (String args[]){
        Controller cont = new Controller();

    }

    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(view.t1)){
            indic1 = true;
            indic2 = false;
        }
        else if(e.getSource().equals(view.t2)){
            indic1 = false;
            indic2 = true;
        }

    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
