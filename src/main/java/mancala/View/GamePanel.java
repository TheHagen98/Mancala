package mancala.View;

import mancala.Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameController gameController;
    private Integer x,y;

    public GamePanel(Integer x, Integer y){
        setFocusable(true);
        this.setBackground (new Color(232,211,185));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintComponent(g);
        //controller.getRoom().drawRoom(g2d);
        //controller.getPlayer().drawPlayer(g2d);
        drawGUI(g2d);


    }

    public void drawGUI (Graphics2D g2d){
        Font font = new Font("Arial", Font.PLAIN, 24);
        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString("GUI", 15,30);
    }
}
