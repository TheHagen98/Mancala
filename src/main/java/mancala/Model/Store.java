package mancala.Model;

import mancala.Controller.GameController;

import java.awt.*;
import java.util.ArrayList;

public class Store extends Pit{

    private int width, height;

    ArrayList<Seed> seeds;

    public Store(ArrayList<Seed> seeds,int x,int y, int width, int height) {
        super(seeds,x,y);
        this.width=width;
        this.height=height;

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (id== GameController.STORE_1) {
            graphics2D.setColor(new Color(65, 95, 120));
            graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);
        }
        else if (id==GameController.STORE_2) {
            graphics2D.setColor(new Color(105, 46, 46));
            graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);
        }


        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(5.0f));
        graphics2D.drawRoundRect(x-width/2,y-height/2,width,height,50,30);

        Font font = new Font("Arial", Font.PLAIN, 24);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(String.valueOf(getSeedCount()), x-5, y+5);

    }
}
