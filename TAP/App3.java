
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App3 {
   public static void main(String[] args){
  ComPolFram fram = new ComPolFram();
        fram.setVisible(true);
   }
}


class fractie{
int sus;
int jos;

fractie(){
    jos=1;
    sus=1;
}
fractie(int numa,int numi){
    sus=numa;
    jos=numi;
}
public int numitorComun(int n1,int n2){
    int n=n1*n2;
    if(n1==n2)return n1;
    for(int i=2;i<=n;i++){
        if(i%n1==0&&i%n2==0)return i;
    }
    return 1;
}
public fractie aduna(fractie doi){
    int z=numitorComun(jos,doi.jos);
    int aux1=sus*(z/jos);
    int aux2=doi.sus*(z/doi.jos);
    this.sus=aux1+aux2;
    this.jos=numitorComun(jos,doi.jos);
    return this;
}
public fractie scade(fractie doi){
    int z=numitorComun(jos,doi.jos);
    int aux1=doi.sus*(z/jos);
    int aux2=sus*(z/doi.jos);
    this.sus=(-aux1+aux2);
    this.jos=numitorComun(jos,doi.jos);
    return this;
}
public int getSus(){
    return sus;
}
public int getJos(){
    return jos;
}
public void simplificare(){
    int z=sus*jos;
    for(int j=z;j>0;j--){
        if(sus%j==0&&jos%j==0){
            sus=sus/j;
            jos=jos/j;
        }
    }
}
public void setf(int numarator,int numitor){
    sus=numarator;
    jos=numitor;
}
}
class polinom extends fractie{
    public polinom[] pol;
    public int length;
    public polinom(){
        super();
        pol= new polinom[1];
        pol[0]=this;  
        length=1;
    }
    public polinom(int x){
        super();
        pol=new polinom[x];
        pol[0]=this;
        length=x;
        for(int i=1;i<pol.length;i++){
            pol[i]=new polinom();
        }
    }
    public void setPolinom(int n,int nsus,int njos){
        pol[n].setf(nsus, njos);
    }
    public polinom adun(polinom x){
        int z=x.length;
        polinom tmp= new polinom(z);
        for(int i=0;i<z;i++){
               fractie temp1=new fractie(pol[i].sus,pol[i].jos);
               fractie temp2=new fractie(x.pol[i].sus,x.pol[i].jos);
               fractie temp=temp1.aduna(temp2);
              // temp.simplificare();
               tmp.pol[i].sus=temp.getSus();
               tmp.pol[i].jos=temp.getJos();
        }
        return tmp;
    }
    public polinom scad(polinom x){
        int z=x.length;
        polinom tmp= new polinom(z);
        for(int i=0;i<z;i++){
               fractie temp1=new fractie(pol[i].sus,pol[i].jos);
               fractie temp2=new fractie(x.pol[i].sus,x.pol[i].jos);
               fractie temp=temp1.scade(temp2);
               //temp.simplificare();
               tmp.pol[i].sus=temp.getSus();
               tmp.pol[i].jos=temp.getJos();
               
        }
        return tmp;
    }
}
class ComPolFram extends JFrame{
    public ComPolFram(){
        this.setTitle("Complex Poligon");        this.setDefaultCloseOperation(
JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocation(300, 200);
     Box Hbox1 = Box.createHorizontalBox();
        Hbox1.add(new JLabel("n="));
        nn = new JTextField(10);        nn.setMaximumSize(nn.getPreferredSize());
        Hbox1.add(nn);
        butmac("add",Hbox1);
        butmac("+",Hbox1);
        butmac("-",Hbox1);
        Hbox2 = Box.createHorizontalBox();
        Hbox3 = Box.createHorizontalBox();
        Hbox4 = Box.createHorizontalBox();
        Hbox5 = Box.createHorizontalBox();
        Hbox6 = Box.createHorizontalBox();
        Hbox7 = Box.createHorizontalBox();
        Box Vbox = Box.createVerticalBox();
        Vbox.add(Hbox1);
        Vbox.add(Hbox2);
        Vbox.add(Hbox3);
        Vbox.add(Hbox4);
        Vbox.add(Hbox5);
        Vbox.add(Hbox6);
        Vbox.add(Hbox7);
        add(Vbox,BorderLayout.CENTER);
        //this.pack();
    }
    private JTextField nn;
    private JTextField[] s1,s2;
    private JTextField[] j1,j2;
  private Box Hbox2,Hbox3,Hbox4,Hbox5,Hbox6,Hbox7;
    private void butmac(String s,Box b){
       JButton but = new JButton(s);
       but.addActionListener(
new ActionListener(){
 public void actionPerformed(ActionEvent e){ System.out.println(e.getActionCommand());
    int n = Integer.parseInt(nn.getText());
       if (e.getActionCommand()=="add"){
                Hbox2.removeAll();
                Hbox3.removeAll();
                Hbox4.removeAll();
                Hbox5.removeAll();
                Hbox6.removeAll();
                Hbox7.removeAll();
                s1 = new JTextField[n];
                s2 = new JTextField[n];
                j1 = new JTextField[n];
                j2 = new JTextField[n];              
                for(int i=n-1;i>=0;i--){
                    if(i==0){
                        
            s1[i] = new JTextField(2);                    s1[i].setMaximumSize( new Dimension(25, 20));
            s2[i] = new JTextField(2);                    s2[i].setMaximumSize( new Dimension(25, 20));
            j1[i] = new JTextField(2);                    j1[i].setMaximumSize( new Dimension(25, 20));
            j2[i] = new JTextField(2);                    j2[i].setMaximumSize( new Dimension(25, 20));
                    Hbox2.add(s1[i]);
                    Hbox3.add(j1[i]);
                    Hbox4.add(s2[i]);
                    Hbox5.add(j2[i]);
                }else{
                        Dimension x =new Dimension();
            s1[i] = new JTextField(2);                    s1[i].setMaximumSize( new Dimension(25, 20));
            s2[i] = new JTextField(2);                    s2[i].setMaximumSize( new Dimension(25, 20));
            j1[i] = new JTextField(2);                    j1[i].setMaximumSize( new Dimension(25, 20));
            j2[i] = new JTextField(2);                    j2[i].setMaximumSize( new Dimension(25, 20));
                    Hbox2.add(s1[i]);
                    Hbox2.add(new JLabel("x"+i));
                    Hbox3.add(j1[i]);
                    Hbox3.add(new JLabel("     "));
                    Hbox4.add(s2[i]);
                    Hbox4.add(new JLabel("x"+i));
                    Hbox5.add(j2[i]);
                    Hbox5.add(new JLabel("     "));
                        }
                }
                pack(); }
else 
if(e.getActionCommand()=="+" || e.getActionCommand()=="-")
{ 
                    Hbox6.removeAll();
                    Hbox7.removeAll();
                    polinom pol1 = new polinom(n);
        for (int i=0;i<n;i++){
 pol1.setPolinom(i, Integer.parseInt(s1[i].getText()),Integer.parseInt(j1[i].getText()));
                    }
polinom pol2 = new polinom(n);
       for (int i=0;i<n;i++){
 pol2.setPolinom(i, Integer.parseInt(s2[i].getText()),Integer.parseInt(j2[i].getText()));
                    }
          polinom  pol3;
  if(e.getActionCommand()=="+"){
   pol3 = pol1.adun(pol2);
                    }
    else{
   pol3 = pol1.scad(pol2);
                    } 
  for(int i=n-1;i>=0;i--){
      if(i==0){
         Hbox6.add(new JLabel(Integer.toString( pol3.pol[i].sus)));
         Hbox7.add(new JLabel(Integer.toString(pol3.pol[i].jos)));
      }else{
        Hbox6.add(new JLabel(Integer.toString( pol3.pol[i].sus)+"x"+Integer.toString(i)+" "));
        Hbox7.add(new JLabel(Integer.toString(pol3.pol[i].jos)+"    "));
      }
  }
                    pack();
                }}});
       b.add(but);
   }}