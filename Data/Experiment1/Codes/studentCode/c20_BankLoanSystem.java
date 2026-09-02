package code;

import java.util.*;

class LoanApplication {
    private String applicantName;
    private double income;
    private double requestedAmount;
    private int creditScore;
    private double approvedAmount;

    public LoanApplication(String applicantName, double income, double requestedAmount, int creditScore) {
        this.applicantName = applicantName;
        this.income = income;
        this.requestedAmount = requestedAmount;
        this.creditScore = creditScore;
        this.approvedAmount = evaluateLoan();
    }

    private double evaluateLoan() {
        double maxLoanAmount = income * 5; 

        if (creditScore < 600) {
            return 0.0; 
        } else if (requestedAmount <= maxLoanAmount) {
            return requestedAmount; 
        } else if (requestedAmount <= maxLoanAmount * 1.2) {
            return maxLoanAmount; 
        } else {
            return 0.0; 
        }
    }

    public boolean isApproved() {
        return approvedAmount > 0;
    }

    public String getApprovalDetails() {
        if (isApproved()) {
            return String.format("Applicant: %s | Requested: $%.2f | Approved: $%.2f | Credit Score: %d",
                    applicantName, requestedAmount, approvedAmount, creditScore);
        } else {
            return String.format("Applicant: %s | Requested: $%.2f | Loan Denied | Credit Score: %d",
                    applicantName, requestedAmount, creditScore);
        }
    }
}

class LoanApprovalSystem {
    private List<String> loanDecisionLog;

    public LoanApprovalSystem() {
        this.loanDecisionLog = new ArrayList<>();
    }

    public void processLoanApplication(String name, double income, double amount, int creditScore) {
        LoanApplication application = new LoanApplication(name, income, amount, creditScore);
        System.out.println(application.getApprovalDetails());

        if (application.isApproved()) {
            loanDecisionLog.add(application.getApprovalDetails());
        }
    }

    public void printLoanDecisionLog() {
        System.out.println("\nLoan Decision Log:");
        for (String log : loanDecisionLog) {
            System.out.println(log);
        }
    }
}

public class c20_BankLoanSystem {
    public static void main(String[] args) {
        LoanApprovalSystem system = new LoanApprovalSystem();

        // testcase-VT:
//        system.processLoanApplication("Alice", 50000, 200000, 720); 
//        system.processLoanApplication("Bob", 40000, 250000, 680);   
//        system.processLoanApplication("Charlie", 30000, 180000, 500); 
//        system.processLoanApplication("David", 60000, 700000, 750); 
//        system.processLoanApplication("Eve", 40000, 220000, 680);  
        
        // testcase-FT:
//        system.processLoanApplication("", 44953.21598647061, 15132.906611333936, 33149); 
//        system.processLoanApplication("?", 44953.21598647061, 781140.719111334, 33149);   
//        system.processLoanApplication("?dlice", 58223.6782719807, -499.9998640002624, 0); 
//        system.processLoanApplication("?Idlic", 58222.633361816406, -499.99999937997376, 26572181); 
//        system.processLoanApplication("", -499.9999999999933, -500, 0);     
        
        // testcase-Z3:
//        system.processLoanApplication("Alice", 50000, 200000, 197); 
//        system.processLoanApplication("Bob", 40000, 250000, -1);   
//        system.processLoanApplication("Charlie", 30000, 180000, 601); 
//        system.processLoanApplication("David", 60000, 700000, 599); 
//        system.processLoanApplication("Eve", 40000, 220000, 601); 
        
        // testcase-UVT:
        system.processLoanApplication("Alice", 50000, 200000, 720); 
        system.processLoanApplication("Bob", 40000, 250000, 680);   
        system.processLoanApplication("Charlie", 30000, 180000, 500); 
        system.processLoanApplication("David", 60000, 700000, 750); 
        system.processLoanApplication("Eve", 40000, 220000, 680); 
        
        system.printLoanDecisionLog(); 
    }
}

