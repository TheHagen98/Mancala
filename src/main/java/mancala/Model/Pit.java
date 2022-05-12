package mancala.Model;

import java.util.ArrayList;

public class Pit extends Sprite {
    ArrayList<Seed> seeds;

    Pit(ArrayList<Seed> seeds) {

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
}
