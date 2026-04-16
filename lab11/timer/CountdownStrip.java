/**
 * This is a strip for a countdown timer.
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownStrip extends JPanel {
    private JLabel timeLeft;
    private int time;
    private JTextField timeInput;
    private JButton countdown;

    // Inner class for countdown button listener
    private class CountdownClickListener implements ActionListener {     
        private TimerThread tThread;

        // When someone clicks the button, run the timer
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tThread == null || !tThread.isAlive()) {
                try {
                    time = Integer.parseInt(timeInput.getText());
                    tThread = new TimerThread(CountdownStrip.this);
                    tThread.start();   
                } catch (Exception t) {
                    timeLeft.setText("ERROR");
                }  
            }
        }
    }

    // Our updater for our timer thread
    public void update() throws Exception { 
        while (time > 0) {
            timeLeft.setText(String.valueOf(time));
            Thread.sleep(1000);
            time -= 1;
        }
        timeLeft.setText("DONE");
    }

    public CountdownStrip() {
        // Label
        timeLeft = new JLabel("DONE");
        timeLeft.setForeground(Color.RED);
        timeLeft.setPreferredSize(new Dimension(60,15));
        add(timeLeft);
        // Text Field
        timeInput = new JTextField(10);
        add(timeInput);
        // Button
        countdown = new JButton("countdown");
        add(countdown);
        countdown.addActionListener(new CountdownClickListener());
    }
}
