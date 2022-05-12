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

    }

    protected boolean checkMove() {
        return false;
    }

    protected void move(ArrayList<Seed> seed, Pit target) {

    }

    protected boolean isEndOfGame() {
        return false;
    }

    protected void endOfGame() {

    }
}
