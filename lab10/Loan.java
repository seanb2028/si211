// Sean Beckford & Sam Pirkl
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Loan {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(350, 400);

        // TOP
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("loan amount"));

        JTextField loanAmtVal = new JTextField(10);
        top.add(loanAmtVal);

        top.add(new JLabel("interest rate"));

        Double[] rates = {3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0, 5.25, 5.5, 5.75, 6.0, 6.25, 6.5, 6.75, 7.0, 7.25, 7.5};
        JComboBox<Double> intRateVal = new JComboBox<Double>(rates);
        top.add(intRateVal);

        top.add(new JLabel("monthly payment"));

        JTextField monthPayVal = new JTextField(10);
        top.add(monthPayVal);

        frame.add(top, BorderLayout.NORTH);

        // MIDDLE
        JPanel mid = new JPanel(new BorderLayout());
        JPanel centerMid = new JPanel(new FlowLayout());
        JPanel eastMid = new JPanel(new FlowLayout());

        // Center Mid
        centerMid.add(new JLabel("months to payoff"));
        JTextField payOffVal = new JTextField(10);
        centerMid.add(payOffVal);
        mid.add(centerMid);

        // East Mid
        JButton calculate = new JButton("calculate");
        eastMid.add(calculate);
        mid.add(eastMid, BorderLayout.EAST);

        frame.add(mid, BorderLayout.CENTER);

        // BOTTOM
        JPanel bot = new JPanel(new FlowLayout());
        bot.add(new JLabel("cost"));

        JTextField costVal = new JTextField(10);
        bot.add(costVal);

        frame.add(bot, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        calculate.addActionListener(new ButtonClickListener(loanAmtVal, monthPayVal, intRateVal, payOffVal, costVal));
    }
}