import javax.swing.*;
import java.awt.*;

public class GameFrame implements Runnable {
    private GamePanel g;

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

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/handwriting.gif");
        Component mainPane = null;
        Cursor c = toolkit.createCustomCursor(image , new Point(mainPane.getX(),
                mainPane.getY()), "img");
        mainPane.setCursor (c);
    }

    public void run() {
        while (true) {
            g.repaint();
        }
    }
}