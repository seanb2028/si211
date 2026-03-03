/*---------------------------------------
Author: Sean Beckford
This class handles Sections related data
---------------------------------------*/
import java.util.*;
import java.io.*;

public class Sections {
  private myQueue Q;

  // constructor for our sections;
  public Sections() { this.Q = new myQueue(); }

  // getter for the Queue
  public myQueue getQueue() { return this.Q; }

  // prints the sections that match the coursenum the user provided
  public void printSections(String course) {
    myQueue.Iter iter = Q.iterator();
    while (iter.hasNext()) {
      Section curr = iter.next();
      if (curr.course.equals(course)) { Section.print(curr); }
    }
  }

  // reads the sections file then stores the sections data in an array
  public void readSections(String fname) {
    Scanner sc = null;
    // file read processing
    try {
      sc = new Scanner(new FileReader(fname));
      // storing loop
      while (sc.hasNext()) {
        Q.enqueue(Section.read(sc));
      }
    }
    catch(IOException e) { e.printStackTrace(); System.exit(1); }
    // always close input stream
    sc.close();
  }
}
