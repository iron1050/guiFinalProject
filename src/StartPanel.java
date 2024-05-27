import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class StartPanel extends JPanel implements ActionListener{
    private JButton startButton;
    private String playerName;
    private JTextField textField;
    private BufferedImage startImg;
    private JFrame enclosingFrame;


    public StartPanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            startImg = ImageIO.read(new File("src/what-did-he-say-v0-wuj6j0idns2d1.jpeg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        startButton = new JButton("Start");
        textField = new JTextField(10);
        add(startButton);
        add(textField);
        startButton.addActionListener(this);
        textField.addActionListener(this);
    }

    public BufferedImage getStartImg() {
        return startImg;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            GameFrame ga = new GameFrame();
            enclosingFrame.setVisible(false);
            return;
        }

        if(e.getSource() instanceof JTextField) {
            playerName = textField.getText();
            GameFrame g = new GameFrame();
            enclosingFrame.setVisible(false);

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
        g.drawImage(startImg, 0, 0, null);
        startButton.setLocation(500,547);
        textField.setLocation(570,550);
    }



}
