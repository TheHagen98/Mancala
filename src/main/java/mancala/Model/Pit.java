package mancala.Model;

import mancala.View.GameWindow;

import java.awt.*;
import java.util.ArrayList;

public class Pit extends Sprite {
    ArrayList<Seed> seeds;
    private int radius;
    protected int id;
    protected static int ID = 0;
    public Pit(ArrayList<Seed> seeds, int x, int y, int radius) {
        this.seeds = seeds;
        this.x=x;
        this.y=y;
        this.radius = radius;
        this.id = Pit.ID++;
    }

    Pit(ArrayList<Seed> seeds,  int x, int y) {
        this.seeds = seeds;
        this.x=x;
        this.y=y;
        this.id = Pit.ID++;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public void addSeed(Seed seed) {
        seeds.add(seed);
    }

    public void removeSeed(Seed seed) {
        seeds.remove(seed);
    }

    public void removeSeed(int seedIndex) {
        seeds.remove(seedIndex);
    }

    public void removeSeeds() {
        seeds.removeAll(seeds);
    }

    public int getSeedCount() {
        return seeds.size();
    }

    public int getId() {
        return id;
    }

    public int getRadius() { return  radius; }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(105, 80, 70));
        graphics2D.fillOval(x-radius+GameWindow.width/144,y-radius-GameWindow.height/192,2*radius- GameWindow.width/72,2*radius+GameWindow.height/96);

        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(4.0f));
        graphics2D.drawOval(x-radius+GameWindow.width/144,y-radius-GameWindow.height/192,2*radius- GameWindow.width/72,2*radius+GameWindow.height/96);
    }

    public void drawNumber(Graphics2D graphics2D) {
        if (id!=6&&id!=13)
        {
            Font font = new Font("Arial", Font.PLAIN, 24);
            graphics2D.setFont(font);
            graphics2D.setColor(Color.black);
            graphics2D.drawString(String.valueOf(getSeedCount()), x,y);
        }

    }

}
