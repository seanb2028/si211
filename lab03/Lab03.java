/*--------------------------------------------------------------------
Author: Sean Beckford
This the main class file for the box program
The user may modify the size of the box and add points within the box
The user can also get points within the box mapped into unit square
--------------------------------------------------------------------*/
import java.util.*;
public class Lab03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput = "";
		Box b = null; // start the box as null to handle uninitialized box
		// user input loop
		while (in.hasNext()) {
			userInput = in.next();
			// add command
			if (userInput.equals("add")) {
				Point p = Point.read(in);
				if (b == null) {
					b = new Box(p, p);
				}
				else {
					b.growBy(p);
				}
			}
			// box command
			else if (userInput.equals("box")) {
				if (b != null) {
					System.out.println(b.toString());
				}
				else {
					System.out.println("error: add a point");
				}
			}
			// map commmand
			else if (userInput.equals("map")) {
				Point p = Point.read(in);
				p = b.mapIntoUnitSquare(p);
				if (p == null) {
					System.out.println("error");
				}
				else {
					System.out.println(p.getX() + " " + p.getY());
				}
			}
			// done command
			else if (userInput.equals("done")) { 
				break; 
			}
			// unknown command
			else {
				System.out.println("Error! Unknown command \"" + userInput + "\"!");
			}
		}
		// always close input stream!
		in.close();
	}
}