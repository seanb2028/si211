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
        JFrame board = new Board();

        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
    }
}
