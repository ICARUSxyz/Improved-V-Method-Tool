package code;

class SmartVendingMachine {
    private int totalInventory;     
    private int currentInventory;   
    private double pricePerItem;     

    public SmartVendingMachine(int totalInventory, double pricePerItem) {
        this.totalInventory = totalInventory;
        this.currentInventory = totalInventory;
        this.pricePerItem = pricePerItem;
    }

    public void purchaseItems(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity requested.");
            return;
        }
        if (quantity > currentInventory) {
            System.out.println("Purchase failed: Not enough inventory.");
        } else {
            currentInventory -= quantity;
            double totalCost = quantity * pricePerItem;
            System.out.printf("Purchase successful. Total cost: $%.2f. Remaining inventory: %d%n", totalCost, currentInventory);
        }
        if (currentInventory < totalInventory * 0.2) {
            System.out.println("Warning: Inventory below 20%. Please refill.");
        }
    }
    
    public int getCurrentInventory() {
        return currentInventory;
    }
}

public class c70_SmartVendingMachineSystem {
    public static void main(String[] args) {
        SmartVendingMachine machine = new SmartVendingMachine(100, 2.50);

        // testcase-VT:
//        machine.purchaseItems(30);   
//        machine.purchaseItems(50);   
//        machine.purchaseItems(25);  
//        machine.purchaseItems(10); 
//        machine.purchaseItems(-10); 
        
        // testcase-FT:
//        machine.purchaseItems(222);   
//        machine.purchaseItems(36);   
//        machine.purchaseItems(548);  
//        machine.purchaseItems(35964100); 
//        machine.purchaseItems(74543473); 
        
        // testcase-Z3:
//        machine.purchaseItems(30);   
//        machine.purchaseItems(50);   
//        machine.purchaseItems(25);  
//        machine.purchaseItems(10); 
//        machine.purchaseItems(-10); 
        
        // testcase-UVT:
        machine.purchaseItems(30);   
        machine.purchaseItems(50);   
        machine.purchaseItems(25);  
        machine.purchaseItems(10); 
        machine.purchaseItems(-10); 
    }
}

