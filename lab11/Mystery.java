import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener
{
    private JLabel label;
    private Thread mThread;

    public Mystery(JLabel l) { 
        this.label = l; 
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (mThread == null || !mThread.isAlive()) {
            mThread = new MysteryThread(label);
            mThread.start();    
        }
    }
}