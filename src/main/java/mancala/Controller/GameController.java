package mancala.Controller;

import mancala.Model.*;
import mancala.View.GameWindow;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class GameController {
    public static final int STORE_1 = 6;
    public static final int STORE_2 = 13;
    public static final int[] PLAYER1PITS = {0, 1, 2, 3, 4, 5, 6};
    public static final int[] PLAYER2PITS = {7, 8, 9, 10, 11, 12, 13, 13};

    private String message = "";

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


        //Create pits & Stores
        for (int i = 0; i < 14; i++) {
            if (i != STORE_1 && i != STORE_2) {//FIXME Ronda
                Pit pit;
                if (i < 6) {    //FIXME konstansok átírása dinamikus ablakméretre pl 8 7

                    pit = new Pit(new ArrayList<Seed>(48), (8 * i) * GameWindow.width / 96 + 7 * GameWindow.width / 24, GameWindow.height / 2 + round(GameWindow.height / 7f), round(GameWindow.height / 12f));
                } else {

                    pit = new Pit(new ArrayList<Seed>(48), (8 * abs(12 - i)) * GameWindow.width / 96 + 7 * GameWindow.width / 24, GameWindow.height / 2 - round(GameWindow.height / 7f), round(GameWindow.height / 12f));
                }
                pits.add(pit);


            } else if (i == STORE_1) {
                Store pit = new Store(new ArrayList<Seed>(48), round(GameWindow.width / 6.15f), GameWindow.height / 2, round(GameWindow.width / 7f), round(GameWindow.height / 1.9f));
                pits.add(pit);
            } else {
                Store pit = new Store(new ArrayList<Seed>(48), GameWindow.width - round(GameWindow.width / 6.15f), GameWindow.height / 2, round(GameWindow.width / 7f), round(GameWindow.height / 1.9f));
                pits.add(pit);
            }
        }

        //Create seeds
        for (int i = 0; i < 48; i++) {
            Seed seed = new Seed();
            seeds.add(seed);
        }

        int seedIndex = 0;
        for (Pit pit : pits) {
            if (pit.getId() != STORE_1 && pit.getId() != STORE_2) {
                for (int j = 0; j < 4; j++) {
                    pit.addSeed(seeds.get(seedIndex));
                    seedIndex++;
                }
            }
        }


        board = new Board(pits, GameWindow.width / 2, GameWindow.height / 2, round(GameWindow.width / 1.2f), round(GameWindow.height / 1.8f));
        gamePanel.repaint();
        gameLoop();
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
        if (start == null) return false;
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
        int shift = 0;
        int avoidStoreID;
        if (currentPlayer == players[0]) {
            avoidStoreID = STORE_2;
        } else /*if (currentPlayer == players[1])*/ {
            avoidStoreID = STORE_1;
        }
        ArrayList<Seed> pitSeeds = start.getSeeds();
        for (int i = 0; i < start.getSeedCount(); i++) {

            if ((start.getId() + i) % 14 == avoidStoreID) shift++;
            pits.get((start.getId()+1 + i + shift) % 14).addSeed(pitSeeds.get(i));
        }
        start.removeSeeds();

        setClickedPit(null);
    }

    /*protected void move(Pit start, boolean skipStore) {
        if (skipStore) {
            for (int i = 0; i < start.getSeedCount(); i++) {
                ArrayList<Seed> pitSeeds = start.getSeeds();
                if (i == start.getSeedCount())
                    pits.get(start.getId() + i + 1 % 14).addSeed(pitSeeds.get(i));
                else pits.get(start.getId() + i % 14).addSeed(pitSeeds.get(i));
                start.removeSeeds();
            }
        } else System.out.println("Ide nem kellene eljutni...");
        setClickedPit(null);
    }*/

    public void gameLoop() {
        if (!isEndOfGame()) {

            //player1 rákattint egy pitre
            // checkMove() végigpottyantja a seedeket -> move()
            checkMove(currentPlayer, clickedPit);
            if (checkMove(currentPlayer, clickedPit)) { //TODO currentPlayer és clickedPit
                checkCapture(currentPlayer, clickedPit);
                //TODO: checkLandInStore() --> ha true, akkor jöhet megint
                checkLandInStore(clickedPit);
                passRound(); //----
            }
            gamePanel.repaint();
        }

    }

    void checkCapture(Player player, Pit start) {
        int checkedID = (start.getId() + start.getSeedCount()) % 14;
        int relativeStore = 0;

        // Ha az érkezés pitje a jobb okldali store-tól ugyanakkora távolságra lévő pit üres, akkor capture()
        if (player == players[0]) {
            relativeStore = STORE_1;
        } else if (player == players[1]) {
            relativeStore = STORE_2;
        }

        Pit capturePit = pits.get((relativeStore + Math.abs(relativeStore - checkedID)) % 14);
        if (capturePit.getSeedCount() == 0) {
            capture(capturePit);
        }

    }

    void capture(Pit capturePit) {
        // megkapom a szemben lévő pitből az összes seedet
        //TODO: felső attention message a capture-re!
        int currPlayerStoreID = 0;
        if (getCurrentPlayer() == players[0]) {
            currPlayerStoreID = STORE_1;
        } else if (getCurrentPlayer() == players[1]) {
            currPlayerStoreID = STORE_2;
        }
        for (int i = 0; i < capturePit.getSeedCount(); i++) {
            pits.get(currPlayerStoreID).addSeed(capturePit.getSeeds().get(i));
        }
        capturePit.removeSeeds();
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
            System.out.println("Mégegyszer jöhetsz!");
            message = "Mégegyszer te jössz!";
            //TODO: bewaitelni a kattintást valahogy
            move(start);
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
            message = "Játék vége!";
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
        return currentPlayer;
    }

    public void setClickedPit(Pit clickedPit) {
        this.clickedPit = clickedPit;
    }

    public String getMessage() {
        return message;
    }
}
