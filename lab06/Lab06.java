import si211.*;
import java.io.*;
import java.util.*;

public class Lab06 {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("usage: java Lab06 <filename>");
      System.exit(1);
    }

    // file processing
    Scanner fin = null;
    try { fin = new Scanner(new FileReader(args[0])); }
    catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    TweetQueueIter t = new TweetQueueIter(fin);
    TweetQueueIter original = t;
    int count = t.getTweets();
    System.out.println(count + " tweets");

    String cmd = "";
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("> ");
      cmd = sc.next();
      if (cmd.equals("dump")) {
        t.printDump();
      }
      if (cmd.equals("filter")) {
        t = t.filter(sc.next());
      }
      if (cmd.equals("filter!")) {
        t = t.filterNot(sc.next());
      }
      if (cmd.equals("reset")) {
        t = original;
        t.resetNumTweets();
        System.out.println(t.getTweets() + " tweets");
      }
    } while(!cmd.equals("quit"));
  }
}
