/**
 * This is the main class for the program GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    public GUI() {
        Tile t = new Tile();
        add(t, BorderLayout.CENTER);

        add(new JLabel("EAST"), BorderLayout.EAST);

        // Center north and south in between east and west
        JPanel center = new JPanel();
        center.add(new JLabel("NORTH"));
        center.add(new JLabel("SOUTH"));
        add(center, BorderLayout.CENTER);

        add(new JLabel("WEST"), BorderLayout.WEST);

        pack();
    }

}
