package mancala.Controller;

import mancala.Model.Board;
import mancala.Model.Pit;
import mancala.Model.Player;
import mancala.Model.Seed;

import javax.swing.*;
import java.util.ArrayList;

public class GameController {
    ArrayList<Seed> seeds;
    ArrayList<Pit> pits;
    Board board;
    Player[] players = new Player[2];
    JPanel gamePanel; //kell ez?

    protected GameController() {

    }

    protected void newGame() {
        seeds = new ArrayList<>(48);

    }

    /**
     * Checks if the player tries to access his own pit.
     *
     * @return True if possible, false if not allowed.
     */
    protected boolean checkMove(Player player) {
        //return a klikkelt pit tulajdonosa == a player
        return false;
    }

    protected void move(ArrayList<Seed> seed, Pit target) {

    }

    protected boolean isEndOfGame() {
        return false;
    }

    protected void endOfGame() {
        if (isEndOfGame()) {
            //TODO: kihírdetni a nyertest
            System.out.printf("Játék vége, player 1/2 nyert!");
        }
    }
}
