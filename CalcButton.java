import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcButton extends JButton implements ActionListener
{
    private String label;;

    public CalcButton(String label) {
        super(label);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
    }
}