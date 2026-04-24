/**
 * This is a class for a celestial body.
 * 
 * @author Sean Beckford
 */
import java.awt.*;
import java.awt.geom.*;

public class Body {
    private double centerBodyX, centerBodyY; 
    private double outerBodyX, outerBodyY, bodyRadius = 5;
    private double orbRadius, angle;
    private Color color;

    public Body(double x, double y, double oR, Color c) {
        this.centerBodyX = x;
        this.centerBodyY = y;
        this.orbRadius = oR;
        this.color = c;
    }

    public void step() {
        angle += 0.02;  
        outerBodyX = centerBodyX + (orbRadius * Math.cos(angle));
        outerBodyY = centerBodyY + (orbRadius * Math.sin(angle));  
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fill(new Ellipse2D.Double(outerBodyX - bodyRadius, outerBodyY - bodyRadius, 2 * bodyRadius, 2 * bodyRadius));
    }
}
