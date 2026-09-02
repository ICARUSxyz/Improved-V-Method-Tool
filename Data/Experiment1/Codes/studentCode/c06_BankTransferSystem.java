package code;
import java.util.ArrayList;
import java.util.List;

class BankAccount06 {
    private String accountHolder;
    private double balance;

    public BankAccount06(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public boolean transfer(BankAccount06 recipient, double amount, TransactionLogger logger) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            recipient.balance += amount;
            logger.logTransaction(this.accountHolder, recipient.accountHolder, amount);
            System.out.printf("Transfer successful! %s -> %s: %.2f%n", this.accountHolder, recipient.accountHolder, amount);
            return true;
        } else {
            System.out.println("Transfer failed! Invalid amount or insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

class TransactionLogger {
    private List<String> transactionLog = new ArrayList<>();

    public void logTransaction(String sender, String recipient, double amount) {
        String logEntry = String.format("Transaction: %s -> %s | Amount: %.2f", sender, recipient, amount);
        transactionLog.add(logEntry);
    }

    public void printTransactionLog() {
        System.out.println("Transaction History:");
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}

public class c06_BankTransferSystem {
    public static void main(String[] args) {

        TransactionLogger logger = new TransactionLogger();
        
    	// testcase-VT:
//        BankAccount06 alice1 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob1 = new BankAccount06("Bob", 500);
//        alice1.transfer(bob1, 120.87, logger);  // amount > 0 && amount <= this.balance
//        BankAccount06 alice2 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob2 = new BankAccount06("Bob", 500);
//        alice2.transfer(bob2, 2640.44, logger);  // amount > 0 && amount > this.balance
//        BankAccount06 alice3 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob3 = new BankAccount06("Bob", 500);
//        alice3.transfer(bob3, -92, logger);  // amount < 0 
        
        // testcase-FT:
//        BankAccount06 alice1 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob1 = new BankAccount06("Bob", 500);
//        alice1.transfer(bob1, 1.7976931348623157E308, logger);  // amount > 0 && amount <= this.balance
//        BankAccount06 alice2 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob2 = new BankAccount06("Bob", 500);
//        alice2.transfer(bob2, 4.9E-324, logger);  // amount > 0 && amount > this.balance
//        BankAccount06 alice3 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob3 = new BankAccount06("Bob", 500);
//        alice3.transfer(bob3, 3.313394118237622E307, logger);  // amount < 0 
        
       	// testcase-Z3:
//        BankAccount06 alice1 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob1 = new BankAccount06("Bob", 500);
//        alice1.transfer(bob1, 16, logger);  // amount > 0 && amount <= this.balance
//        BankAccount06 alice2 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob2 = new BankAccount06("Bob", 500);
//        alice2.transfer(bob2, -1, logger);  // amount > 0 && amount > this.balance
//        BankAccount06 alice3 = new BankAccount06("Alice", 1000);
//        BankAccount06 bob3 = new BankAccount06("Bob", 500);
//        alice3.transfer(bob3, 1, logger);  // amount < 0 
        
       	// testcase-UVT:
        BankAccount06 alice1 = new BankAccount06("Alice", 1000);
        BankAccount06 bob1 = new BankAccount06("Bob", 500);
        alice1.transfer(bob1, 120.87, logger);  // amount > 0 && amount <= this.balance
        BankAccount06 alice2 = new BankAccount06("Alice", 1000);
        BankAccount06 bob2 = new BankAccount06("Bob", 500);
        alice2.transfer(bob2, 44, logger);  // amount > 0 && amount > this.balance
        BankAccount06 alice3 = new BankAccount06("Alice", 1000);
        BankAccount06 bob3 = new BankAccount06("Bob", 500);
        alice3.transfer(bob3, -92, logger);  // amount < 0 
        
        
        // print log
        logger.printTransactionLog();
    }
}
