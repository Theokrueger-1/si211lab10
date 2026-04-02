//Theo Krueger Arjun Mandadi
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class GUIShell extends JFrame {
    private JTextField fldPayoff;
    private JTextField fldCost;
    private JTextField fldLoanAmount;
    private JButton btPayoff;

    public GUIShell() {
        super();
        JTextField fldPayoff = new JTextField(14);
        JTextField fldCost = new JTextField(14);
        JTextField fldLoanAmount = new JTextField(14);
        JTextField fldMonPay = new JTextField(14);
        //3.5 to 7.5 in .25 increments
        JComboBox<Double> comboBox = new JComboBox<>(new Double[]{3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0, 5.25, 5.5, 5.75, 6.0, 6.25, 6.5, 6.75, 7.0, 7.25, 7.5});
        
        // Add a panel to the center to display the months to payoff
        JPanel panelA = new JPanel(new FlowLayout());
        panelA.add(new JLabel("months to payoff"));
        panelA.add(fldPayoff);
        add(panelA, BorderLayout.CENTER);

        //Add a panel to the south to display the cost of the loan
        JPanel panelB = new JPanel(new FlowLayout());
        panelB.add(new JLabel("cost"));
        panelB.add(fldCost);
        add(panelB, BorderLayout.SOUTH);

        //left of north loan amoount
        JPanel panelC = new JPanel(new FlowLayout());
        panelC.add(new JLabel("loan amount"));
        panelC.add(fldLoanAmount);

        //center of north - interest rate 
        panelC.add(new JLabel("interest rate"));        
        panelC.add(comboBox);

        //right of north - monthly payment
        panelC.add(new JLabel("monthly payment"));
        panelC.add(fldMonPay);
        add(panelC, BorderLayout.NORTH);

        //Add a button to the east to calculate the payoff time
        JPanel panelD = new JPanel(new FlowLayout());
        JButton btPayoff = new JButton("calculate");;
        panelD.add(btPayoff);
        add(panelD, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action listener to the button and allow the user to hit enter to calculate the payoff time
    }

    //ACTION LISTENER for the button and allow the user to hit enter to calculate the payoff time
    private class PayoffListener implements ActionListener {
        
    public static void main(String[] args) {
        JFrame f = new GUIShell();
        f.pack();
        f.setVisible(true);
        
    }
    
}