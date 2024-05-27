import java.awt.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class GamePanel extends JPanel implements ActionListener{
    private BufferedImage background;
    private Rectangle[] board;
    private int score;

    public GamePanel(JFrame f) {
        try {
            background = ImageIO.read(new File("src/gamebackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        score = 0;
    }


    public void actionPerformed(ActionEvent e) {

    }
    public BufferedImage getStartImg() {
        return background;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,null);
        g.drawString("Score: " + score, 0,0);
    }
}
