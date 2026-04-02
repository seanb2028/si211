public class Calc {
    private int payoff;
    private double cost;

    public double getPayoff() { return payoff; }
    public double getCost() { return cost; }

    public void calcCost(double a, double r, double p) {
        double startA = a;
        
        double amountRepaid = 0;
        int numMonths = 0;
        while (a > 0) {
            numMonths++;

            double interest = a * r / 1200;
            a = a + interest - p;

            if (a < 0) {
                amountRepaid = -1 * a;
            }
        }

        payoff = numMonths;
        cost = (p * numMonths) - amountRepaid - startA;
    }
}
