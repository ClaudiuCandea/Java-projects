import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {
    protected int putere=0;
    protected double coeficient=0;
    private static final String PATTERN = "[^x^]+";


    public Monom(int p, double c){
        putere=p;
        coeficient=c;
    }

    public Monom(String text){
        Pattern pattern1 = Pattern.compile(PATTERN);
        Matcher matcher = pattern1.matcher(text);
        while(matcher.find()){
            if(this.coeficient==0) {

                if (matcher.group().equals("+")) {
                    this.coeficient = 1;
                } else if (matcher.group().equals("-")) {
                    this.coeficient = -1;
                } else {
                    this.coeficient = Integer.parseInt(matcher.group());
                }
            }
            else{
                this.putere = Integer.parseInt(matcher.group());
            }
        }
    }

    public Monom add(Monom m) throws Exception {
        if(m.putere == putere){
            return new Monom(putere, coeficient+m.coeficient);
        }
        else{
            throw  new Exception("Monoamele nu se pot aduna deoarece nu au aceeasi putere");
        }
    }

    public Monom sub(Monom m) throws Exception {
        if(m.putere == putere){
            return new Monom(putere, coeficient-m.coeficient);
        }
        else{
            throw  new Exception("Monoamele nu se pot scadea deoarece nu au aceeasi putere");
        }
    }


    public Monom mul(Monom m){
        Monom rez = new Monom(m.putere+putere,m.coeficient*coeficient);
        return rez;
    }

    public Monom div(Monom d) {
        if(d.coeficient!=0){
            if(putere>=d.putere){
                return new Monom(putere-d.putere,coeficient/d.coeficient);
            }
            else {
                System.out.println("Nu se poate efectua impartirea");
                return null;
            }
        }
        else {
            System.out.println("Nu se poate efectua impartirea");
            return null;
        }
    }

    public Monom derivare(){
        if (putere == 0){
            return new Monom(0,0);
        }
        return new Monom(putere-1,coeficient*putere);

    }

    public Monom integrare(){
        double temp=1/((double)putere+1);
        System.out.println(temp);
        return new Monom(putere+1,coeficient*temp);
    }


    public String toString() {
        String s="";
        if(putere == 1){
            if(coeficient==1) {
                s = "x";
            }
            else {
                s = coeficient + "x";
            }
        }
        else if(putere == 0){
            if(coeficient==0) {
                s = "";
            }
            else {
                s += coeficient ;
            }
        }
        else{
            if(coeficient==1) {
                s = "x^"+putere;
            }
            else {
                s = coeficient + "x^"+putere;
            }
        }
        return s;
    }
}
