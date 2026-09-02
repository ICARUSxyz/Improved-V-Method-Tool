package code;

public class c81_SmartGasWaterHeater {

    private double minTemperature; 
    private double maxTemperature; 
    private double currentTemperature; 
    private boolean burnerActive;  

    public c81_SmartGasWaterHeater(double minTemperature, double maxTemperature, double initialTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = initialTemperature;
        this.burnerActive = false;
    }

    public void updateTemperature(double newTemperature) {
        currentTemperature = newTemperature;
        adjustBurnerState();
        System.out.printf("Current Water Temperature: %.2f°C, Burner: %s%n",
                currentTemperature,
                burnerActive ? "ON" : "OFF");

        if (burnerActive) {
            System.out.println("ALERT: Low temperature detected. Burner activated.");
        } else {
            System.out.println("Water temperature is optimal or too high. Burner deactivated.");
        }
    }

    private void adjustBurnerState() {
        if (currentTemperature < minTemperature) {
            burnerActive = true;
        } else if (currentTemperature > maxTemperature) {
            burnerActive = false;
        }
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public static void main(String[] args) {
    	c81_SmartGasWaterHeater heater = new c81_SmartGasWaterHeater(40.0, 60.0, 50.0);

        // testcase-VT:
//        heater.updateTemperature(35.0);  
//        heater.updateTemperature(65.0);  
//        heater.updateTemperature(50.0);
        
        // testcase-FT:
//        heater.updateTemperature(-1.7976931348623157E308);  
//        heater.updateTemperature(1.7976931348614663E308);  
//        heater.updateTemperature(0.0);
        
        // testcase-VT:
//        heater.updateTemperature(35.0);  
//        heater.updateTemperature(65.0);  
//        heater.updateTemperature(50.0);
        
        // testcase-UVT:
        heater.updateTemperature(35.0);  
        heater.updateTemperature(65.0);  
        heater.updateTemperature(50.0);
    }
}
