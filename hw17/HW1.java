/**
 * Co-author: Sean Beckford
 */
import java.util.*;
import java.io.*;

public class HW1
{
  public static void main(String[] args)
  {
    LineNumberReader lnr = null;
    
    // File input
    if (args.length > 0) {
      // File reader handles bytes -> characters conversion and is a Reader
      try {
        lnr = new LineNumberReader(new FileReader(args[0])); 
      } catch (FileNotFoundException e) {
        System.out.println("File \"" + args[0] + "\" not found");
        System.exit(1);
      }
    } else { // User input
      lnr = new LineNumberReader(new InputStreamReader(System.in));
    }

    Scanner sc = new Scanner(lnr);

    try {
      System.out.println(Mystery.compute(sc));
    }
    catch(Exception e)
    {
      System.out.println("Error " + e.getMessage() + " at line " + lnr.getLineNumber());
    }
    
    // Always close input streams
    sc.close();
  }
}
