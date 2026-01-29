import java.util.*;
public class Box {
    // lower left, upper left, and the point
    private Point l_l;
    private Point u_l;

    // constructor for Box taking a single point
    public Box(Point p) { 
        this.l_l = new Point(p.getX(), p.getY());
        this.u_l = new Point(p.getX(), p.getY());
    }
    
    /*
    // constructor for Box taking two initial points
    public Box(Point a, Point b) {
        l_l = new Point(Math.min(a.getX(), b.getX()), Math.min(a.pnt_y, b.pnt_y));
        u_l = new Point(Math.max(a.pnt_x, b.pnt_x), Math.max(a.pnt_y, b.pnt_y));
    }
/*
    // expand the bounding box (if needed) to include point p
    public void growBy(Point p) {
        // check pnt_x bounds
        if (p.pnt_x > u_l.pnt_x) { u_l.pnt_x = p.pnt_x; }
        else if (p.pnt_x < l_l.pnt_x) { l_l.pnt_x = p.pnt_x; }
        // check pnt_y bounds
        if (p.pnt_y > u_l.pnt_y) { u_l.pnt_y = p.pnt_y; }
        else if (p.pnt_y < l_l.pnt_y) { l_l.pnt_y = p.pnt_y; }
    }

    // given point p in the bounding box, return associated
    // point in the unit square (see notes); return null if
    // p is not inside the bounding box.
    public Point mapIntoUnitSquare(Point p) {
        return new Point((p.pnt_x - l_l.pnt_x) / (u_l.pnt_x - l_l.pnt_x), (p.pnt_x - l_l.pnt_y) / (u_l.pnt_y - l_l.pnt_y)); 
    }
    */
    // returns string representation like: 
    // 2.0 < x < 9.0, 3.0 < y < 7.0
    public String toBString() {
        return l_l.getX() + " < x < " + u_l.getX() + ", " + l_l.getY() + " < y < " + u_l.getY();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point p = Point.read(sc);

        Box B = new Box(,);
        System.out.println(Box.toBString());
    }
}