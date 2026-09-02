package code;

public class c19_ATMSystem {
    private double accountBalance = 1000;

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;  
            System.out.printf("Withdrawal successful! New balance: %.2f%n", accountBalance);
            return true;
        } else {
            System.out.println("Withdrawal failed! Invalid amount or insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return accountBalance;
    }

    public static void main(String[] args) {
    	c19_ATMSystem myATM = new c19_ATMSystem();  

        // testcase-VT:
//        myATM.withdraw(500); 
//        myATM.withdraw(600);  
//        myATM.withdraw(0);    
//        myATM.withdraw(-200); 
        
        // testcase-FT:
//        myATM.withdraw(-1.7976931348623157E308); 
//        myATM.withdraw(1.1476830219940713E296);  
//        myATM.withdraw(0);    
//        myATM.withdraw(4.169240302727157E298);
        
        // testcase-Z3:
        myATM.withdraw(8); 
        myATM.withdraw(-1);  
        myATM.withdraw(1001);    
        myATM.withdraw(999); 
        
        // testcase-UVT:
//        myATM.withdraw(500); 
//        myATM.withdraw(600);  
//        myATM.withdraw(0);    
//        myATM.withdraw(-200); 
    }
}

