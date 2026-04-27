/**
 * This is the manager class for the GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements GameListener {
    private Board board;
    private Clock clock;
    
    @Override
    public void onGameStart() {
        board.enableAll();
    }
    @Override
    public void onGameInterrupt() {
        board.disableAll();
    }

    public GUI() {
        // CLOCK
        clock = new Clock();
        clock.addGameListener(this);
        add(clock, BorderLayout.NORTH);

        // BOARD
        board = new Board();
        board.addBoardListener(clock);
        add(board, BorderLayout.CENTER);

        pack();
    }
}