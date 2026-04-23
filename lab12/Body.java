/**
 * This is a class for a celestial body.
 * 
 * @author Sean Beckford
 */
public class Body {
    private double centerBodyX, centerBodyY; 
    private double outerBodyX, outerBodyY, bodyRadius;
    private double orbCenter, orbRadius, angle, angularV;
    private Color color;

    public Body(double x, double y) {
        this.centerBodyX = x;
        this.centerBodyY = y;
    }

    public void step() {
        outerBodyX = centerBodyX + (orbRadius * Math.cos(a));
        outerBodyY = centerBodyY + (orbRadius * Math.sin(a));    
    }

    public void paint(Graphics2D g) {
        g.fill(new Ellipse2D.Double(x + r, y + r, 2 * r, 2 * r));
    }
}
