/**
 * This is the manager class for the GUI.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    public GUI() {
        JPanel clock = new Clock();
        add(clock, BorderLayout.NORTH);

        JPanel board = new Board();
        add(board, BorderLayout.CENTER);

        pack();
    }
}