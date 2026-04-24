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
        while (true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {}
            dOrbit.step();
            dOrbit.repaint();
        }
    }
}
