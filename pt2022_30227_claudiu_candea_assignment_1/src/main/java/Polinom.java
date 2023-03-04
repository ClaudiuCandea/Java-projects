import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.*;


public class Polinom {
    protected int grad;
    protected ArrayList<Monom> monomialList;
    private static final String PATTERN = "[-+]?[^+-]+";
    public Polinom(){
        monomialList=new ArrayList<Monom>();
        grad=-1;
    }

    public void addMonom(Monom m){
        monomialList.add(m);
        if(grad<m.putere){
            grad=m.putere;
        }
    }
    public void reset(){
        monomialList.clear();
    }

    public void construct(JTextField text){
        String s = text.getText();
        Pattern pattern1 = Pattern.compile(PATTERN);
        Matcher matcher = pattern1.matcher(s);
        while(matcher.find()){
            Monom m = new Monom(matcher.group());
            this.addMonom(m);
        }

    }

    public void elimZero(){
        for(int i=0;i<this.monomialList.size();i++){
            if(this.monomialList.get(i).coeficient==0){
                monomialList.remove(i);
                this.grad=this.lead().putere;
            }
        }
    }

    public Monom lead(){
        Monom max = monomialList.get(0);
        for(Monom m:this.monomialList){
            if(max.putere<m.
                    putere){
                max=m;
            }
        }
        return max;
    }

    public Polinom add(Polinom p){
        Polinom rez = new Polinom();
        for(Monom i:this.monomialList){
            boolean adunat=false;
            for(Monom j:p.monomialList){
                if(j.putere==i.putere){
                    adunat=true;
                    try {
                        rez.addMonom(i.add(j));
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            if(adunat == false){
                rez.addMonom(i);
            }
        }
        for(Monom i:p.monomialList){
            boolean adunat = false;
            for(Monom j:this.monomialList){
                if(j.putere==i.putere){
                    adunat=true;
                }
            }
            if(adunat==false){
                rez.addMonom(i);
            }
        }
        return rez;
    }

    public Polinom sub(Polinom p){
        Polinom rez = new Polinom();
        for(Monom i:this.monomialList){
            boolean scazut=false;
            for(Monom j:p.monomialList){
                if(j.putere==i.putere){
                    scazut=true;
                    try {
                        rez.addMonom(i.sub(j));
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            if(scazut == false){
                rez.addMonom(i);
            }
        }
        for(Monom i:p.monomialList){
            boolean scazut = false;
            for(Monom j:this.monomialList){
                if(j.putere==i.putere){
                    scazut=true;
                }
            }
            if(scazut==false){
                rez.addMonom(new Monom(i.putere,-i.coeficient));
            }
        }
        return rez;
    }


    public Polinom mul(Polinom p){
        Polinom rez = new Polinom();
        Monom aux,temp;

        for(Monom i:this.monomialList){
            for(Monom j:p.monomialList){
                aux=i.mul(j);
                int indice = 0;
                for(int k=0;k<rez.monomialList.size();k++){
                    if(aux.putere==rez.monomialList.get(k).putere){

                        indice=1;
                        try{
                            temp=rez.monomialList.get(k);
                            rez.monomialList.set(k,temp.add(aux));
                        }
                        catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                if(indice == 0){
                    rez.addMonom(aux);
                }
            }
        }
        return rez;
    }

    public Polinom div(Polinom d){
        Polinom q;
        if(d.monomialList.size()!=0){
            q = new Polinom();
            Polinom r = this;
            int size = r.monomialList.size();
            while(size!=0 && (r.grad >= d.grad)){
                Monom t;
                t = r.lead().div(d.lead());
                Polinom tp = new Polinom();
                tp.addMonom(t);
                q.addMonom(t);
                r=r.sub(tp.mul(d));
                r.elimZero();
                size--;
            }
        }
        else{
            q=null;
        }
        return q ;
    }

    public Polinom derivare(){
        Polinom rez = new Polinom();
        for(Monom m:this.monomialList){
            rez.addMonom(m.derivare());
        }
        return rez;
    }

    public Polinom integrare(){
        Polinom rez = new Polinom();
        for(Monom m:this.monomialList){
            rez.addMonom(m.integrare());
        }
        return rez;
    }

    public String toString(){
        String s="";
        Monom m;
        Iterator<Monom> i = monomialList.iterator();
        s+=i.next();
        while(i.hasNext()){
            m = i.next();
            if(m.coeficient!=0){
                if(m.coeficient>0){
                    s+="+"+m;
                }
                else{
                    s+=m;
                }
            }
        }
        return s;
    }

}
