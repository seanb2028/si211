import java.util.*;
import java.io.*;
public class Sections {
  private Section[] S;
  private int size = 11; // set our array size;

  // constructor for our sections;
  public Sections() {
    this.S = new Section[size];
  }

  // prints the sections that match the coursenum the user provided
  public void printSections(String course) {
    for (int i = 0; i < size; i++) {
      if (S[i].course.equals(course)) {
        print(S[i]);
      }
    }
  }

  // reads the sections file then stores the sections data in an array
  public Section[] readSections(String fname) {
    Scanner sc = null;
    // file read processing
    try {
      sc = new Scanner(new FileReader(fname));
      // storing loop
      for (int i = 0; i < size; i++) {
        S[i] = Section.read(sc);
      }
    }
    catch(IOException e) { e.printStackTrace(); System.exit(1); }

    return S;
  }
}
