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
    private boolean tileActivated = false;
    private TileListener tListener = new TileListener();
    private StateListener sListener;

    // Inner class to register mouse presses on the tile
    private class TileListener extends MouseAdapter {     
        @Override
        public void mousePressed(MouseEvent e) { 
            tileActivated = !tileActivated;
            if (sListener != null) {
                if (tileActivated)
                    sListener.activated(Tile.this);
            }
        } 
    }

    // To add state listeners to tiles
    public void addStateListener(StateListener sListener) { this.sListener = sListener; }
    
    // Setters
    public void setActivatedFalse() { tileActivated = false; }

    // Getters
    public int getKindID() { return kindID; }
    public Pos getPos() { return p; }
    public String getPosString() { return p.toString(); }

    // Modify mouse clicks on tile
    public void disable() { removeMouseListener(tListener); }
    public void enable() { addMouseListener(tListener); }

    // Deactivates the tile permanently
    public void permanentlyDisable() {
        setActivatedFalse();

        disable();
        setBackground(Color.WHITE);
        repaint();
    }

    public Tile(int row, int col, int kindID) {
        this.p = new Pos(row, col);
        this.kindID = kindID;

        setPreferredSize(new Dimension(100,100));
        setBackground(P3Tools.getSwatchColor(kindID));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        enable();
    }
}