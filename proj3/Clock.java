/**
 * This is a class for the clock panel.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock extends JPanel implements BoardListener {
    private JLabel timeLeft, stateText;
    private int time;
    private JButton start;
    private GameListener gListener;

    // Inner class for start button listener
    private class StartClickListener implements ActionListener {     
        private TimerThread tThread;

        // When someone clicks the button, run the timer
        @Override
        public void actionPerformed(ActionEvent e) {
            // GAME STARTED
            if (start.getText().equals("start")) {
                if (tThread == null || !tThread.isAlive()) {
                    stateText.setText("Hurry up, the clock's running!");
                    start.setText("pause");
                    time = 60;
                    if (gListener != null) gListener.onGameStart();
                    tThread = new TimerThread(Clock.this);
                    tThread.start();   
                }
            }
            // GAME PAUSED
            else if (start.getText().equals("pause")) {
                gListener.onGameInterrupt();
                stateText.setText("Paused! Give your brain a break!");
                start.setText("resume");
                tThread.interrupt();
            }
            // GAME RESUMED
            else if (start.getText().equals("resume")) {
                gListener.onGameStart();
                stateText.setText("Hurry up, the clock's running!");
                start.setText("pause");
                tThread = new TimerThread(Clock.this);
                tThread.start();
            }
            // GAME FINISHED
            else { System.exit(0); }
        }
    }

    // Getters
    public int getTime() { return time; }

    // Add game listeners to the clock
    public void addGameListener(GameListener gL) {
        this.gListener = gL;
    }

    @Override
    public void onGameWon() {
        stateText.setText("Congrats, you won! It took you " + (60 - time) + " seconds!");
        start.setText("exit");
    }
    public void onGameLost() {
        stateText.setText("Sorry, you lost!");
        start.setText("exit");
    }

    // Our updater for our timer thread
    protected void updateClock() { 
        time--;
        timeLeft.setText(
            ((time == 60) ? "01:" : "00:") + 
            ((time < 10) ? "0" : "") +
            ((time != 60) ? String.valueOf(time): "00")
        );
    }

    public Clock() {
        // START TEXT LABEL
        stateText = new JLabel("Get ready to play!");
        stateText.setPreferredSize(new Dimension(300, 30));
        add(stateText);

        // START/PAUSE BUTTON
        start = new JButton("start");
        start.setPreferredSize(new Dimension(100, 20));
        add(start, BorderLayout.EAST);
        start.addActionListener(new StartClickListener());

        // TIMER LABEL
        timeLeft = new JLabel("01:00");
        add(timeLeft, BorderLayout.EAST);
    }
}
