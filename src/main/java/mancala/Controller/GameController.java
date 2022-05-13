package mancala.Controller;

import mancala.Model.*;
import mancala.View.GameWindow;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Math.round;

public class GameController {

    ArrayList<Seed> seeds;
    ArrayList<Pit> pits;
    Board board;
    Player[] players = new Player[2];
    JPanel gamePanel; //kell ez?

    public GameController(JPanel gamePanel) {
        this.gamePanel=gamePanel;
        newGame();
    }

    private void newGame() {
        seeds = new ArrayList<>(48); //
        pits=new ArrayList<>(14);

        //Create pits
        for (int i=0; i<14;i++) {
            if (i!=6 && i!=13) {
                Pit pit=new Pit(null,GameWindow.width/2,GameWindow.height/2,round(GameWindow.height/8f));
                pits.add(pit);
            }
            else if (i==6) {
                Store pit=new Store(null,round(GameWindow.width/6.15f),GameWindow.height/2,round(GameWindow.width/7f),round(GameWindow.height/1.9f));
                pits.add(pit);
            }
            else {
                Store pit=new Store(null,GameWindow.width-round(GameWindow.width/6.15f),GameWindow.height/2,round(GameWindow.width/7f),round(GameWindow.height/1.9f));
                pits.add(pit);
            }
        }

        board =new Board(pits, GameWindow.width/2,GameWindow.height/2,round(GameWindow.width/1.2f),round(GameWindow.height/1.8f));
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
        for (int i = 0; i < start.getSeedCount(); i++) {
            ArrayList<Seed> seeds = start.getSeeds();
            pits.get(start.getId() + i).addSeed(seeds.get(i));   //FIXME: nem get(0), hanem mindig a targetIndex++ kell
            start.removeSeeds();
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
     * @param start The selected pit
     * @return True if it will land in a store, false if not.
     */
    void checkLandInStore(Pit start) {
        int checkedID = (start.getId() + start.getSeedCount()) % 14;

        if (checkedID == 6 || checkedID == 13) { //A két store ID-ja
            landInStore(start);
            //TODO: mégegy move vagy hogy
        }
        else return;
    }

    /**
     *
     */
    void landInStore(Pit start) {
        if (true) { //TODO: az utolsó seed a store-ba esik

            //mégegyszer jöhet
        }
    }

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
            System.out.printf("Játék vége, player 1/2 nyert!");
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
