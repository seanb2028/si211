import java.util.*;
public class Section {
  // our class (struct data) for a section
  public String course;
  public int section;
  public String schedule;
  public String room;

  public static void print(Section s) {
    System.out.println(s.course + " " + s.section + " " + s.schedule + " " + s.room);
  }

  public static Section read(Scanner sc) {
    Section s = new Section();
    s.course = sc.next();
    s.section = sc.nextInt();
    s.schedule = sc.next();
    s.room = sc.next();
    return s;
  }
}
