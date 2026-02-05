import java.util.*;
import java.io.*;
public class Sections {
  private static Section[] S;
  private static int size = 11; // set our array size;

  // constructor for our sections;
  public Sections() {
    this.S = new Section[size];
  }

  // prints the sections that match the coursenum the user provided
  public void printSections(String course) {
    for (int i = 0; i < size; i++) {
      if (this.S[i].course.equals(course)) {
        System.out.println(this.S[i].course + " " + this.S[i].section + " " + this.S[i].schedule + " " + this.S[i].room);
      }
    }
  }

  // reads the sections file then stores the sections data in an array
  public Section[] readSections(String fname) {
    Scanner read = null;
    // file read processing
    try {
      read = new Scanner(new FileReader(fname));
      // storing loop
      for (int i = 0; i < size; i++) {
        this.S[i] = new Section();
        this.S[i].course = read.next();
        this.S[i].section = read.nextInt();
        this.S[i].schedule = read.next();
        this.S[i].room = read.next();
      }
    }
    catch(IOException e) { e.printStackTrace(); System.exit(1); }

    return S;
  }
}
