import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameFrame implements Runnable {
    private GamePanel g;
    private BufferedImage image;

    public GameFrame(String name) {
        // make the frame
        JFrame gameFrame = new JFrame();

        // make and add the panel
        g = new GamePanel(gameFrame, name);
        gameFrame.add(g);

        gameFrame.setSize(g.getStartImg().getWidth(),g.getStartImg().getHeight());



        // display and add the panel
        gameFrame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();


        try {
            image = ImageIO.read(new File("src/hammer.jpeg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0), "customCursor");
        Cursor c = toolkit.createCustomCursor(image , new Point(gameFrame.getX(), gameFrame.getY()), "img");
        gameFrame.setCursor(c);
    }

    public void run() {
        while (true) {
            g.repaint();
        }
    }

}