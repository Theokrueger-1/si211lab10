import java.util.*;

public class FinComp {
    private double amount;
    private double rate;
    private double payment;
    private double totalPayed;
    private double overpayed;

    public FinComp(double amount, double rate, double payment) {
        this.amount = amount;
        this.rate = rate;
        this.payment = payment;
        this.totalPayed = 0;
    }
    
    //end of each month accrue interest = balance *rate /1200
    public int calculatePayoffTime() {
        double monthlyRate = rate / 1200;
        int months = 0;
        double balance = amount;

        while (balance > 0) {
            balance += balance * monthlyRate; // Add interest
            balance -= payment; // Subtract payment
            months++;
            totalPayed += payment; // Keep track of total paid
        }
        if (balance < 0) {
            overpayed = -balance; // Adjust total paid if we overpay in the last month
        }
        return months;
    }

    public double calculateTotalCost() {
        //return only two decimal places
        return Math.round((totalPayed - overpayed - amount) * 100.0) / 100.0; // Total cost is total paid minus the original amount and any overpayment
    }
}