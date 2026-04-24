/**
 * This is the thread for the orbiting animation
 * 
 * @author Sean Beckford
 */

public class AniThread extends Thread {
    private DrawOrbit dOrbit;

    public AniThread(DrawOrbit d) { dOrbit = d; }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
            dOrbit.step();
            dOrbit.repaint();
        }
    }
}
