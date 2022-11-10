import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener, MouseListener{

    JLabel label;
    ImageIcon icon;
    MyPanel panel;
    MyFrame(){

        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        
        icon = new ImageIcon("Tetris.ppng.png");

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.blue);
        label.setOpaque(true);
        this.addMouseListener(this);
        //label.setIcon(icon);
        //label.setBackground(Color.red);
        //label.setOpaque(true);
        

        this.getContentPane().setBackground(Color.black);
        this.add(label);
        this.setVisible(true);


    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'a': label.setLocation(label.getX()-10,label.getY());
            break;
            case 's': label.setLocation(label.getX(), label.getY()+10);
            break;
            case 'w': label.setLocation(label.getX(), label.getY()-10);
            break;
            case 'd': label.setLocation(label.getX()+10, label.getY());
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37: label.setLocation(label.getX()-10,label.getY());
            break;
            case 40: label.setLocation(label.getX(), label.getY()+10);
            break;
            case 38: label.setLocation(label.getX(), label.getY()-10);
            break;
            case 39: label.setLocation(label.getX()+10, label.getY());
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setBackground(Color.yellow);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setBackground(Color.white);        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setBackground(Color.red);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setBackground(Color.green);        
    }
}