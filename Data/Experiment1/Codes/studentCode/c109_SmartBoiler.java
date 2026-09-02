package code;

public class c109_SmartBoiler {

    private double minTemperature;   
    private double maxTemperature;   
    private double currentTemperature; 
    private boolean heatingActive;  

    public c109_SmartBoiler(double minTemperature, double maxTemperature, double initialTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = initialTemperature;
        this.heatingActive = false;
    }

    public void updateTemperature(double newTemperature) {
        currentTemperature = newTemperature;
        adjustHeatingSystem();
        System.out.printf("Current Water Temperature: %.2f°C, Heating: %s%n",
                currentTemperature, heatingActive ? "ON" : "OFF");

        if (heatingActive) {
            System.out.println("Heating system activated to increase temperature.");
        } else {
            System.out.println("Temperature is within the optimal range.");
        }
    }

    private void adjustHeatingSystem() {
        if (currentTemperature < minTemperature) {
            heatingActive = true;
        } else if (currentTemperature > maxTemperature) {
            heatingActive = false;
        }
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public static void main(String[] args) {
    	c109_SmartBoiler boiler = new c109_SmartBoiler(40.0, 80.0, 60.0);

        // testcase-VT:
//        boiler.updateTemperature(35.0); 
//        boiler.updateTemperature(70.0); 
//        boiler.updateTemperature(85.0); 
        
        // testcase-FT:
//        boiler.updateTemperature(-1.7976931348623157E308); 
//        boiler.updateTemperature(0.0); 
//        boiler.updateTemperature(4.9E-324); 
    	
        // testcase-Z3:
//        boiler.updateTemperature(35.0); 
//        boiler.updateTemperature(70.0); 
//        boiler.updateTemperature(85.0); 
        
        // testcase-UVT:
        boiler.updateTemperature(35.0); 
        boiler.updateTemperature(70.0); 
        boiler.updateTemperature(85.0); 
    }
}
