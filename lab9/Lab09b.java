// Author: Sean Beckford
import java.util.*;
import java.io.*;

public class Lab09b {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
        ModQueue Q = new ModQueue();

        boolean verbose = false;

        // Handle command line arguments
        if (args.length == 1 && args[0].equals("-v")) { verbose = true; }
        else if (args.length == 1 && ! args[0].equals("-v")) {
            try { sc = new Scanner(new FileReader(args[0])); } 
            catch(IOException e) { 
                System.out.println("File '" + args[0] + "' could not be opened; switching input to standard in."); 
                verbose = true;
            }
        }
        else if (args.length == 0) { /* keep verbose false */ }
        else { System.out.println("Invalid input! java Lab09b <-v or filename>"); System.exit(1); }

        try {
            do {
                if (verbose == true) { System.out.print("> "); }
                String s = sc.next();
                if (s.equals("quit")) 
                    break;
                else if (s.equals("clearto")) {
                    String element = sc.next();
                    try { Q.dequeue(element); }
                    catch (NullPointerException e) { 
                        if (verbose) System.out.println("String '" + element + "' not found!"); 
                        Q.empty();
                    }
                }
                else if (s.equals("add")) {
                    Q.enqueue(sc.next());
                }
                else if (s.equals("dump")) {
                    try { System.out.println(Q.dump()); }
                    catch (NullPointerException e) { /* silently continue */ }
                }
                else {
                    if (verbose) System.out.println("Unknown command '" + s +"'.");
                }
            } while(true);
        } catch (NoSuchElementException e) {
            System.out.println("ctrl-d");
        }
    }
}