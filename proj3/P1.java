/**
 * This is the main class for the program.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P1 {
    public static void main(String[] args) {
        JFrame gui = new JFrame();
        gui.add(new Board(), BorderLayout.CENTER);

        gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
