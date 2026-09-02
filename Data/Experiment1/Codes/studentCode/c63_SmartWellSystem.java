package code;

class SmartWell63 {
    private double maxWaterLevel;
    private double minWaterLevel;
    private double currentWaterLevel;
    private boolean pumpActive;

    public SmartWell63(double maxWaterLevel, double minWaterLevel, double initialWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
        this.minWaterLevel = minWaterLevel;
        this.currentWaterLevel = initialWaterLevel;
        this.pumpActive = false;
    }

    public void updateWaterLevel(double changeAmount) {
        currentWaterLevel += changeAmount;
        managePumpControl();

        System.out.printf("Current Water Level: %.2f meters\n", currentWaterLevel);
        if (pumpActive) {
            System.out.println("Water Pump Activated.");
        } else {
            System.out.println("Water Pump Deactivated.");
        }
    }

    private void managePumpControl() {
        if (currentWaterLevel < minWaterLevel) {
            pumpActive = true;
        } else if (currentWaterLevel > maxWaterLevel) {
            pumpActive = false;
        }
    }
}

public class c63_SmartWellSystem {
    public static void main(String[] args) {
        SmartWell63 well = new SmartWell63(10.0, 3.0, 6.0); 

        // testcase-VT:
        well.updateWaterLevel(-4.0); 
        well.updateWaterLevel(5.0);   
        well.updateWaterLevel(4.0);  
        well.updateWaterLevel(-2.0);
        
        // testcase-FT:
//        well.updateWaterLevel(0.0); 
//        well.updateWaterLevel(-1.7976931348623157E308);   
//        well.updateWaterLevel(4.9E-324);  
//        well.updateWaterLevel(1.7976931348623157E308);
        
        // testcase-Z3:
//        well.updateWaterLevel(-4.0); 
//        well.updateWaterLevel(5.0);   
//        well.updateWaterLevel(4.0);  
//        well.updateWaterLevel(-2.0);
        
        // testcase-UVT:
        well.updateWaterLevel(-4.0); 
        well.updateWaterLevel(5.0);   
        well.updateWaterLevel(4.0);  
        well.updateWaterLevel(-2.0);
    }
}

