import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestClass {

    @Test
    public void addTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(2,7);
        Monom m3 = new Monom(1,-1);
        Monom m4 = new Monom(0,5);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);
        Polinom p2 = new Polinom();
        Monom m5 = new Monom(2,1);
        Monom m6 = new Monom(1,-1);
        Monom m7 = new Monom(0,1);
        p2.addMonom(m5);
        p2.addMonom(m6);
        p2.addMonom(m7);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(3,3);
        Monom m9 = new Monom(2,8);
        Monom m10 = new Monom(1,-2);
        Monom m11 = new Monom(0,6);
        p3.addMonom(m8);
        p3.addMonom(m9);
        p3.addMonom(m10);
        p3.addMonom(m11);
        assertEquals(p3.toString(),p1.add(p2).toString());

    }

    @Test
    public void subTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(2,7);
        Monom m3 = new Monom(1,-1);
        Monom m4 = new Monom(0,5);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);
        Polinom p2 = new Polinom();
        Monom m5 = new Monom(2,1);
        Monom m6 = new Monom(1,-1);
        Monom m7 = new Monom(0,1);
        p2.addMonom(m5);
        p2.addMonom(m6);
        p2.addMonom(m7);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(3,3);
        Monom m9 = new Monom(2,6);
        Monom m10 = new Monom(0,4);
        p3.addMonom(m8);
        p3.addMonom(m9);
        p3.addMonom(m10);
        assertEquals(p3.toString(),p1.sub(p2).toString());
    }

    @Test
    public void mulTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(2,3);
        Monom m2 = new Monom(1,2);
        p1.addMonom(m1);
        p1.addMonom(m2);
        System.out.println(p1);

        Polinom p2 = new Polinom();
        Monom m5 = new Monom(2,1);
        Monom m6 = new Monom(1,1);
        p2.addMonom(m5);
        p2.addMonom(m6);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(4,3);
        Monom m9 = new Monom(3,5);
        Monom m10 = new Monom(2,2);
        p3.addMonom(m8);
        p3.addMonom(m9);
        p3.addMonom(m10);
        String s = "3.0x^4+5.0x^3+2.0x^2";
        assertEquals(s,p1.mul(p2).toString());
    }
    @Test
    public void divTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(2,7);
        Monom m3 = new Monom(1,-1);
        Monom m4 = new Monom(0,5);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);
        Polinom p2 = new Polinom();
        Monom m5 = new Monom(2,1);
        Monom m6 = new Monom(1,-1);
        Monom m7 = new Monom(0,1);
        p2.addMonom(m5);
        p2.addMonom(m6);
        p2.addMonom(m7);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(1,3);
        Monom m9 = new Monom(0,10);
        p3.addMonom(m8);
        p3.addMonom(m9);
        assertEquals(p3.toString(),p1.div(p2).toString());
    }
    @Test
    public void derivTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(2,7);
        Monom m3 = new Monom(1,-1);
        Monom m4 = new Monom(0,5);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(2,9);
        Monom m9 = new Monom(1,14);
        Monom m10 = new Monom(0,-1);
        p3.addMonom(m8);
        p3.addMonom(m9);
        p3.addMonom(m10);
        assertEquals(p3.toString(),p1.derivare().toString());
    }
    @Test
    public void integTest(){
        Polinom p1 = new Polinom();
        Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(2,6);
        Monom m3 = new Monom(1,-1);
        Monom m4 = new Monom(0,5);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);
        Polinom p3 = new Polinom();
        Monom m8 = new Monom(4,(double)3/4);
        Monom m9 = new Monom(3,(double)6/3);
        Monom m10 = new Monom(2,(double)-1/2);
        Monom m11 = new Monom(1,5);
        p3.addMonom(m8);
        p3.addMonom(m9);
        p3.addMonom(m10);
        p3.addMonom(m11);
        assertEquals(p3.toString(),p1.integrare().toString());
    }


}
