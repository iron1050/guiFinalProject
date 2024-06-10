import java.awt.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;
public class GamePanel extends JPanel implements ActionListener, MouseListener{
    private BufferedImage background;
    private BufferedImage mole;
    private Rectangle[] board;
    private JFrame enclosingFrame;
    private Player gamer;
    private Point[] points;
    public GamePanel(JFrame f, String name) {
        System.out.println(name);
        enclosingFrame = f;
        try {
            background = ImageIO.read(new File("src/gamebackground.png"));
            mole = ImageIO.read(new File("src/moleImage.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        board = new Rectangle[6];
        points = new Point[6];
        board[0] = new Rectangle(88, 189, 200, 200);
        board[1] = new Rectangle(535, 189, 200, 200);
        board[2] = new Rectangle(945, 189, 200, 200);
        board[3] = new Rectangle(88, 517, 200, 200);
        board[4] = new Rectangle(535, 517, 200, 200);
        board[5] = new Rectangle(945, 517, 200, 200);
        gamer = new Player(name);
        addMouseListener(this);
    }

    private void popUp() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        int pos = (int) (Math.random() * points.length);

    }
    public void actionPerformed(ActionEvent e) {

    }
    public BufferedImage getStartImg() {
        return background;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,null);
        g.drawString("Name: " + gamer.getName(), 15, 45);
        g.drawString("Score: " + gamer.getScore(), 15,60);
        g.drawString(getMousePosition().getX() + ", " + getMousePosition().getY(), 15, 75);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        int pos = (int) (Math.random() * points.length);
        g.drawImage()
    }



    public boolean isInRect(MouseEvent e) {
        for(Rectangle r : board) {
            if(r.contains(new Point(e.getX(),e.getY()))) {
                return true;
            }
        }
        return false;
    }

    public void eventListener(MouseEvent e) {
        if(isInRect(e)) {
            System.out.println("word");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(isInRect(e)) {
            gamer.iterateScore();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
