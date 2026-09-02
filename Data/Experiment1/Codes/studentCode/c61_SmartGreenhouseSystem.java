package code;

class SmartGreenhouse {
    private double maxTemperature;
    private double minTemperature;
    private double currentTemperature;
    private boolean coolingActive;
    private boolean heatingActive;

    public SmartGreenhouse(double maxTemperature, double minTemperature, double initialTemperature) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.currentTemperature = initialTemperature;
        this.coolingActive = false;
        this.heatingActive = false;
    }

    public void updateTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        manageTemperatureControl();

        System.out.printf("Current Temperature: %.2f°C%n", currentTemperature);
        if (coolingActive) {
            System.out.println("Cooling System Activated.");
        }
        if (heatingActive) {
            System.out.println("Heating System Activated.");
        }
    }

    private void manageTemperatureControl() {
        if (currentTemperature > maxTemperature) {
            coolingActive = true;
            heatingActive = false;
        } else if (currentTemperature < minTemperature) {
            coolingActive = false;
            heatingActive = true;
        } else {
            coolingActive = false;
            heatingActive = false;
        }
    }
}

public class c61_SmartGreenhouseSystem {
    public static void main(String[] args) {
        SmartGreenhouse greenhouse = new SmartGreenhouse(30.0, 15.0, 22.0); 

        // testcase-VT:
        greenhouse.updateTemperature(10.0);  
        greenhouse.updateTemperature(-12.0); 
        greenhouse.updateTemperature(-8.0);  
        greenhouse.updateTemperature(6.0); 
        
        // testcase-FT:
//        greenhouse.updateTemperature(0.0);  
//        greenhouse.updateTemperature(4.9E-324); 
//        greenhouse.updateTemperature(-1.7976931348623157E308);  
//        greenhouse.updateTemperature(8.389234629357444E307); 
        
        // testcase-Z3:
//        greenhouse.updateTemperature(10.0);  
//        greenhouse.updateTemperature(-12.0); 
//        greenhouse.updateTemperature(-8.0);  
//        greenhouse.updateTemperature(6.0); 
        
        // testcase-UVT:
        greenhouse.updateTemperature(10.0);  
        greenhouse.updateTemperature(-12.0); 
        greenhouse.updateTemperature(-8.0);  
        greenhouse.updateTemperature(6.0); 
    }
}

