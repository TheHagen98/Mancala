package mancala.Model;

import java.util.ArrayList;

public class Board extends Sprite {
    ArrayList<Pit> pits = new ArrayList<>(12);
    ArrayList<Pit> stores = new ArrayList<>(2);

    protected Board(ArrayList<Pit> pits, ArrayList<Pit> stores) {

    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Pit> getStores() {
        return stores;
    }

}
