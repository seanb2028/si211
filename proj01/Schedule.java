/*---------------------------------------
Author: Sean Beckford
This class handles Schedule related data
---------------------------------------*/
import java.util.*;

public class Schedule {
  private myQueue myS;

  // constructor for the schedule
  public Schedule() { this.myS = new myQueue(); }

  // getter for the Queue
  public myQueue getQueue() { return this.myS; }

  // override printSections to not do the check
  public void printSections() {
    myQueue.Iter iter = myS.iterator();
    while (iter.hasNext()) {
      Section curr = iter.next();
      Section.print(curr);
    }
  }

  // find the section the user wants to add to their schedule
  public Section findSection(String course, String section, Sections sList) {
    myQueue Q = sList.getQueue();
    myQueue.Iter iter = Q.iterator();
    while (iter.hasNext()) {
      Section curr = iter.next();
      if (curr.course.equals(course) && curr.section.equals(section)) { return curr; }
    }
    return null;
  }

  // adds a section to the user's schedule
  public void addSection(String course, String section, Sections sList) {
    Section s = findSection(course, section, sList);
    if (s == null) {
      System.out.println("Error! Section not found!");
    }
    else { myS.enqueue(s); }
  }
}
