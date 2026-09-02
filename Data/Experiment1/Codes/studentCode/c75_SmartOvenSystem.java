package code;

class SmartOven {
    private double targetTemperature;    
    private double currentTemperature;  
    private double baseCookingTime;      
    private double calculatedCookingTime;

    public SmartOven(double targetTemperature, double initialTemperature, double baseCookingTime) {
        this.targetTemperature = targetTemperature;
        this.currentTemperature = initialTemperature;
        this.baseCookingTime = baseCookingTime;
        this.calculatedCookingTime = baseCookingTime;
    }

    public void updateTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        adjustCookingTime();
        System.out.printf("Current Temperature: %.2f°C, Calculated Cooking Time: %.2f minutes%n",
                          currentTemperature, calculatedCookingTime);
        if (currentTemperature < targetTemperature - 5) {
            System.out.println("ALERT: Temperature too low! Extending cooking time.");
        } else if (currentTemperature > targetTemperature + 5) {
            System.out.println("ALERT: Temperature too high! Reducing cooking time.");
        } else {
            System.out.println("Temperature is within optimal range.");
        }
    }

    private void adjustCookingTime() {
        if (currentTemperature < targetTemperature) {
            calculatedCookingTime = baseCookingTime * 1.1;
        } else if (currentTemperature > targetTemperature) {
            calculatedCookingTime = baseCookingTime * 0.9;
        } else {
            calculatedCookingTime = baseCookingTime;
        }
    }

    public double getCalculatedCookingTime() {
        return calculatedCookingTime;
    }
    
    public double getCurrentTemperature() {
        return currentTemperature;
    }
}

public class c75_SmartOvenSystem {
    public static void main(String[] args) {
        SmartOven oven = new SmartOven(180.0, 170.0, 30.0);
        
        // testcase-VT:
//        oven.updateTemperature(5.0);  
//        oven.updateTemperature(-10.0); 
//        oven.updateTemperature(20.0);  
//        oven.updateTemperature(200.0);
//        oven.updateTemperature(-205.0);

        // testcase-FT:
//        oven.updateTemperature(1.6349678233795336E296);  
//        oven.updateTemperature(-1.7976931348623157E308); 
//        oven.updateTemperature(0.0);  
//        oven.updateTemperature(-2.2250738585072014E-308);
//        oven.updateTemperature(6.365249299686023E293);
        
        // testcase-Z3
//        oven.updateTemperature(5.0);  
//        oven.updateTemperature(-10.0); 
//        oven.updateTemperature(20.0);  
//        oven.updateTemperature(200.0);
//        oven.updateTemperature(-205.0);
        
        // testcase-UVT:
        oven.updateTemperature(5.0);  
        oven.updateTemperature(-10.0); 
        oven.updateTemperature(20.0);  
        oven.updateTemperature(200.0);
        oven.updateTemperature(-205.0);
    }
}
