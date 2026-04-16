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

    // Inner class for start button listener
    private class StartListener implements ActionListener {     
        @Override
        public void actionPerformed(ActionEvent e) {
            startActivated = startActivated ? false : true;
            if (startActivated) 
                start.setText("stop");
            else
                start.setText("start");
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
        JComponent orbit = new DrawOrbit();
        add(orbit, BorderLayout.CENTER);

        pack();
    }    
}
