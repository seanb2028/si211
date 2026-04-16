/**
 * This is the thread for the ongoing timer.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;

public class TimerThread extends Thread {
    private CountdownStrip strip;

    public TimerThread(CountdownStrip s) {
        this.strip = s;
    }
   
    @Override
    public void run() {
        try {
            strip.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
