/**
 * This is the main class for the countdown timer.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11Timer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        JPanel s = new CountdownStrip();
        frame.add(s);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
