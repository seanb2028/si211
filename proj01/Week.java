/*-----------------------------------------------
Author: Sean Beckford
This program creates a grid of a school Week
The user can add meeting times to the grid
Allows the user to visualize their free periods
-----------------------------------------------*/
import java.util.*;
import si211.*;

public class Week {
  // prints week out
  public static void printWeek(boolean[][] W) {
    System.out.println("  M T W R F");
    for (int per = 0; per < 6; per++) {
      System.out.print(per + 1);
      for (int day = 0; day < 5; day++) {
        if(W[per][day] == true) { System.out.print(" x"); }
        else { System.out.print("  "); }
      }
      System.out.println();
    }
  }

  // convert day into number for indexing
  public static int parseDay(char d) {
    if (d == 'M') { return 0; }
    else if (d == 'T') { return 1; }
    else if (d == 'W') { return 2; }
    else if (d == 'R') { return 3; }
    else { return 4; }
  }

  // convert period char into integer for indexing
  public static int parsePeriod(char p) { return p - 48; }

  // creates week and shows it to the user
  public static void showWeek(Schedule myS) {
    boolean[][] Week = new boolean[6][5];
    // parse schedule string and modify week
    myQueue Q = myS.getQueue();
    myQueue.Iter iter = Q.iterator();
    while (iter.hasNext()) {
      Section curr = iter.next();
      String[] E = DrBrown.explode(curr.schedule);
      for (int i = 0; i < E.length; i++) {
        Week[parsePeriod(E[i].charAt(1)) - 1][parseDay(E[i].charAt(0))] = true;
      }
    }
    printWeek(Week);
  }

  public static void main(String[] args) {
    boolean[][] Week = new boolean[6][5];
    printWeek(Week);
    Scanner in = new Scanner(System.in);
    // input loop
    String input;
    while (!(input = in.next()).equals("quit")) {
      // parse user input and modify week
      String[] E = DrBrown.explode(input);
      for (int i = 0; i < E.length; i++) {
        Week[parsePeriod(E[i].charAt(1)) - 1][parseDay(E[i].charAt(0))] = true;
      }
      printWeek(Week);
    }
  }
}
