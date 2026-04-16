import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HW1Frame extends JFrame
{
    private CBn b;

    // A class thats allows us to print # of times button clicked
    class WindowCounter extends WindowAdapter {
        public void windowClosing(WindowEvent e) { 
            System.out.print("Button clicked " + b.getCount() + (b.getCount() == 1 ? " time." : " times.")); 
        }   
    }

    public HW1Frame()
    {
        b = new CBn("click me");
        
        // Added window closing event class and listener
        WindowCounter wc = new WindowCounter();
        this.addWindowListener(wc);

        add(b,BorderLayout.NORTH);
        pack();
    }
}