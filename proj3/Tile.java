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

    private class TileClickListener implements ActionListener {     
        @Override
        public void actionPerformed(ActionEvent e) { 
        }
    }

    public Tile() {
        t = new JButton();
        t.setPreferredSize(new Dimension(100,100));
    }
}