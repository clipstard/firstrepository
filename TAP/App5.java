import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class App5 extends JPanel implements KeyListener{
    
    public static void main(String[] args) {
        JFrame grid = new JFrame();

        grid.getContentPane().add(new  App5());
        grid.setSize(350, 400);
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setVisible(true);
    }
    public App5(){
        addKeyListener(this);
    }
int i=0;
Color myColor=Color.LIGHT_GRAY;
     int[] xSin = {120, 180, 180, 120};
        int[] ySin = {130, 130, 170, 170};
        int[] xb={0,300,300,0};
        int[] yb={0,0,300,300};
        int[] corner={xSin[0],ySin[0]};
        int cornerIndex=0;
               public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D gg= (Graphics2D) g;
        g2d.drawPolygon(xSin, ySin, xSin.length);
        g2d.drawString("Space = Change corner", 50, 40);
        g2d.drawString("Enter = Change color", 50, 60);
        g2d.rotate(Math.toRadians(--i*0.5), corner[0], corner[1]);
        g2d.drawPolygon(xSin, ySin, xSin.length);
        g2d.setColor(myColor);
        g2d.fillPolygon(xSin, ySin, xSin.length);
        repaint();        
}    

  public void keyReleased(KeyEvent evt) {
  }
  public void keyTyped(KeyEvent evt) {
  }
  public boolean isFocusTraversable() {
    return true;
  }
   public void keyPressed(KeyEvent e){
    int key=e.getKeyCode();
    if(key==KeyEvent.VK_SPACE){
        if(cornerIndex<3){
                       corner[0]=xSin[++cornerIndex];
                       corner[1]=ySin[cornerIndex];
                   }else{
                       cornerIndex=0;
                       corner[0]=xSin[cornerIndex];
                       corner[1]=ySin[cornerIndex];
    }
}else if(key==KeyEvent.VK_ENTER){
          myColor = selector();
    }   
    }
   Color selector(){
Color[] Col={Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,Color.ORANGE,Color.GREEN,Color.YELLOW,Color.PINK};
Random generator = new Random();
int j = generator.nextInt(256);
Random generator2 = new Random();
int l = generator2.nextInt(256);
Random generator3 = new Random();
int k = generator3.nextInt(256);
Color col= new Color(j,l,k);
       return col;
   }
}
