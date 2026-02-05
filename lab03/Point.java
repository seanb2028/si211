/*---------------------------------------------
Author: Sean Beckford
This is a class file for point-related methods
Creates points from user input
---------------------------------------------*/
import java.util.*;
public class Point {
    // create private fields
    private double pnt_x;
    private double pnt_y;

    // constructors for points x and y
    public Point(double x, double y) {
        pnt_x = x;
        pnt_y = y;
    }

	// getters
	public double getX() {
		return pnt_x;
	}

	public double getY() {
		return pnt_y;
	}

	// setters
	public void setX(double x) {
		pnt_x = x;
	}

	public void setY(double y) {
		pnt_y = y;
	}

    // reads in x and y and stores the point
    public static Point read(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point(x,y);
    }

    // returns a point as a string
    public String toString() {
        return pnt_x + " " + pnt_y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point p = read(sc);
        System.out.println(p.toString());
    }
}  