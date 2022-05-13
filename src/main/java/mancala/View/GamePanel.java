package mancala.View;

import mancala.Controller.GameController;
import mancala.Model.Pit;
import mancala.Model.Seed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {

    private GameController gameController=new GameController(this);
    private Pit target=null;


    public GamePanel(){
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setBackground (new Color(232,211,185));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g.create();
        super.paintComponent(g);
        gameController.getBoard().draw(graphics2D);
        for (Pit item: gameController.getPits()) {
            item.draw(graphics2D);
            if (item.getId()!=GameController.STORE_1 && item.getId()!=GameController.STORE_2/*&& item.getSeedCount()>0*/ ){
                Seed.draw(graphics2D,item.getX(),item.getY(),25);

            }

        }


        //controller.getPlayer().drawPlayer(g2d);
        //drawGUI(g2d);

        drawGUI(graphics2D);
    }

    public void drawGUI (Graphics2D graphics2D){

        if (target!=null)
        {
            graphics2D.setColor(new Color(255, 190, 0)); //TODO játékos vizsgálat


            graphics2D.drawOval(target.getX()- target.getRadius()+GameWindow.width/144,target.getY()- target.getRadius()-GameWindow.height/192,2* target.getRadius()- GameWindow.width/72,2* target.getRadius()+GameWindow.height/96);
        }

        Font font = new Font("Arial", Font.PLAIN, 24);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.BLACK);
        drawCenteredString(gameController.getMessage(), GameWindow.width,GameWindow.height/5,graphics2D);

    }

    private void drawCenteredString(String s, int w, int h, Graphics2D g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.target!=null)
        {
            System.out.println(target.getId());
            gameController.setClickedPit(target);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boolean targeted = false;
        for (Pit item: gameController.getPits()) {
            if (item.getId()==GameController.STORE_1){

            } else if (item.getId()==GameController.STORE_2) {

            } else {
                if (sqrt(pow(item.getX()-e.getX(),2)+pow(item.getY()-e.getY(),2))<=item.getRadius()){
                    targeted=true;
                    this.target=item;
                    break;
                }
            }
        }
        if (!targeted){
            this.target=null;
        }
        repaint();
    }
}
