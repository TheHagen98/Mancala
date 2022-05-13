package mancala.View;

import mancala.Controller.GameController;
import mancala.Model.Pit;
import mancala.Model.Seed;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameController gameController=new GameController(this);



    public GamePanel(){
        setFocusable(true);
        this.setBackground (new Color(232,211,185));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintComponent(g);
        gameController.getBoard().draw(g2d);
        for (Pit item: gameController.getPits()) {
            item.draw(g2d);
        }

        Seed.draw(g2d,GameWindow.width/2,GameWindow.height/2,5);
        //controller.getPlayer().drawPlayer(g2d);
        //drawGUI(g2d);

        drawGUI(g2d);
    }

    public void drawGUI (Graphics2D g2d){
        Font font = new Font("Arial", Font.PLAIN, 24);
        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString("GUI", 15,30);
    }
}
