package code;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private int stock;
    private final int restockThreshold = 5; 
    private final int restockAmount = 20; 
    private List<String> transactionHistory;

    public Product(String name, int initialStock) {
        this.name = name;
        this.stock = initialStock;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean processOrder(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            transactionHistory.add(String.format("Order processed: -%d %s, Remaining stock: %d", quantity, name, stock));
            System.out.printf("Order successful! %d %s shipped. Remaining stock: %d%n", quantity, name, stock);

            if (stock < restockThreshold) {
                restock();
            }
            return true;
        } else {
            System.out.println("Order failed! Invalid quantity or insufficient stock.");
            return false;
        }
    }

    private void restock() {
        stock += restockAmount;
        transactionHistory.add(String.format("Auto-restocked: +%d %s, New stock: %d", restockAmount, name, stock));
        System.out.printf("Auto-restocking triggered! Added %d %s. New stock: %d%n", restockAmount, name, stock);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + name + ":");
        for (String log : transactionHistory) {
            System.out.println(log);
        }
    }

    public int getStock() {
        return stock;
    }
}

public class c07_SmartWarehouse {
    public static void main(String[] args) {
    	
    	// testcase-VT:
//        Product laptop1 = new Product("Laptop", 10);
//        laptop1.processOrder(13);  // quantity > 0 && quantity > stock
//        laptop1.printTransactionHistory();
//        Product laptop2 = new Product("Laptop", 10);
//        laptop2.processOrder(19);  // quantity > 0 && quantity > stock
//        laptop2.printTransactionHistory();
//        Product laptop3 = new Product("Laptop", 10);
//        laptop3.processOrder(2);  // quantity > 0 && quantity < stock && NO restock
//        laptop3.printTransactionHistory();
//        Product laptop4 = new Product("Laptop", 10);
//        laptop4.processOrder(7);  // quantity > 0 && quantity < stock && restock
//        laptop4.printTransactionHistory();
//        Product laptop5 = new Product("Laptop", 10);
//        laptop5.processOrder(-4);  // quantity < 0
//        laptop5.printTransactionHistory();
        
    	// testcase-FT:
//        Product laptop1 = new Product("Laptop", 10);
//        laptop1.processOrder(251); 
//        laptop1.printTransactionHistory();
//        Product laptop2 = new Product("Laptop", 10);
//        laptop2.processOrder(-72898649);  
//        laptop2.printTransactionHistory();
//        Product laptop3 = new Product("Laptop", 10);
//        laptop3.processOrder(6);  
//        laptop3.printTransactionHistory();
//        Product laptop4 = new Product("Laptop", 10);
//        laptop4.processOrder(1645);  
//        laptop4.printTransactionHistory();
//        Product laptop5 = new Product("Laptop", 10);
//        laptop5.processOrder(109);  
//        laptop5.printTransactionHistory();
    	
    	// testcase-Z3:
//        Product laptop1 = new Product("Laptop", 10);
//        laptop1.processOrder(16);  // quantity > 0 && quantity > stock
//        laptop1.printTransactionHistory();
//        Product laptop2 = new Product("Laptop", 10);
//        laptop2.processOrder(9);  // quantity > 0 && quantity > stock
//        laptop2.printTransactionHistory();
//        Product laptop3 = new Product("Laptop", 10);
//        laptop3.processOrder(11);  // quantity > 0 && quantity < stock && NO restock
//        laptop3.printTransactionHistory();
//        Product laptop4 = new Product("Laptop", 10);
//        laptop4.processOrder(9);  // quantity > 0 && quantity < stock && restock
//        laptop4.printTransactionHistory();
//        Product laptop5 = new Product("Laptop", 10);
//        laptop5.processOrder(11);  // quantity < 0
//        laptop5.printTransactionHistory();
        
    	// testcase-UVT:
        Product laptop1 = new Product("Laptop", 10);
        laptop1.processOrder(13);  // quantity > 0 && quantity > stock
        laptop1.printTransactionHistory();
        Product laptop2 = new Product("Laptop", 10);
        laptop2.processOrder(19);  // quantity > 0 && quantity > stock
        laptop2.printTransactionHistory();
        Product laptop3 = new Product("Laptop", 10);
        laptop3.processOrder(2);  // quantity > 0 && quantity < stock && NO restock
        laptop3.printTransactionHistory();
        Product laptop4 = new Product("Laptop", 10);
        laptop4.processOrder(7);  // quantity > 0 && quantity < stock && restock
        laptop4.printTransactionHistory();
        Product laptop5 = new Product("Laptop", 10);
        laptop5.processOrder(-4);  // quantity < 0
        laptop5.printTransactionHistory();
    	
    }
}
