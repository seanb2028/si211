/**
 * This is the main class for the program.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatchingGame {
    public static void main(String[] args) {
        JFrame gui = new GUI();

        gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
