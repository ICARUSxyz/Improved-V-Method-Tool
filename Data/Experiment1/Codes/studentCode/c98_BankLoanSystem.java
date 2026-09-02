package code;

public class c98_BankLoanSystem {

    private double baseInterestRate;  
    private double referenceRateThreshold;  
    private double currentReferenceRate; 
    private double currentLoanRate;  

    public c98_BankLoanSystem(double baseInterestRate, double referenceRateThreshold) {
        this.baseInterestRate = baseInterestRate;
        this.referenceRateThreshold = referenceRateThreshold;
        this.currentReferenceRate = 0.0;
        this.currentLoanRate = baseInterestRate;
    }

    public void updateReferenceRate(double newReferenceRate) {
        currentReferenceRate = newReferenceRate;
        adjustLoanRate();
        System.out.printf("Current Reference Rate: %.2f%%, Loan Interest Rate: %.2f%%%n",
                currentReferenceRate, currentLoanRate);

        if (currentReferenceRate > referenceRateThreshold) {
            System.out.println("ALERT: High reference rate detected. Loan interest rate increased.");
        } else {
            System.out.println("Reference rate within limits. Loan interest rate unchanged.");
        }
    }

    private void adjustLoanRate() {
        if (currentReferenceRate > referenceRateThreshold) {
            currentLoanRate = baseInterestRate + (currentReferenceRate - referenceRateThreshold) * 0.5;
        } else {
            currentLoanRate = baseInterestRate;
        }
    }

    public double getCurrentLoanRate() {
        return currentLoanRate;
    }

    public static void main(String[] args) {
    	c98_BankLoanSystem bankLoan = new c98_BankLoanSystem(5.0, 3.0);

        // testcase-VT:
//        bankLoan.updateReferenceRate(2.5);  
//        bankLoan.updateReferenceRate(3.5);  
//        bankLoan.updateReferenceRate(3.0);  
        
        // testcase-FT:
//        bankLoan.updateReferenceRate(-1.7836486571938841E308);  
//        bankLoan.updateReferenceRate(-1.1586598667603788E308);  
//        bankLoan.updateReferenceRate(-1.1235481369576206E308);  
    	
        // testcase-Z3:
//      bankLoan.updateReferenceRate(2.5);  
//      bankLoan.updateReferenceRate(3.5);  
//      bankLoan.updateReferenceRate(3.0);  
    	
        // testcase-UVT:
      bankLoan.updateReferenceRate(2.5);  
      bankLoan.updateReferenceRate(3.5);  
      bankLoan.updateReferenceRate(3.0);  
    }
}
