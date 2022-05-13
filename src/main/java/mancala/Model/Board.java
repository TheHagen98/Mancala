package mancala.Model;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.round;

public class Board extends Sprite {

    private int width,height;
    ArrayList<Pit> pits = new ArrayList<>(14);

    public Board(ArrayList<Pit> pits, int x, int y, int width, int height) {
        this.pits=pits;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;


    }

    public ArrayList<Pit> getPits() {
        return pits;
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(95,70,60));
        graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);

        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(8.0f));
        graphics2D.drawRoundRect(x-width/2,y-height/2,width,height,50,30);


    }
}
