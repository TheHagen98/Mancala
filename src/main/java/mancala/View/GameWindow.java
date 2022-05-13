package mancala.View;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    public static int width=1280;
    public static int height=720;

    public GameWindow() {
        setTitle("Mancala");
        setSize(new Dimension(width, height));
        setResizable(false);
        setLocationRelativeTo(null);

        gamePanel = new GamePanel();
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TODO: mainMenu

        // ide jön a GameWindow
        add(gamePanel);

    }

}
