import java.awt.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class GamePanel extends JPanel implements ActionListener, MouseListener{
    private BufferedImage background;
    private Rectangle[] board;
    private JFrame enclosingFrame;
    private Player gamer;
    public GamePanel(JFrame f, String name) {
        System.out.println(name);
        enclosingFrame = f;
        try {
            background = ImageIO.read(new File("src/gamebackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        board = new Rectangle[9];
        board[0] = new Rectangle(0, 0, 1000, 1000);
        gamer = new Player(name);
        addMouseListener(this);
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
