package mancala.Controller;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {


    @Test
    void shouldCreateNewGame() {
        JPanel testPanel = new JPanel();
        GameController gc = new GameController(testPanel);
        assertNotEquals(gc.seeds, null);
        assertNotEquals(gc.seeds.size(), 0);
    }

}