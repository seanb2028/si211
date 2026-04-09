/**
 * Action Listener for the calculate button for LoanFrame
 * 
 * Sean Beckford and Sam Pirkl
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanButtonClickListener implements ActionListener {
    private JTextField amount, payment, payoff, cost;
    private JComboBox rate;
    
    public LoanButtonClickListener(JTextField a, JComboBox r, JTextField pMent, JTextField pOff, JTextField c) {
        this.amount = a;
        this.rate = r;
        this.payment = pMent;
        this.payoff = pOff;
        this.cost = c;
    }

    // When someone clicks the button, run the math
    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(amount.getText());
        double r = Double.parseDouble((String) rate.getSelectedItem());
        double p = Double.parseDouble(payment.getText());

        Calc c = new Calc();
        c.calcLoan(a, r, p);
        payoff.setText(String.valueOf(c.getPayoff()));
        cost.setText(String.valueOf(c.getCost()));
    }
}
