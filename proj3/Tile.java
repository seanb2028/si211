/**
 * This is the base class for a tile.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import si211.*;

public class Tile extends JPanel {
    private Pos p;
    private int kindID;
    private boolean tileActivated = false;
    private boolean tileMatched = false;
    private TileListener tListener = new TileListener();
    private TileStateListener sListener;

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
    public void addTileStateListener(TileStateListener sListener) { this.sListener = sListener; }
    
    // Setters
    public void setActivated(boolean bool) { tileActivated = bool; }

    // Getters
    public int getKindID() { return kindID; }
    public Pos getPos() { return p; }
    public String getPosString() { return p.toString(); }
    public boolean getMatched() { return tileMatched; }

    // Modify mouse clicks on tile
    public void disable() { removeMouseListener(tListener); }
    public void enable() { addMouseListener(tListener); }

    // Deactivates the tile permanently
    public void permanentlyDisable() {
        setActivated(false);
        tileMatched = true;

        disable();
        setBackground(Color.WHITE);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if (tileActivated) {
            g2.setStroke(new BasicStroke(15));
            g2.setColor(Color.BLACK);
            g2.draw(new Rectangle2D.Double(0, 0, 100, 100));
        }
    }

    public Tile(int row, int col, int kindID) {
        this.p = new Pos(row, col);
        this.kindID = kindID;

        setPreferredSize(new Dimension(100,100));
        setBackground(P3Tools.getSwatchColor(kindID));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        disable();
    }
}