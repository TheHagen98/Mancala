package mancala.Model;

import java.awt.*;
import java.util.ArrayList;

public class Pit extends Sprite {
    ArrayList<Seed> seeds;
    private  float radius;
    Pit(ArrayList<Seed> seeds, float radius) {
        this.seeds=seeds;
        this.radius=radius;
    }

    Pit(ArrayList<Seed> seeds) {
        this.seeds=seeds;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    protected void addSeed(Seed seed) {
        seeds.add(seed);
    }

    protected void removeSeed(Seed seed) {
        seeds.remove(seed);
    }

    protected void removeSeed(int seedIndex) {
        seeds.remove(seedIndex);
    }

    protected int getSeedCount() {
        return seeds.size();
    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }
}
