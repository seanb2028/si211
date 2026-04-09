/**
 * Main class
 * 
 * Sean Beckford and Sam Pirkl
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loan {
    public static void main(String[] args) {
        JFrame l = new LoanFrame();

        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setVisible(true);
    }
}