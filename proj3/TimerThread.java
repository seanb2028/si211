/**
 * This is the thread for the ongoing timer.
 * 
 * @author Sean Beckford
 */
public class TimerThread extends Thread {
    private Clock clock;

    public TimerThread(Clock c) {
        this.clock = c;
    }
   
    @Override
    public void run() {
        try {
            clock.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
