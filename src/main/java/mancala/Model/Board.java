package mancala.Model;

import java.awt.*;
import java.util.ArrayList;

public class Board extends Sprite {

    private int width, height;

    ArrayList<Pit> pits = new ArrayList<>(12);
    ArrayList<Pit> stores = new ArrayList<>(2);

    public Board(ArrayList<Pit> pits, ArrayList<Pit> stores, int x, int y, int width, int height) {
        this.pits=pits;
        this.stores=stores;
        this.x=x;
        this.y=y;


    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Pit> getStores() {
        return stores;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(95,70,60));
        graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);

        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(10.0f));
        graphics2D.drawRoundRect(x-width/2,y-height/2,width,height,50,30);
    }
}
