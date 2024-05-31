import javax.swing.*;

public class GameFrame {

    public GameFrame() {
        JFrame gameFrame = new JFrame();
        GamePanel g = new GamePanel(gameFrame);
        gameFrame.setSize(g.getStartImg().getWidth(),g.getStartImg().getHeight());
        gameFrame.add(g);
        gameFrame.setVisible(true);
    }
}
