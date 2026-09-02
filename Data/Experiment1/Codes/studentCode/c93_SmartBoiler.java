package code;

public class c93_SmartBoiler {

    private double minTemperature;  
    private double maxTemperature;
    private double currentTemperature; 
    private boolean heatingActive; 

    public c93_SmartBoiler(double minTemperature, double maxTemperature, double initialTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = initialTemperature;
        this.heatingActive = false;
    }

    public void updateTemperature(double newTemperature) {
        currentTemperature = newTemperature;
        adjustHeating();
        System.out.printf("Current Boiler Temperature: %.2f°C, Heating: %s%n",
                currentTemperature,
                heatingActive ? "ON" : "OFF");

        if (heatingActive) {
            System.out.println("ALERT: Low temperature detected. Activating heating element.");
        } else {
            System.out.println("Temperature is optimal or too high. Heating element deactivated.");
        }
    }

    private void adjustHeating() {
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
    	c93_SmartBoiler boiler = new c93_SmartBoiler(40.0, 80.0, 60.0);

        // testcase-VT:
//        boiler.updateTemperature(35.0); 
//        boiler.updateTemperature(85.0); 
//        boiler.updateTemperature(60.0);  
        
        // testcase-FT:
//        boiler.updateTemperature(0.0); 
//        boiler.updateTemperature(-1.7976931348623157E308); 
//        boiler.updateTemperature(4.590432711929855E293);
    	
        // testcase-Z3:
//        boiler.updateTemperature(35.0); 
//        boiler.updateTemperature(85.0); 
//        boiler.updateTemperature(60.0);  
        
        // testcase-UVT:
        boiler.updateTemperature(35.0); 
        boiler.updateTemperature(85.0); 
        boiler.updateTemperature(60.0);  
    	
    }
}
