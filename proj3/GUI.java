/**
 * This is the main class for the program GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    public GUI() {
        Tile t = new Tile();
        add(t, BorderLayout.CENTER);

        add(new JLabel("NORTH", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JLabel("SOUTH", SwingConstants.CENTER), BorderLayout.SOUTH);
        add(new JLabel("EAST"), BorderLayout.EAST);
        add(new JLabel("WEST"), BorderLayout.WEST);

        pack();
    }

}
