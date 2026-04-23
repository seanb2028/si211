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
    private GameListener gListener;

    // Inner class for start button listener
    private class StartClickListener implements ActionListener {     
        private TimerThread tThread;

        // When someone clicks the button, run the timer
        @Override
        public void actionPerformed(ActionEvent e) {
            if (start.getText().equals("start")) {
                if (tThread == null || !tThread.isAlive()) {
                    start.setText("pause");
                    time = 60;
                    if (gListener != null) gListener.onGameStarted();
                    tThread = new TimerThread(Clock.this);
                    tThread.start();   
                }
            }
            else if (start.getText().equals("pause")) {
                start.setText("resume");
                tThread.interrupt();

            }
            else if (start.getText().equals("resume")) {
                start.setText("pause");
                tThread = new TimerThread(Clock.this);
                tThread.start();
            }
        }
    }

    // Add game listeners to the clock
    public void addGameListener(GameListener gL) {
        this.gListener = gL;
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
        timeLeft.setText("00:00");
        if (gListener != null) gListener.onGameOver();
    }

    public Clock() {
        // START TEXT LABEL
        JLabel startText = new JLabel("Get ready to play!");
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
