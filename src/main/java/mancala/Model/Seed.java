package mancala.Model;

import java.awt.*;
import java.util.UUID;

public class Seed extends Sprite {
    UUID id;
    int radius;

    Seed(int radius) {
        UUID id = UUID.randomUUID();
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(200, 180, 175));
        graphics2D.fillOval(x-radius,y-radius,2*radius,2*radius);

        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(5.0f));
        graphics2D.drawOval(x-radius,y-radius,2*radius,2*radius);
    }
}
