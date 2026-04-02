public class CalcTest {
    public static void main(String[] args) {
        if (args.length > 3) {
            System.out.println("usage: java Calc <amount> <rate> <payment>");
            System.exit(1);
        }

        double amount = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double payment = Double.parseDouble(args[2]);
        
        double amountRepaid = 0;
        int numMonths = 0;
        while (amount > 0) {
            numMonths++;

            double interest = amount * rate / 1200;
            amount = amount + interest - payment;

            if (amount < 0) {
                amountRepaid = -1 * amount;
            }
        }

        double cost = (payment * numMonths) - amountRepaid - Double.parseDouble(args[0]);
        
        System.out.printf("months = %d cost = %.2f\n", numMonths, cost);
    }
}
