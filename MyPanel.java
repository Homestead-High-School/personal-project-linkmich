import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
    private Graphics2D g2D;
    MyPanel() {
       this.setPreferredSize(new Dimension(500,500)); 
    }
    
    public void paint(Graphics g) {
        g2D = (Graphics2D) g;

        g2D.setPaint(Color.green);
        g2D.setStroke(new BasicStroke(5));
        //g2D.drawLine(0,0,500,500); //Draws line
        //g2D.drawRect(0, 0, 100, 200); //Draws rect
        g2D.fillRect(0, 200, 500, 500); //Draws and fills in rect
        g2D.setPaint(Color.blue);
        g2D.fillRect(0, 0, 500, 200);
        g2D.setPaint(Color.orange);
        g2D.fillOval(0,0,100,100); //Sun in top left
        cloud(g2D);
        
    }

    public Graphics2D getg2D() {
        return g2D;
    }
    public void cloud(Graphics g) {
        g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawArc(162,100,25,25,90,180);
        g2D.fillArc(162,100,25,25,90,180);
        g2D.drawArc(175,83,25,25,0,180);
        g2D.fillArc(175,83,25,25,0,180);
        g2D.drawArc(188,100,25,25,-90,180);
        g2D.fillArc(188,100,25,25,-90,180);
        g2D.fillRect(175,96,27,27);
        g2D.drawLine(175, 125, 200, 125);
    }
}
