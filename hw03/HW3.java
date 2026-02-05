/*-------------------------------------------------
Author: Sean Beckford
This program takes in a # of numbers
Then reads info for that many mids
Then reads in a company #
Prints out the infor of the mids from that company
-------------------------------------------------*/
import java.util.*;
public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Mid[] M = createMid(in);
        printMid(in, M);
        in.close(); // always close input stream
    }
    // takes in the mid info from input
    public static Mid[] createMid(Scanner in) {
        int nMids = in.nextInt(); // take in size
        Mid[] M = new Mid[nMids]; // initalize mid struct array
        // user input loop
        for(int i = 0; i < nMids; i++){
            M[i] = new Mid(); // initialize mid struct
            M[i].alpha = in.next();
            M[i].firstName = in.next();
            M[i].lastName = in.next();
            M[i].company = in.nextInt();
        }
        return M;
    }
    // prints out the info for the mids from that company in the same order as read in
    public static void printMid(Scanner in, Mid[] M) {
        int comp = in.nextInt();
        // print loop
        for(int i = 0; i < M.length; i++){
            // check if the mid is in the company the user picked
            if(M[i].company == comp) {
                System.out.println(M[i].alpha + " " + M[i].firstName + " " + M[i].lastName + " " + M[i].company);
            }
        }
    }
}