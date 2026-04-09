/**
 * This is the thread for the ongoing timer.
 * 
 * @author Sean Beckford
 */
import javax.swing.JPanel;

public class TimerThread extends Thread {
    @Override
    public void run() {
        JPanel c = new CountdownStrip();
        c.update();
    }
}
