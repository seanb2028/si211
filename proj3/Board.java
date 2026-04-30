/**
 * This is the main class for the program GUI.
 * 
 * @author Sean Beckford
 */
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.P3Tools;

public class Board extends JPanel {
    private List<Tile> tiles = new ArrayList<>();
    private BoardListener bListener;
    private Match match;
    
    public void disableAll() {
        match.reset();
        for (Tile t : tiles)
            t.disable();
    }
    
    public void enableAll() {
        for (Tile t : tiles) {
            if (!t.getMatched()) 
                t.enable();
        }
        checkAllTilesMatched();
    }

    public void checkAllTilesMatched() {
        for (Tile t : tiles) {
            if (!t.getMatched())
                return;
        }
        if (bListener != null)
            bListener.onGameWon();
    }

    // Add listener to the board
    protected void addBoardListener(BoardListener bL) { this.bListener = bL; }

    public Board() {
        match = new Match(this);

        setLayout(new GridLayout(6, 6, 0, 0));
        int[][] kindIDs = P3Tools.getRandomKindIdAssignments((int) System.currentTimeMillis(), 18, 6);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                Tile t = new Tile(row, col, kindIDs[row][col]);
                tiles.add(t);
                t.addTileStateListener(match);
                add(t);
            }
        }
    }
}
