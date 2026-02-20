import java.util.*;
import java.io.*;

public class Section {
  // our class (struct data) for a section
  public String course, section, schedule, room;

  // prints out a single section
  public static void print(Section s) {
    System.out.println(s.course + " " + s.section + " " + s.schedule + " " + s.room);
  }

  // reads in a single section
  public static Section read(Scanner sc) {
    Section s = new Section();
    s.course = sc.next();
    s.section = sc.next();
    s.schedule = sc.next();
    s.room = sc.next();
    return s;
  }
}
