package mancala.Controller;

import mancala.Model.*;
import mancala.View.GameWindow;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Math.round;

public class GameController {
    public static final int STORE_1 = 6;
    public static final int STORE_2 = 13;

    ArrayList<Seed> seeds;
    ArrayList<Pit> pits;
    Board board;
    Player[] players = new Player[2];
    JPanel gamePanel; //kell ez?

    public GameController(JPanel gamePanel) {
        this.gamePanel = gamePanel;
        newGame();
    }

    private void newGame() {
        seeds = new ArrayList<>(48); //
        pits = new ArrayList<>(14);

        //Create pits
        for (int i = 0; i < 14; i++) {
            if (i != STORE_1 && i != STORE_2) {
                Pit pit = new Pit(null, GameWindow.width / 2, GameWindow.height / 2, round(GameWindow.height / 8f));
                pits.add(pit);
            } else if (i == STORE_1) {
                Store pit = new Store(null, round(GameWindow.width / 6.15f), GameWindow.height / 2, round(GameWindow.width / 7f), round(GameWindow.height / 1.9f));
                pits.add(pit);
            } else {
                Store pit = new Store(null, GameWindow.width - round(GameWindow.width / 6.15f), GameWindow.height / 2, round(GameWindow.width / 7f), round(GameWindow.height / 1.9f));
                pits.add(pit);
            }
        }

        board = new Board(pits, GameWindow.width / 2, GameWindow.height / 2, round(GameWindow.width / 1.2f), round(GameWindow.height / 1.8f));
        gamePanel.repaint();
    }

    /**
     * Checks if the player tries to access his own pit.
     *
     * @param player The player we want to check.
     * @return True if possible, false if not allowed.
     */
    public boolean checkMove(Player player) {
        //return a klikkelt pit tulajdonosa == a player
        return false;
    }

    protected void move(Pit start) {
        if (start.getId() == STORE_1 && start.getId() == STORE_2) { // a két store ID-ja
            System.out.println("Can't move seeds from store!");
        } else {
            for (int i = 0; i < start.getSeedCount(); i++) {
                ArrayList<Seed> seeds = start.getSeeds();
                pits.get(start.getId() + i).addSeed(seeds.get(i));
                start.removeSeeds();
            }
        }

    }

    private void gameLoop() {
        while (!isEndOfGame()) {
            //player1 rákattint egy pitre, végigpottyantja a seedeket -> move()
            //TODO: checkCapture()
            //TODO: checkLandInStore() --> ha true, akkor jöhet megint
            //player 2-re átkerül a lépés
            //player2 rákattint egy pitre, végigpottyantja a seedeket
            //player1-re átkerül a lépés
        }

    }

    void checkCapture(Pit start) {

    }

    /**
     * Checks if the given pit will land in a store.
     *
     * @param start The selected pit
     * @return True if it will land in a store, false if not.
     */
    void checkLandInStore(Pit start) {
        int checkedID = (start.getId() + start.getSeedCount()) % 14;

        if (checkedID == STORE_1 || checkedID == STORE_2) { //A két store ID-ja
            //landInStore(start);
            //TODO: mégegy move vagy hogy
            move(start);
            System.out.println("Mégegyszer jöhetsz!");
        }
    }

    /**
     *
     */
    /*void landInStore(Pit start) { //FIXME: vagy csak akkor hívódjon meg hogyha a checkLandInStore() az true és meghívja ezt?
        // if (true) { //TODO: az utolsó seed a store-ba esik


        //mégegyszer jöhet
        // }
    }*/

    void capture() {
        //ha az utolsó kő pont saját üres pitbe esik
        //-->
        // megkapom a szemben lévő pitből az összes seedet

    }

    public boolean isEndOfGame() {
        return false;
    }

    public void endOfGame() {
        if (isEndOfGame()) {
            //TODO: kihírdetni a nyertest
            System.out.println("Játék vége, player 1/2 nyert!");
        }
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public Board getBoard() {
        return board;
    }

}
