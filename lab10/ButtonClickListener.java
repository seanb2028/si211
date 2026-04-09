/**
 * Sean Beckford and Sam Pirkl
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickListener implements ActionListener {
    private JTextField amount, payment, payoff, cost;
    private JComboBox rate;
    
    public ButtonClickListener(JTextField a, JComboBox r, JTextField pMent, JTextField pOff, JTextField c) {
        this.amount = a;
        this.rate = r;
        this.payment = pMent;
        this.payoff = pOff;
        this.cost = c;
    }

    public void actionPerformed(ActionEvent e) {
        Calc c = new Calc();
        c.calcLoan(Double.parseDouble(amount.getText()), Double.parseDouble((String) rate.getSelectedItem()), Double.parseDouble(payment.getText()));
        payoff.setText(String.valueOf(c.getPayoff()));
        cost.setText(String.valueOf(c.getCost()));
    }
}
