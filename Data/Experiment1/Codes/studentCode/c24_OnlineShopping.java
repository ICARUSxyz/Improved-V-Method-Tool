package code;

import java.util.*;

class Purchase {
    private String customerName;
    private double totalAmount;
    private String promoCode;
    private double discount;
    private double finalPrice;

    public Purchase(String customerName, double totalAmount, String promoCode) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.promoCode = promoCode;
        this.discount = calculateDiscount();
        this.finalPrice = totalAmount - discount;
    }

    private double calculateDiscount() {
        double discount = 0.0;

        if (totalAmount > 200) {
            discount = totalAmount * 0.10; 
        } else if (totalAmount > 100) {
            discount = totalAmount * 0.05; 
        }

        if (promoCode.equalsIgnoreCase("SALE20")) {
            discount += 20.0; 
        } else if (promoCode.equalsIgnoreCase("SALE10")) {
            discount += 10.0; 
        }

        return Math.min(discount, totalAmount);
    }

    public String getPurchaseDetails() {
        return String.format("Customer: %s | Total: $%.2f | Discount: $%.2f | Final Price: $%.2f | Promo Code: %s",
                customerName, totalAmount, discount, finalPrice, promoCode.isEmpty() ? "None" : promoCode);
    }
}

class OnlineShoppingSystem {
    private List<String> purchaseLog;

    public OnlineShoppingSystem() {
        this.purchaseLog = new ArrayList<>();
    }

    public void processPurchase(String customerName, double amount, String promoCode) {
        Purchase purchase = new Purchase(customerName, amount, promoCode);
        System.out.println(purchase.getPurchaseDetails());
        purchaseLog.add(purchase.getPurchaseDetails());
    }

    public void printPurchaseLog() {
        System.out.println("\nPurchase Log:");
        for (String log : purchaseLog) {
            System.out.println(log);
        }
    }
}

public class c24_OnlineShopping {
    public static void main(String[] args) {
        OnlineShoppingSystem system = new OnlineShoppingSystem();

        // testcase-VT:
//        system.processPurchase("Alice", 90.0, "");       
//        system.processPurchase("Bob", 120.0, "SALE10"); 
//        system.processPurchase("Charlie", 250.0, "SALE20"); 
        system.processPurchase("David", 50.0, "SALE20"); 
        
        // testcase-FT:
//        system.processPurchase("?", -1.7976931348606999E308, "");       
//        system.processPurchase("", -2.7430620331195065E303, ""); 
//        system.processPurchase("?nsd9", -5.294109726373136E305, ""); 
//        system.processPurchase("GGGGW", 2.7233280004857294E293, ""); 

        // testcase-Z3:
//        system.processPurchase("Alice", 90.0, "");       
//        system.processPurchase("Bob", 120.0, "SALE10"); 
//        system.processPurchase("Charlie", 250.0, "SALE20"); 
//        system.processPurchase("David", 50.0, "SALE20"); 
        
        // testcase-UVT:
        system.processPurchase("Alice", 90.0, "");       
        system.processPurchase("Bob", 120.0, "SALE10"); 
        system.processPurchase("Charlie", 250.0, "SALE20"); 
        system.processPurchase("David", 50.0, "SALE20"); 
        system.printPurchaseLog();
    }
}
