/**
 * This is an strip for a countdown timer.
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

        // When someone clicks the button, run the math
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tThread == null || !tThread.isAlive()) {
                tThread = new TimerThread();
                tThread.start();    
            }
        }
    }

    // Our updater for our timer thread
    public void update() throws Exception { 
        while (time > 0) {
            time -= 1;
            timeLeft.setText(String.valueOf(time));
            Thread.sleep(1000);
        }
    }

    public CountdownStrip() {
        // Label
        timeLeft = new JLabel("DONE");
        timeLeft.setForeground(Color.RED);
        add(timeLeft);
        // Text Field
        timeInput = new JTextField(10);
        add(timeInput);
        // Button
        countdown = new JButton("countdown");
        add(countdown);
        if (!timeInput.getText().isEmpty())
            countdown.addActionListener(new CountdownClickListener());
    }
}
