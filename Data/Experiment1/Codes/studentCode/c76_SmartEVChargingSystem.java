package code;

class SmartEVCharger {
    private double baseRate;       
    private double penaltyRate;   
    private double threshold;      
    private double currentConsumption; 

    public SmartEVCharger(double baseRate, double penaltyRate, double threshold) {
        this.baseRate = baseRate;
        this.penaltyRate = penaltyRate;
        this.threshold = threshold;
        this.currentConsumption = 0.0;
    }

    public void addConsumption(double kWh) {
        if (kWh < 0) {
            System.out.println("Invalid consumption value. Must be positive.");
            return;
        }
        currentConsumption += kWh;
        double fee;
        if (currentConsumption <= threshold) {
            fee = currentConsumption * baseRate;
        } else {
            fee = threshold * baseRate + (currentConsumption - threshold) * (baseRate + penaltyRate);
        }
        System.out.printf("Current Consumption: %.2f kWh, Calculated Fee: $%.2f%n", currentConsumption, fee);
    }

    public double getCurrentConsumption() {
        return currentConsumption;
    }
    
    public double calculateFee() {
        if (currentConsumption <= threshold) {
            return currentConsumption * baseRate;
        } else {
            return threshold * baseRate + (currentConsumption - threshold) * (baseRate + penaltyRate);
        }
    }
}

public class c76_SmartEVChargingSystem {
    public static void main(String[] args) {
        SmartEVCharger charger = new SmartEVCharger(0.20, 0.10, 50.0);

        // testcase-VT:
//        charger.addConsumption(30.0);  
//        charger.addConsumption(15.0); 
//        charger.calculateFee();
//        charger.addConsumption(10.0); 
//        charger.addConsumption(-10.0);
//        charger.calculateFee();
        
        // testcase-FT:
//        charger.addConsumption(4.1593684296814365E307);  
//        charger.addConsumption(1.5778637915857737E293); 
//        charger.addConsumption(7.683982623208027E307);
//        charger.addConsumption(0.0); 
//        charger.addConsumption(-1.7906708960542598E308);
//        charger.calculateFee();
        
        // testcase-Z3:
//        charger.addConsumption(30.0);  
//        charger.addConsumption(15.0); 
//        charger.calculateFee();
//        charger.addConsumption(10.0); 
//        charger.addConsumption(-10.0);
//        charger.calculateFee();
        
        // testcase-UVT:
        charger.addConsumption(30.0);  
        charger.addConsumption(15.0); 
        charger.calculateFee();
        charger.addConsumption(10.0); 
        charger.addConsumption(-10.0);
        charger.calculateFee();
    }
}
