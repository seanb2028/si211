/**
 * Logic class to calculate loan payoff rates
 * 
 * Sean Beckford and Sam Pirkl
 */
public class Calc {
    private int payoff = 0;
    private double cost;

    // Getters for the button
    public int getPayoff() { return payoff; }
    public double getCost() { return cost; }

    // Our function for calculating months to payoff and cost
    public void calcLoan(double balance, double rate, double payment) {
        double originalAmt = balance, totalPaid = 0;

        while (balance > 0) {
            payoff++;

            double interest = balance * (rate / 1200);
            balance += interest - payment;
            totalPaid += payment;
        }

        // Final calucation (used Math.round to approximate to hundreths place)
        cost = Math.round((totalPaid + balance - originalAmt) * 100.0) / 100.0;
    }

    public static void main(String[] args) throws Exception {
        // Check if arguments are formatted correctly
        if (args.length != 3) {
            System.out.println("usage: java Calc <amount> <rate> <payment>");
            System.exit(1);
        }

        double balance, rate, payment;

        try {
            balance = Double.parseDouble(args[0]);
            rate = Double.parseDouble(args[1]);
            payment = Double.parseDouble(args[2]);        
        } catch (Exception e) { throw new Exception(); }

        double originalAmt = balance, totalPaid = 0;
        int payoff = 0;

        while (balance > 0) {
            payoff++;

            double interest = balance * (rate / 1200);
            balance += interest - payment;
            totalPaid += payment;
        }

        // Final calucation
        double cost = totalPaid + balance - originalAmt;

        System.out.printf("months = %d cost = %.2f%n", payoff, cost);
    }
}