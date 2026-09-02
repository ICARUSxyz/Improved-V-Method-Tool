package code;

class SmartBoiler68 {
    private double maxTemperature;
    private double minTemperature;
    private double currentTemperature;
    private boolean heatingActive;

    public SmartBoiler68(double maxTemperature, double minTemperature, double initialTemperature) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.currentTemperature = initialTemperature;
        this.heatingActive = false;
    }

    public void updateTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        manageHeatingSystem();

        System.out.printf("Current Water Temperature: %.2f°C\n", currentTemperature);
        if (heatingActive) {
            System.out.println("Heating System Activated.");
        } else {
            System.out.println("Heating System Deactivated.");
        }
    }

    private void manageHeatingSystem() {
        if (currentTemperature < minTemperature) {
            heatingActive = true;
        } else if (currentTemperature > maxTemperature) {
            heatingActive = false;
        }
    }
}

public class c68_SmartBoilerSystem {
    public static void main(String[] args) {
        SmartBoiler68 boiler = new SmartBoiler68(80.0, 40.0, 60.0); 

        // testcase-VT:
//        boiler.updateTemperature(-25.0);  
//        boiler.updateTemperature(20.0);   
//        boiler.updateTemperature(30.0);   
//        boiler.updateTemperature(-10.0);
        
        // testcase-FT:
//        boiler.updateTemperature(-1.360606960895792E308);  
//        boiler.updateTemperature(0.0);   
//        boiler.updateTemperature(4.9E-324);   
//        boiler.updateTemperature(-3.934312560431096E307);
        
        // testcase-Z3:
//        boiler.updateTemperature(-25.0);  
//        boiler.updateTemperature(20.0);   
//        boiler.updateTemperature(30.0);   
//        boiler.updateTemperature(-10.0);
        
        // testcase-UVT:
        boiler.updateTemperature(-25.0);  
        boiler.updateTemperature(20.0);   
        boiler.updateTemperature(30.0);   
        boiler.updateTemperature(-10.0);
    }
}
