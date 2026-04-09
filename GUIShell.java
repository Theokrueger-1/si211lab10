//Theo Krueger Arjun Mandadi
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class GUIShell extends JFrame {
    private JTextField fldPayoff;
    private JTextField fldCost = new JTextField(14);
    private JTextField fldLoanAmount;
    private JTextField fldMonPay;
    private JButton btPayoff;
    private double selectedRate;
    private double loanAmount;
    private double monthlyPayment;

    public GUIShell() {
        super();
        fldPayoff = new JTextField(14);
        fldCost = new JTextField(14);
        fldLoanAmount = new JTextField(14);
        fldMonPay = new JTextField(14);
        
        
       
        JPanel panelC = new JPanel(new FlowLayout());
        panelC.add(new JLabel("loan amount"));
        panelC.add(fldLoanAmount);

         //3.5 to 7.5 in .25 increments
        JComboBox<Double> comboBox = new JComboBox<>(new Double[]{3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0, 5.25, 5.5, 5.75, 6.0, 6.25, 6.5, 6.75, 7.0, 7.25, 7.5});
        
        //left of north loan amoount
        //center of north - interest rate 
        panelC.add(new JLabel("interest rate"));        
        panelC.add(comboBox);
        //get the selected interest rate from the combo box and use it in the calculation
        //  of the payoff time and cost of the loan
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedRate = (double) comboBox.getSelectedItem();
            }
        });


        //right of north - monthly payment
        panelC.add(new JLabel("monthly payment"));
        panelC.add(fldMonPay);
        add(panelC, BorderLayout.NORTH);
        // Add a panel to the center to display the months to payoff
        //This is updated when user clicks calculate
        JPanel panelA = new JPanel(new FlowLayout());
        panelA.add(new JLabel("months to payoff"));
        panelA.add(fldPayoff);
        add(panelA, BorderLayout.CENTER);

        //Add a panel to the south to display the cost of the loan
        //This is updated when user clicks calculate
        JPanel panelB = new JPanel(new FlowLayout());
        panelB.add(new JLabel("cost"));
        panelB.add(fldCost);
        add(panelB, BorderLayout.SOUTH);


        //Add a button to the east to calculate the payoff time
        JPanel panelD = new JPanel(new FlowLayout());
        JButton btPayoff = new JButton("calculate");
        btPayoff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loanAmount = Double.parseDouble(fldLoanAmount.getText());
                monthlyPayment = Double.parseDouble(fldMonPay.getText());
                FinComp finComp = new FinComp(loanAmount, selectedRate, monthlyPayment);
                int payoffTime = finComp.calculatePayoffTime();
                double totalCost = finComp.calculateTotalCost();
                fldPayoff.setText(Integer.toString(payoffTime));
                fldCost.setText(Double.toString(totalCost));
            }
        });
        panelD.add(btPayoff);
        add(panelD, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action listener to the button and allow the user to hit enter to calculate the payoff time
    }

    //ACTION LISTENER for the button and allow the user to hit enter to calculate the payoff time

    public static void main(String[] args) {
        JFrame f = new GUIShell();
        f.pack();
        f.setVisible(true);
        
    }
}