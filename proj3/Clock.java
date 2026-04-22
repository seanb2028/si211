/**
 * This is a class for the clock panel.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock extends JPanel {
    private JLabel timeLeft;
    private int time;
    private JButton start;

    // Inner class for start button listener
    private class StartClickListener implements ActionListener {     
        private TimerThread tThread;

        // When someone clicks the button, run the timer
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tThread == null || !tThread.isAlive()) {
                time = 60;
                tThread = new TimerThread(Clock.this);
                tThread.start();   
            }
        }
    }

    // Our updater for our timer thread
    public void update() throws Exception { 
        while (time > 0) {
            timeLeft.setText(
                ((time == 60) ? "01:" : "00:") + 
                ((time < 10) ? "0" : "") +
                ((time != 60) ? String.valueOf(time): "00")
            );

            Thread.sleep(1000);
            time -= 1;
        }
        timeLeft.setText("1:00");
    }

    public Clock() {
        // START TEXT LABEL
        JLabel startText = new JLabel("Press 'start' to play");
        startText.setPreferredSize(new Dimension(300, 15));
        add(startText);

        // START/PAUSE BUTTON
        start = new JButton("start");
        add(start, BorderLayout.EAST);
        start.addActionListener(new StartClickListener());

        // TIMER LABEL
        timeLeft = new JLabel("01:00");
        add(timeLeft, BorderLayout.EAST);
    }
}
