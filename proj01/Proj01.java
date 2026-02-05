/*---------------------------------------------------------------------
Auhtor: Sean Beckford
This program takes in a file with a list of sections and their info
Then allows the user the see all the sections for a course in the list
---------------------------------------------------------------------*/
import java.util.*;
public class Proj01 {
  public static void main(String[] args) {
    // initialize a Sections object that can be used within Proj01 class
    Sections S = new Sections();
    // read in the sections file first!
    S.readSections(args[0]);

    Scanner in = new Scanner(System.in);
    // program loop
    System.out.print("> ");
    String cmd;
    while (!(cmd = in.next()).equals("quit")) {
      if (cmd.equals("sections")) {
        String course = in.next();
        S.printSections(course);
      }
      else {
        System.out.println("Unknown command: " + cmd);
      }
      System.out.print("> ");
    }
  }
}
