/**
 * A JFrame to calculate loan payoff rates
 * 
 * Sean Beckford and Sam Pirkl
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanFrame extends JFrame {
     public LoanFrame() {
        //---TOP---
        JPanel top = new JPanel();

        top.add(new JLabel("loan amount"));
        JTextField amount = new JTextField(10);
        top.add(amount);

        top.add(new JLabel("interest rate"));
        String[] rates = {"3.5", "3.75", "4.0", "4.25", "4.5", "4.75", "5.0", "5.25", "5.5", "5.75", "6.0", "6.25", "6.5", "6.75", "7.0", "7.25", "7.5"};
        JComboBox<String> rate = new JComboBox<>(rates);
        top.add(rate);

        top.add(new JLabel("monthly payment"));
        JTextField payment = new JTextField(10);
        top.add(payment);

        add(top, BorderLayout.NORTH);
        
        //---MID---
        JPanel mid = new JPanel();
        
        mid.add(new JLabel("months to payoff"));
        JTextField payoff = new JTextField(10);
        mid.add(payoff);
        
        add(mid, BorderLayout.CENTER);

        JButton calculate = new JButton("calculate");
        add(calculate, BorderLayout.EAST);

        //---BOT---
        JPanel bot = new JPanel();

        bot.add(new JLabel("cost"));
        JTextField totalCost = new JTextField(10);
        bot.add(totalCost);

        add(bot, BorderLayout.SOUTH);

        calculate.addActionListener(new LoanButtonClickListener(amount, rate, payment, payoff, totalCost));

        pack();
    }
}
