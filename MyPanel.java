import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.Timer;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{
    private Graphics2D g2D;
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image stick;
    javax.swing.Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 75;
    int y = 325;
    int birdX = 102;
    int birdY = 150;
    int birdXVelo = 1;
    int birdYVelo = 1;
    MyPanel() {
       this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT)); 
       stick = new ImageIcon("stickMan.png").getImage(); 
       timer = new javax.swing.Timer(10, this);
       timer.start();
    }

    
    public void paint(Graphics g) {
        g2D = (Graphics2D) g;

        background();
        g2D.setPaint(Color.orange);
        g2D.fillOval(0,0,100,100); //Sun in top left
        g2D.setPaint(Color.black);
        g2D.setFont(new Font("Ink Free", Font.BOLD, 12));
        g2D.drawString("The", 40, 47);
        g2D.drawString("Sun", 40, 64);
        cloud(182, 140, 25, 25, 90, 180);
        cloud(375, 50, 25,25, 90,180);
        cloud(276, 89, 25,25, 90,180);
        cloud(123, 47, 25,25, 90,180);
        g2D.drawImage(stick, x, y, 75, 75, null);
        bird();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= PANEL_WIDTH-75 || x < 0) {
            xVelocity *= -1;
        }
        x += xVelocity;
        if(birdX >= PANEL_WIDTH-24|| birdX < 0) {
            birdXVelo *= -1;
        }
        birdX += birdXVelo;
        if(y >= PANEL_HEIGHT-75|| y < 200) {
            yVelocity *= -1;
        }
        y += yVelocity;
        if(birdY > 170 || birdY < 140) {
            birdYVelo *= -1;
        }
        birdY += birdYVelo;
        repaint();
    }

    public Graphics2D getg2D() {
        return g2D;
    }
    public void cloud( int x, int y, int width, int height, int startAng, int endAng) {
        g2D.setPaint(Color.white);
        g2D.drawArc(x,y,width,height,startAng,endAng);
        g2D.fillArc(x,y,width,height,startAng,endAng);
        g2D.drawArc(x+13,y-17,width,height,startAng-90,endAng);
        g2D.fillArc(x+13,y-17,width,height,startAng-90,endAng);
        g2D.drawArc(x+26,y,width,height,-startAng,endAng);
        g2D.fillArc(x+26,y,width,height,-startAng,endAng);
        g2D.fillRect(x+13,y-4,27,32);
        g2D.setColor(Color.black);
        g2D.setFont(new Font("Ink Free",Font.BOLD, 12));
        g2D.drawString("I'm ", x+17, y);
        g2D.drawString("a cloud ", x+5, y+17);
    }

    public void background() {
        g2D.setPaint(new Color(86, 125, 70));
        g2D.setStroke(new BasicStroke(5));
        g2D.fillRect(0, 200, 500, 500);
        g2D.setPaint(Color.blue);
        g2D.fillRect(0, 0, 500, 200);
    }

    public void bird() {
        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawArc(birdX, birdY, 12, 6, 0, 180);
        g2D.drawArc(birdX+12, birdY, 12, 6, 0, 180);
    }

}
