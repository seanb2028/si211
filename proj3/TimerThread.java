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
        while (clock.getTime() > 0) {
            if (Thread.interrupted()) return;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            clock.updateClock();
        }
        clock.onGameLost();
    }
}
