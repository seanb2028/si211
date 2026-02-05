/*---------------------------------------------
Author: Sean Beckford
This is a class file for box-related methods
Creates and modifies a box based on user input
---------------------------------------------*/
import java.util.*;
public class Box
{
    // lower left, upper left, and the point
    private Point l_l;
    private Point u_l;

    // constructor for Box taking a single point
    public Box(Point p) { 
        l_l = new Point(p.getX(), p.getY());
        u_l = new Point(p.getX(), p.getY());
    }

    // constructor for Box taking two initial points
    public Box(Point a, Point b) {
        l_l = new Point(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
        u_l = new Point(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
    }

    // expand the bounding box (if needed) to include point p
    public void growBy(Point p) {
        // check getX() bounds
        if (p.getX() > u_l.getX()) { u_l.setX(p.getX()); }
        else if (p.getX() < l_l.getX()) { l_l.setX(p.getX()); }
        // check getY() bounds
        if (p.getY() > u_l.getY()) { u_l.setY(p.getY()); }
        else if (p.getY() < l_l.getY()) { l_l.setY(p.getY()); }
    }

    // given point p in the bounding box, return associated
    // point in the unit square (see notes); return null if
    // p is not inside the bounding box.
    public Point mapIntoUnitSquare(Point p) {
        if (p.getX() > u_l.getX() || p.getY() > u_l.getY() || p.getX() < l_l.getX() || p.getY() < l_l.getY()) { 
			return null; 
		}
		else {
			return new Point(
			(p.getX() - l_l.getX()) / (u_l.getX() - l_l.getX()), 
			(p.getY() - l_l.getY()) / (u_l.getY() - l_l.getY()));
		} 
    }

    // returns string representation like: 
    // 2.0 < x < 9.0, 3.0 < y < 7.0
    public String toString() {
        return l_l.getX() + " < x < " + u_l.getX() + ", " + l_l.getY() + " < y < " + u_l.getY();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point p = Point.read(sc);
		Box b = new Box(p);
        System.out.println(b.toString());
    }
}