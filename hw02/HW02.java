import java.util.*;
import java.lang.*;
public class HW02 {
	public static void main(String[] args) {
		// take in size
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		
		String[] A = readStrings(in, size);
		int maxLen = maxLength(A);
		
		printResult(A, maxLen);

		// close the input stream!
		in.close();
	}

	// result
	public static void printResult(String[] A, int maxL) {
		// nested for loop to handle rows/cols
		for(int row = 0; row < maxL; row++) {
			for(int col = 0; col < A.length; col++) {
				// handle if the word is too short to keep going
				if(row >= A[col].length()) { System.out.print("  "); }
				else { System.out.print(A[col].charAt(row) + " "); }
			}
			System.out.println();
		}
	}

	// reads in the strings
	public static String[] readStrings(Scanner sc, int size) { // scanner as parameter to pass the input stream
		String[] A = new String[size];
		// read string loop
		for(int i = 0; i < size; i++) {
			A[i] = sc.next();
		}
		return A;
	}

	// finds the max length in all of the given strings
	public static int maxLength(String[] A) {
		// initialize max to the first value
		int maxL = A[0].length();
		// max check loop
		for(int i = 0; i < A.length; i++) {
			maxL = Math.max(maxL,A[i].length());
		}
		return maxL;
	}
}
