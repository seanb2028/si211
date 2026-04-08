/**
 * Sean Beckford and Sam Pirkl
 */
public class Calc {
    public static void main(String[] args) {
        // Check if arguments are formatted correctly
        if (args.length != 3) {
            System.out.println("usage: java Calc <amount> <rate> <payment>");
            System.exit(1);
        }

        try {
            double balance = Double.parseDouble(args[0]);
            double rate = Double.parseDouble(args[1]);
            double payment = Double.parseDouble(args[2]);        
        } catch (Exception e) { e.printStackTrace(); }

        double interest = 0, cost = 0;
        int months = 0;

        while (amount > 0) {
            months++;
            interest += (balance * rate / 1200);
            cost = balance - interest;
        }

        System.out.println("months = " + months + " cost = " + cost);
    }
}