package mancala.View;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private Integer x, y;

    public GameWindow() {
        setTitle("Mancala");
        x = 1280;
        y = 720;
        setSize(new Dimension(x, y));
        setResizable(false);
        setLocationRelativeTo(null);

        gamePanel = new GamePanel(x,y);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TODO: mainMenu

        // ide jön a GameWindow
        add(gamePanel);

    }

}
