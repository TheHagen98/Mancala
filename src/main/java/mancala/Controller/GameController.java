package mancala.Controller;

import mancala.Model.*;
import mancala.View.GameWindow;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Math.round;

public class GameController {
    public static final int STORE_1 = 6;
    public static final int STORE_2 = 13;
    public static final int[] PLAYER1PITS = {0, 1, 2, 3, 4, 5, 6};
    public static final int[] PLAYER2PITS = {7, 8, 9, 10, 11, 12, 13, 13};

    ArrayList<Seed> seeds;
    ArrayList<Pit> pits;
    Board board;
    Player[] players = new Player[2];
    Player currentPlayer;
    Pit clickedPit;
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
     * Checks if the desired move can be made.
     *
     * @param player The player who makes the move.
     * @param start  The pit we want to check.
     * @return True if possible, false if not allowed.
     */
    public boolean checkMove(Player player, Pit start) {
        //ha a klikkelt pit tulajdonosa == a player
        if (start.getId() == STORE_1 && start.getId() == STORE_2) { // a két store ID-ja
            System.out.println("Can't move seeds from store!");
            return false;
        } else if (start.getSeedCount() == 0) {
            System.out.println("Can't move seeds from an empty pit!");
            return false;
        } else {
            move(start);
        }

        return true;
    }

    protected void move(Pit start) {
        for (int i = 0; i < start.getSeedCount(); i++) {
            ArrayList<Seed> seeds = start.getSeeds();
            pits.get(start.getId() + i).addSeed(seeds.get(i));
            start.removeSeeds();
        }
    }

    private void gameLoop() {
        while (!isEndOfGame()) {
            do {
                //player1 rákattint egy pitre
                // checkMove() végigpottyantja a seedeket -> move()
                checkMove(currentPlayer, clickedPit);
            } while (!checkMove(currentPlayer, clickedPit)); //TODO currentPlayer és clickedPit

            //TODO: checkCapture()
            //TODO: checkLandInStore() --> ha true, akkor jöhet megint
            passRound(); //----
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
        boolean allEmpty = false;
        Player winner = null;

        for (int player1pit : PLAYER1PITS) {
            if (pits.get(player1pit).getSeedCount() != 0) {
                allEmpty = false;
                winner = null;
                break;
            }
            allEmpty = true;
            winner = players[1];
        }

        for (int player2pit : PLAYER2PITS) {
            if (pits.get(player2pit).getSeedCount() != 0) {
                allEmpty = false;
                winner = null;
                break;
            }
            allEmpty = true;
            winner = players[0];
        }

        return allEmpty;
    }

    public void endOfGame() {
        if (isEndOfGame()) {
            //TODO: a maradék pitekben lévő seedek kiosztása a storeba
            //TODO: kihírdetni a nyertest
            System.out.println("Játék vége, player 1/2 nyert!");
        }
    }

    public void passRound() {
        if (currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
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

    public Player getCurrentPlayer() {
        return  currentPlayer;
    }

}
