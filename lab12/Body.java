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

    // Setters
    public void setCenterBodyX(double x) { centerBodyX = x; }
    public void setCenterBodyY(double y) { centerBodyY = y; }

    // Getters
    public double getOuterBodyX() { return outerBodyX; }
    public double getOuterBodyY() { return outerBodyY; }

    public void step() {
        double speed = 2.5 / orbRadius;
        angle += speed;  

        outerBodyX = centerBodyX + (orbRadius * Math.cos(angle));
        outerBodyY = centerBodyY + (orbRadius * Math.sin(angle));  
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fill(new Ellipse2D.Double(outerBodyX - bodyRadius, outerBodyY - bodyRadius, 2 * bodyRadius, 2 * bodyRadius));
    }
}
