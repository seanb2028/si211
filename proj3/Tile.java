/**
 * This is the base class for a tile.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tile extends JPanel {
    private JButton t;
    private boolean tileActivated = false;

    private class TileClickListener extends MouseAdapter {    
        @Override 
        public void mousePressed(MouseEvent e) { 
            System.out.println("Tile pressed");
            tileActivated = (!tileActivated) ? true : false;
            System.out.println("Tile " + ((tileActivated) ? "activated" : "deactivated"));
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Tile released");
        }
    }

    public Tile() {
        t = new JButton();
        t.setPreferredSize(new Dimension(100,100));
        t.setBackground(Color.WHITE);
        t.setBorder(BorderFactory.createLineBorder(Color.black));
        add(t);

        t.addMouseListener(new TileClickListener());
    }
}