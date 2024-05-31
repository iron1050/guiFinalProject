import javax.swing.*;

public class StartFrame {
    public StartFrame() {
        JFrame frame = new JFrame("Welcome to our game!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel panel = new StartPanel(frame);
        frame.setSize(panel.getStartImg().getWidth(),panel.getStartImg().getHeight());
        frame.setLocation(300,500);
        frame.add(panel);
        frame.setVisible(true);

    }


}
