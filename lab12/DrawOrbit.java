/**
 * This is a class for the Orbit graphics.
 * 
 * @author Sean Beckford
 */
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class DrawOrbit extends JComponent {
    private Body body;

    public DrawOrbit() {
        super();
        setPreferredSize(new Dimension(500,400));
    }

    public void step() { body.step(); }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        // This makes the output prettier
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
        RenderingHints.VALUE_RENDER_QUALITY);

        // Draw the orbits
        g2.setColor(new Color(255, 51, 255, 255));
        g2.draw(new Ellipse2D.Double(100,50,250,250));
    }
}
