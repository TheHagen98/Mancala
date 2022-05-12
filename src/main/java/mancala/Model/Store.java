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

    }
}
