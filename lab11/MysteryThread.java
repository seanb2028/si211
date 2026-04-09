/**
 * This class creates a Thread to handle the user input
 * when changing the color.
 * 
 * @author Sean Beckford
 */
import javax.swing.JLabel;

public class MysteryThread extends Thread {
    private JLabel label;
    
    public MysteryThread(JLabel l) {
        this.label = l;
    }

    @Override
    public void run() {
        CChange.changeColor(label);
    }
}
