package mancala.Model;

import java.awt.*;
import java.util.UUID;

public class Seed{
    UUID id;


    public Seed(/*int radius*/) {
        UUID id = UUID.randomUUID();
    }

    public static void draw(Graphics2D graphics2D, int x, int y, int radius) {
        graphics2D.setColor(new Color(200, 180, 175));
        graphics2D.fillOval(x-radius,y-radius,2*radius,2*radius);

        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(1.0f));
        graphics2D.drawOval(x-radius,y-radius,2*radius,2*radius);
    }
}
