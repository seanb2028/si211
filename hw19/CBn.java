import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBn extends JButton implements ActionListener
{
    private int count;

    public CBn(String label) { 
        super(label); 
        this.addActionListener(this);
        this.count = 0;
    }
    
    public int getCount() { return count; }
    
    public void actionPerformed(ActionEvent e) {
        count++;
    }
}