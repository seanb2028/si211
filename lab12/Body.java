/**
 * This is a class for a celestial body.
 * 
 * @author Sean Beckford
 */
public class Body {
    private double centerBodyX, centerBodyY; 
    private double outerBodyX, outerBodyY, bodyRadius = 5;
    private double orbRadius, angle;
    private Color color;

    public Body(double x, double y, Color c) {
        this.centerBodyX = x;
        this.centerBodyY = y;
        this.color = c;
    }

    public void step() {
        outerBodyX = centerBodyX + (orbRadius * Math.cos(angle));
        outerBodyY = centerBodyY + (orbRadius * Math.sin(angle));    
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fill(new Ellipse2D.Double(x + bodyRadius, y + bodyRadius, 2 * bodyRadius, 2 * bodyRadius));
    }
}
