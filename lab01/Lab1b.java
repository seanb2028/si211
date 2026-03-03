import java.util.*; // imports the scanner
public class Lab1b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // take in name
        System.out.print("Enter your name: ");
        String name = in.nextLine();

        // take in integers
        System.out.print("Please input an integer ");
        int n = in.nextInt();
        System.out.print("Please input a second integer ");
        int k = in.nextInt();
        
        System.out.println("The two ints were " + n + " and " + k);
        System.out.println("numerator = " + findNum(n,k));
        System.out.println("denominator = " + findDenom(k));
        
        // result
        int result = result(findNum(n,k), findDenom(k));
        System.out.println("odds = 1 in " + result + " = " + 1 / (double)result);
        System.out.println("Goodbye " + name + ".");

        in.close(); // close the input stream when done
    }

    // finds the numerator of the lottery formula
    public static int findNum(int n, int k) {
        int num = 1;
        // formula loop (n to n-k+1)
        for(int i = n; i >= n-k+1; i--) {
            num *= i;
        }
        return num;
    }

    // finds the denominator of the lottery formula
    public static int findDenom(int k) {
        // factorial loop (1 to k)
        int denom = 1;
        for(int i = 1; i <= k; i++){
            denom *= i;
        }
        return denom;
    }

    // finds the result of dividing numerator by denomator
    public static int result(int num, int denom) { int res = num / denom; return res; }
}