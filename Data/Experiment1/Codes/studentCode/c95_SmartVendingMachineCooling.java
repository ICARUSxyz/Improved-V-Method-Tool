package code;

public class c95_SmartVendingMachineCooling {

    private double minTemperature;  
    private double maxTemperature;  
    private double currentTemperature; 
    private boolean coolingActive;   

    public c95_SmartVendingMachineCooling(double minTemperature, double maxTemperature, double initialTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = initialTemperature;
        this.coolingActive = false;
    }

    public void updateTemperature(double newTemperature) {
        currentTemperature = newTemperature;
        adjustCoolingSystem();
        System.out.printf("Current Temperature: %.2f°C, Cooling: %s%n",
                currentTemperature, coolingActive ? "ON" : "OFF");

        if (coolingActive) {
            System.out.println("Cooling system activated to reduce temperature.");
        } else {
            System.out.println("Temperature is within the optimal range.");
        }
    }

    private void adjustCoolingSystem() {
        if (currentTemperature > maxTemperature) {
            coolingActive = true;
        } else if (currentTemperature < minTemperature) {
            coolingActive = false;
        }
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public static void main(String[] args) {
    	c95_SmartVendingMachineCooling vendingCooling = new c95_SmartVendingMachineCooling(2.0, 8.0, 5.0);

        // testcase-VT:
//        vendingCooling.updateTemperature(10.0); 
//        vendingCooling.updateTemperature(5.0);  
//        vendingCooling.updateTemperature(1.0); 
        
        // testcase-FT:
//        vendingCooling.updateTemperature(-1.7976931348623157E308); 
//        vendingCooling.updateTemperature(-4.9E-324);  
//        vendingCooling.updateTemperature(1.7292085181828155E293); 
    	
        // testcase-Z3:
//        vendingCooling.updateTemperature(10.0); 
//        vendingCooling.updateTemperature(5.0);  
//        vendingCooling.updateTemperature(1.0); 
        
        // testcase-UVT:
        vendingCooling.updateTemperature(10.0); 
        vendingCooling.updateTemperature(5.0);  
        vendingCooling.updateTemperature(1.0); 
    }
}
