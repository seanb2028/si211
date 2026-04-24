/**
 * This is a class for a celestial body.
 * 
 * @author Sean Beckford
 */
public class Body {
    private double orbCenter, orbRadius, bodyRadius, angle, angularV;
    private Color color;

    public Body(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double keepInRange(double a) {
        if (a <= -Math.PI) return keepInRange(a + 2*Math.PI);
        if (a > Math.PI) return keepInRange(a - 2*Math.PI);
        return a;
    }

    double turnAmt(double a, double goal) { // turn 1deg
        double deg = 2*Math.PI/360.0;
        double t = keepInRange(a - goal);
        if (Math.abs(t) < deg)
        return 0.0;
        return t > 0 ? -deg : deg;
    }

    public void step() {
        if (dist() < delta) return;
        double a2g = Math.atan2(gy - y,gx - x);
        double t = turnAmt(lastAngle,a2g);
        lastAngle = keepInRange(lastAngle + t);
        x += delta*Math.cos(lastAngle);
        y += delta*Math.sin(lastAngle);
    }
    
    public void paint(Graphics2D g) {
        AffineTransform savedTf = g.getTransform();
        g.translate(x,y);
        g.rotate(lastAngle);
        // image is 237 x 106
        g.drawImage(img,-237/2,-106/2,null);
        g.setTransform(savedTf);
        g.setColor(Color.BLUE);
        g.fill(new Ellipse2D.Double(gx+r,gy+r,2*r,2*r));
    }
}
