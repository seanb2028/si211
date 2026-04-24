/**
 * This is the GUI class for the Orbiting program.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JButton start;
    private boolean startActivated = false;
    private DrawOrbit orbit;

    // Inner class for start button listener
    private class StartListener implements ActionListener {     
        private AniThread aThread;

        @Override
        public void actionPerformed(ActionEvent e) {
            startActivated = !startActivated;
            // START animation
            if (startActivated) {
                start.setText("stop");

                if (aThread == null || !aThread.isAlive()) {
                    aThread = new AniThread(orbit);
                    aThread.start();
                }
            }
            // STOP animation
            else {
                start.setText("start");

                if (aThread != null && aThread.isAlive())
                    aThread.interrupt();
            }
        }
    }

    public GUI() {
        // BUTTON
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5)); 
        start = new JButton("start");
        start.setPreferredSize(new Dimension(80, 20));
        top.add(start);
        start.addActionListener(new StartListener());
        add(top, BorderLayout.NORTH);

        // ORBITS
        orbit = new DrawOrbit();
        orbit.addOrbit(75, new Color(51, 255, 255));
        add(orbit, BorderLayout.CENTER);

        pack();
    }    
}
