/**
 * This is a class for the Orbit graphics 
 * and handles the number of orbits.
 * 
 * @author Sean Beckford
 */
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class DrawOrbit extends JComponent {
    private List<Orbit> orbits = new ArrayList<>();

    public DrawOrbit() {
        super();
        // ADD ORBITS HERE
        orbits.add(new Orbit(255, 175, 125, new Color(255, 51, 255)));
        
        setPreferredSize(new Dimension(500, 400));
    }

    public void addOrbit(double radius, Color color) {
        orbits.add(new Orbit(255, 175, radius, color));
    }

    public void step() { 
        for (Orbit o : orbits)
            o.step();
    }

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

        // CENTER STAR
        g2.setColor(new Color(255, 51, 255, 255));
        g2.fill(new Ellipse2D.Double(250, 170, 10, 10));
        
        for (Orbit o : orbits)
            o.paint(g2);
    }
}
