/**
 * This is the main class for the program GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import si211.P3Tools;

public class Board extends JFrame {
    public Board() {
        setLayout(new GridLayout(6, 6, 0, 0));
        int[][] kindIDs = P3Tools.getRandomKindIdAssignments((int) System.currentTimeMillis(), 18, 6);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                add(new Tile(row, col, kindIDs[row][col])); 
            }
        }
        
        pack();
    }
}
