/**
 * This is the base class for a tile.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Tile extends JPanel {
    private Pos p;
    private int kindID;
    private JButton t;
    private boolean tileActivated = false;

    private class TileListener extends MouseAdapter {     
        @Override
        public void mousePressed(MouseEvent e) { 
            System.out.println("\tTile " + p.toString() + " pressed");
            tileActivated = (!tileActivated) ? true : false;
            System.out.println("Tile " + p.toString() + ((tileActivated) ? " activated" : " deactivated"));
        } 
        @Override
        public void mouseReleased(MouseEvent e) { 
            System.out.println("\tTile " + p.toString() + " released");
        }
    }

    public Tile(int row, int col, int kindID) {
        this.p = new Pos(row, col);
        this.kindID = kindID;

        t = new JButton();
        t.setPreferredSize(new Dimension(100,100));
        t.setBackground(P3Tools.getSwatchColor(kindID));
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(t);

        t.addMouseListener(new TileListener());
    }
}