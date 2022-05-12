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

    public GameController() {
        seeds = new ArrayList<>(48);
    }

    protected void newGame() {
        seeds = new ArrayList<>(48);

    }

    /**
     * Checks if the player tries to access his own pit.
     * @param player The player we want to check.
     * @return True if possible, false if not allowed.
     */
    public boolean checkMove(Player player) {
        //return a klikkelt pit tulajdonosa == a player
        return false;
    }

    protected void move(Pit target) {
        for (int i = 0; i <target.getSeedCount(); i++) {
            ArrayList<Seed> seeds = target.getSeeds();
            pits.get(0).addSeed(seeds.get(i));   //FIXME: nem get(0), hanem mindig a targetIndex++ kell

        }

    }

    protected void gameLoop() {
        while (!isEndOfGame()) {
            //player1 rákattint egy pitre, végigpottyantja a seedeket -> move()
            //TODO: checkCapture()
            //TODO: checkLandInStore()
            //player 2-re átkerül a lépés
            //player2 rákattint egy pitre, végigpottyantja a seedeket
            //player1-re átkerül a lépés
        }

    }

    void checkCapture() {

    }

    void checkLandInStore() {

    }

    void landInStore() {
        if (true) { //TODO: az utolsó seed a store-ba esik
            //mégegyszer jöhet
        }
    }

    void capture() {

    }

    public boolean isEndOfGame() {
        return false;
    }

    public void endOfGame() {
        if (isEndOfGame()) {
            //TODO: kihírdetni a nyertest
            System.out.printf("Játék vége, player 1/2 nyert!");
        }
    }
}
