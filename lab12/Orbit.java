/**
 * This class encapsulates an orbit and its celestial body.
 * 
 * @author Sean Beckford
 */
import java.awt.*;
import java.awt.geom.*;

public class Orbit {
    private Body body;

    private double centerX, centerY, radius;
    private Color color;

    public Orbit(double centerX, double centerY, double radius, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
        this.body = new Body(centerX, centerY, radius, color);
    }

    public void setCenter(Body b) {
        this.centerX = b.getOuterBodyX();
        this.centerY = b.getOuterBodyY();
        this.body.setCenterBodyX(centerX);
        this.body.setCenterBodyY(centerY);
    }

    public Body getBody() { return body; }

    public void step() { 
        body.step(); 
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.draw(new Ellipse2D.Double(
            centerX - radius, centerY - radius,
            radius * 2, radius * 2));
        
        body.paint(g);
    } 
}
