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
        JFrame board = new JFrame();
        board.add(new Board(),BorderLayout.CENTER);

        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.pack();
        board.setVisible(true);
    }
}
