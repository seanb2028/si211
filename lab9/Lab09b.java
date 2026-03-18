// Author: Sean Beckford
import java.util.*;
import java.io.*;

public class Lab09b {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
        ModQueue Q = new ModQueue();

        boolean verbose = false;

        // Handle command line arguments
        if (args.length > 2 ) {
            System.out.println("Invalid input!");
            System.exit(1);
        }

        for (String arg : args) { // The colon iterates through the array of Strings
            if (arg.equals("-v")) { verbose = true; }
            else {
                try { sc = new Scanner(new FileReader(arg)); }
                catch (IOException e) {
                    System.out.println("File '" + arg + "' could not be opened; switching input to standard in.");
                    verbose = true;
                }
            }
        }

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
                    String element = null;
                    try { element = sc.next(); } 
                    catch (NoSuchElementException e) {
                        if (verbose) System.out.println("Unexpected end of input.");
                        System.exit(1); 
                    }
                    Q.enqueue(element);
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
            System.out.println("Unexpected end of input.");
        }
    }
}