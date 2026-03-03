/*---------------------------------------------------------------------
Auhtor: Sean Beckford
This program takes in a file with a list of sections and their info
 - Allows the user the see all the sections for a course in the list
 - Allows the user to add a section to the list
 - Allows the user to show their sections they signed up for
 - Allows the user to see their schedule (grid format)
---------------------------------------------------------------------*/
import java.util.*;

public class Proj01 {
  public static void main(String[] args) {
    // initialize Section and Schedule objects
    Sections sList = new Sections();
    Schedule myS = new Schedule();
    // read in the sections file first!
    sList.readSections(args[0]);

    Scanner in = new Scanner(System.in);
    // program loop
    System.out.print("> ");
    String cmd;
    while (!(cmd = in.next()).equals("quit")) {
      if (cmd.equals("sections")) {
        String course = in.next();
        sList.printSections(course);
      }
      else if (cmd.equals("add")) {
        String course = in.next();
        String section = in.next();
        myS.addSection(course, section, sList);
      }
      else if (cmd.equals("show")) {
        myS.printSections();
      }
      else if (cmd.equals("week")) {
        Week.showWeek(myS);
      }
      else { System.out.println("Unknown command: " + cmd); }
      System.out.print("> ");
    }
    // always close input stream
    in.close();
  }
}
