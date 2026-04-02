import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickListener implements ActionListener {
    private JTextField loan, payment, payoff, cost;
    private JComboBox rate;

    public ButtonClickListener(JTextField l, JTextField pment, JComboBox r, JTextField poff, JTextField c) {
        loan = l;
        payment = pment;
        rate = r;
        payoff = poff;
        cost = c;
    }
    public void actionPerformed(ActionEvent e) {
        double loanAmt = Double.parseDouble(loan.getText());
        double payAmt = Double.parseDouble(payment.getText());
        double rateAmt = Double.parseDouble((String) rate.getSelectedItem());

        Calc c = new Calc();

        c.calcCost(loanAmt, rateAmt, payAmt);

        payoff.setText(String.valueOf(c.getPayoff()));
        cost.setText(String.valueOf(c.getCost()));
    }
}