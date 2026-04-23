/**
 * This is the manager class for the GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements GameListener {
    private Board board;
    
    @Override
    public void onGameStarted() {
        board.enableAll();
    }
    @Override
    public void onGameOver() {
        board.disableAll();
    }

    public GUI() {
        // CLOCK
        Clock clock = new Clock();
        clock.addGameListener(this);
        add(clock, BorderLayout.NORTH);

        // BOARD
        board = new Board();
        add(board, BorderLayout.CENTER);

        pack();
    }
}