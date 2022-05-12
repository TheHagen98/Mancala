package mancala.Model;

import java.awt.*;
import java.util.ArrayList;

public class Store extends Pit{

    private int width, height;

    ArrayList<Seed> seeds;

    Store(ArrayList<Seed> seeds) {
        super(seeds);

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (id==6) {
            graphics2D.setColor(new Color(65, 95, 120));
            graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);
        }
        else if (id==13) {
            graphics2D.setColor(new Color(100, 60, 60));
            graphics2D.fillRoundRect(x-width/2,y-height/2,width,height,50,30);
        }


        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(10.0f));
        graphics2D.drawRoundRect(x-width/2,y-height/2,width,height,50,30);

    }
}
