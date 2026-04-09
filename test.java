public class test
{
    public static void main(String[] args) {
        FinComp finComp = new FinComp(10000, 5.75, 250);
        int payoffTime = finComp.calculatePayoffTime();
        double totalCost = finComp.calculateTotalCost();
        System.out.println("Payoff Time (months): " + payoffTime);
        System.out.println("Total Cost: $" + totalCost);
    }
}