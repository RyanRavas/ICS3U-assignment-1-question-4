import javax.swing.JOptionPane;

// Ryan Ravas
// 4/4/2024

public class Main {
    public static void main(String[] args) {

//      declare all math related required variables
        double principle;
        double interestRatePercent;
        double numberOfYears;
        double monthlyInvestmentReturn;
        double yearlyInvestmentReturn;
//      declare all the output string variables
        String monthlyInvestmentString;
        String yearlyInvestmentString;
        String investmentDiffrenceString;
//      loop program until user says "no"
        int loopInput = 1;
        do {
//          get user input for all required variable values
            principle = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the principle amount in $", "Investment Program", JOptionPane.QUESTION_MESSAGE));
            interestRatePercent = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the interest rate in %", "Investment Program", JOptionPane.QUESTION_MESSAGE));
            numberOfYears = Double.parseDouble((JOptionPane.showInputDialog(null,"Enter number of years", "Investment Program", JOptionPane.QUESTION_MESSAGE)));

//          calculate return for both monthly and yearly compounding
            monthlyInvestmentReturn = investment(principle, interestRatePercent, numberOfYears, "monthly");
            yearlyInvestmentReturn = investment(principle, interestRatePercent, numberOfYears, "yearly");
//
            monthlyInvestmentString = String.format("$%.2f invested at %.1f%% compounded yearly for %.1f years returns: $%.2f\n",
                    principle, interestRatePercent, numberOfYears, yearlyInvestmentReturn);
            yearlyInvestmentString = String.format("$%.2f invested at %.1f%% compounded monthly for %.1f years returns: $%.2f\n",
                    principle, interestRatePercent, numberOfYears, monthlyInvestmentReturn);
            investmentDiffrenceString = String.format("The investment compounding monthly will earn $%.2f more than the investment compounding yearly",
                    monthlyInvestmentReturn - yearlyInvestmentReturn);
            JOptionPane.showMessageDialog(null, monthlyInvestmentString, "Investment Program", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, yearlyInvestmentString, "Investment Program", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, investmentDiffrenceString, "Investment Program", JOptionPane.INFORMATION_MESSAGE);

//          yes returns 0
//          no returns 1
            loopInput = JOptionPane.showConfirmDialog(null,
                    "Would you like to go again",
                    "Investment Program",
                    JOptionPane.YES_NO_OPTION);
        } while (loopInput != 1);
    }
    public static double investment(double principle, double interestRatePercent, double numberOfYears, String compoundType) {
        if (compoundType.equalsIgnoreCase("yearly")) {
            return principle * Math.pow(1 + (interestRatePercent / 100),
                    numberOfYears);
        } else if (compoundType.equalsIgnoreCase("monthly")) {
            return principle * Math.pow(1 + ( (interestRatePercent / 100) / 12),
                    numberOfYears * 12);
        } else {
            return 0;
        }
    }
}