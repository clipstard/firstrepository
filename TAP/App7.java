import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class App7 extends JFrame{
    public App7(){
        initComponents();
    }
        JLabel title = new JLabel();
    JLabel result= new JLabel("Rezultat:");
    JLabel errors = new JLabel();
    JTextField pol1 = new JTextField();
    JTextField pol2 =new JTextField();
    JTextArea text_result = new JTextArea();
    JButton go = new JButton("Calculeaza");
    JButton clear = new JButton("Sterge");
    JLabel text1 = new JLabel("polinom 1:");
    JLabel text2 = new JLabel("polinom 2:");
    JLabel additional = new JLabel("                    ");
void initComponents(){
    text_result.setFocusable(false);
    text_result.setOpaque(false);
    text_result.setText("");
    text_result.setCursor(Cursor.getDefaultCursor());
    additional.setForeground(Color.ORANGE);
    title.setText("Introduceti datele separate prin spatiu");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    pol1.setText("1 3 5 7");
    pol2.setText("2 2 5 5");
    pol1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt) {
            pol1.selectAll();
        }
    });
     pol2.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt) {
            pol2.selectAll();
        }
    });
     this.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent evt){
         pol1.select(pol1.getText().length(), pol1.getText().length());
         pol2.select(pol2.getText().length(), pol2.getText().length());
     }
     });
          text_result.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent evt){
         pol1.select(pol1.getText().length(), pol1.getText().length());
         pol2.select(pol2.getText().length(), pol2.getText().length());
     }
     });
    errors.setText("");
     go.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent evt) {
                goClick(evt);
            } });
       clear.addMouseListener(new MouseAdapter() {
       public void mouseClicked(MouseEvent evt) {
                clearClick(evt);
            }});
       GroupLayout layout = new GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        .addComponent(errors, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        .addComponent(title)
        .addGroup(layout.createSequentialGroup().addComponent(text1).addGap(10,10,10).addComponent(pol1, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup().addComponent(text2).addGap(10,10,10).addComponent(pol2,GroupLayout.DEFAULT_SIZE,296,Short.MAX_VALUE))
.addGroup(layout.createSequentialGroup()
        .addComponent(go).addGap(18, 18, 18)
        .addComponent(clear))
        .addGroup(layout.createSequentialGroup().addComponent(result).addGap(10,10,10).addComponent(text_result, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(additional))
                .addContainerGap()) );
       layout.setVerticalGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup().addGap(54, 54, 54)
.addComponent(title).addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup().addComponent(text1)
.addComponent(pol1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup().addComponent(text2).addComponent(pol2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
.addComponent(errors).addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup().addComponent(result).addComponent(text_result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addComponent(additional)
.addGroup( layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
.addComponent(go).addComponent(clear))
.addContainerGap(25, Short.MAX_VALUE)));
       pack();
}
public void goClick(MouseEvent evt){
List<Integer> item1 = new ArrayList<>();
List<Integer> item2 = new ArrayList<Integer>();
List<Integer> item3 = new ArrayList<Integer>();
int len=0;
String str1[],str2[];
try{
    if(pol1.getText().matches("[0-9 ]+")==false){
        throw new Exception("Inscrierea 1 Contine erori");
    }else if(pol2.getText().matches("[0-9 ]+")==false){
        throw new Exception("Inscrierea 2 Contine erori");
    }else{
 str1 = pol1.getText().split(" ");
 str2 = pol2.getText().split(" ");
 try{
     if(str1.length!=str2.length) throw new newEx("Marimi diferite");
     else{
        len=str1.length;
        for(int i=0;i<len;i++){
            item1.add(Integer.parseInt(str1[i]));
            item2.add(Integer.parseInt(str2[i]));
            item3.add(item1.get(i)*item2.get(i));
        }
        String line="";
        String addto="                    ";
        Iterator it = item3.iterator();
                    Integer l =len;
        while(it.hasNext()){
            l--;
            if(l>1){
            line+=" "+it.next().toString()+"  ";
            addto+="x"+l.toString()+" ";
            }else if(l==1){

            line+=" "+it.next().toString()+"  ";
            addto+=" x"+"  ";
            }else {
                line+=it.next().toString()+"  ";
            addto+="   ";
            }
        }
        text_result.setText(line);
        additional.setText(addto);
     }
 }catch(newEx o){
     errors.setText(o.getMessage());
    errors.setForeground(Color.red);
 }
    } 
}catch(Exception e){
    errors.setText(e.getMessage());
    errors.setForeground(Color.red);
}
}
public void clearClick(MouseEvent evt){
    errors.setText("");
    text_result.setText("");
    pol1.setText("");
    pol2.setText("");
    pol1.requestFocus();
}
public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App7().setVisible(true);
            }});}
}
class newEx extends Exception{
    newEx(String message){
        super(message);
    }
}
