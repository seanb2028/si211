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
        Orbit last = orbits.get(orbits.size() - 1);
        Body parent = last.getBody();
        orbits.add(new Orbit(parent.getOuterBodyX(), parent.getOuterBodyY(), radius, color));
    }

    public void step() { 
        for (int i = 0; i < orbits.size(); i++) {
            Orbit o = orbits.get(i);
            if (i > 0) {
                Body parentOrbit = orbits.get(i - 1).getBody();
                o.setCenter(parentOrbit);
            }
            o.step();
        }
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
