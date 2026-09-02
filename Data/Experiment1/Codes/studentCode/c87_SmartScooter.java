package code;

public class c87_SmartScooter {

    private double batteryCapacity;      
    private double currentBattery;      
    private double consumptionRate;      
    private double lowBatteryThreshold;  

    public c87_SmartScooter(double batteryCapacity, double initialBattery, double consumptionRate, double lowBatteryThreshold) {
        this.batteryCapacity = batteryCapacity;
        this.currentBattery = initialBattery;
        this.consumptionRate = consumptionRate;
        this.lowBatteryThreshold = lowBatteryThreshold;
    }

    public void recharge(double newBatteryLevel) {
        if(newBatteryLevel > batteryCapacity) {
            currentBattery = batteryCapacity;
        } else {
            currentBattery = newBatteryLevel;
        }
        System.out.printf("Battery recharged to: %.2f kWh%n", currentBattery);
    }

    public void consumeEnergy(double energyUsed) {
        if (energyUsed < 0) {
            System.out.println("Invalid energy consumption value.");
            return;
        }
        currentBattery -= energyUsed;
        if (currentBattery < 0) {
            currentBattery = 0;
        }
        double remainingRange = currentBattery / consumptionRate;  
        System.out.printf("Energy Consumed: %.2f kWh, Remaining Battery: %.2f kWh, Estimated Range: %.2f km%n",
                          energyUsed, currentBattery, remainingRange);
        if (currentBattery < lowBatteryThreshold) {
            System.out.println("ALERT: Battery level is low! Please recharge soon.");
        }
    }

    public double getCurrentBattery() {
        return currentBattery;
    }
    
    public double getEstimatedRange() {
        return currentBattery / consumptionRate;
    }
    
    public static void main(String[] args) {
    	c87_SmartScooter scooter = new c87_SmartScooter(2.0, 1.5, 0.1, 0.3);
        
        // testcase-VT:
//        scooter.consumeEnergy(0.5);  
//        scooter.consumeEnergy(0.7);  
//        scooter.consumeEnergy(-0.7);
//        scooter.consumeEnergy(1.7); 
//        scooter.recharge(2.0);      
//        scooter.consumeEnergy(1.8);
//        scooter.recharge(10.0);
        
        //testcase-FT:
//        scooter.consumeEnergy(4.9E-324);  
//        scooter.consumeEnergy(0.0);  
//        scooter.consumeEnergy(1.2522728504648997E292);
//        scooter.consumeEnergy(3.2071925864657505E294); 
//        scooter.consumeEnergy(1.7976931348623103E308);      
//        scooter.consumeEnergy(-7.543261389422266E307);
//        scooter.consumeEnergy(7.022238808055902E305);
    	
        // testcase-Z3:
//        scooter.consumeEnergy(0.5);  
//        scooter.consumeEnergy(0.7);  
//        scooter.consumeEnergy(-0.7);
//        scooter.consumeEnergy(1.7); 
//        scooter.recharge(2.0);      
//        scooter.consumeEnergy(1.8);
//        scooter.recharge(10.0);
        
        // testcase-UVT:
        scooter.consumeEnergy(0.5);  
        scooter.consumeEnergy(0.7);  
        scooter.consumeEnergy(-0.7);
        scooter.consumeEnergy(1.7); 
        scooter.recharge(2.0);      
        scooter.consumeEnergy(1.8);
        scooter.recharge(10.0);
    }
}
