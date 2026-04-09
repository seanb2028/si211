/**
 * Sean Beckford and Sam Pirkl
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loan {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        //---TOP---
        JPanel top = new JPanel();

        JLabel loan = new JLabel("loan amount");
        top.add(loan);

        JTextField amount = new JTextField(10);
        top.add(amount);

        JLabel interest = new JLabel("interest rate");
        top.add(interest);
        
        String[] rates = {"3.5", "3.75", "4.0", "4.25", "4.5", "4.75", "5.0", "5.25", "5.5", "5.75", "6.0", "6.25", "6.5", "6.75", "7.0", "7.25", "7.5"};
        JComboBox<String> rate = new JComboBox<>(rates);
        top.add(rate);

        JLabel monthly = new JLabel("monthly payment");
        top.add(monthly);

        JTextField payment = new JTextField(10);
        top.add(payment);

        f.add(top, BorderLayout.NORTH);
        
        //---MID---
        JPanel mid = new JPanel();
        
        JLabel months = new JLabel("months to payoff");
        mid.add(months);

        JTextField payoff = new JTextField(10);
        mid.add(payoff);
        
        f.add(mid, BorderLayout.CENTER);

        JButton calculate = new JButton("calculate");
        f.add(calculate, BorderLayout.EAST);

        //---BOT---
        JPanel bot = new JPanel();

        JLabel cost = new JLabel("cost");
        bot.add(cost);

        JTextField totalCost = new JTextField(10);
        bot.add(totalCost);

        f.add(bot, BorderLayout.SOUTH);

        calculate.addActionListener(new ButtonClickListener(amount, rate, payment, payoff, totalCost));

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}