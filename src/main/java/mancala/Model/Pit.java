package mancala.Model;

import java.awt.*;
import java.util.ArrayList;

public class Pit extends Sprite {
    ArrayList<Seed> seeds;
    private  int radius;
    private  int id;
    private static int ID=0;
    Pit(ArrayList<Seed> seeds, int radius) {
        this.seeds=seeds;
        this.radius=radius;
        this.id=Pit.ID++;
    }

    Pit(ArrayList<Seed> seeds) {
        this.seeds=seeds;
        this.id=Pit.ID++;
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

    public int getSeedCount() {
        return seeds.size();
    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }
}
