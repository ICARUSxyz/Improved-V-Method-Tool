package code;

class SmartRoadSafety64 {
    private double freezingPoint;
    private double stopSaltDispersionTemp;
    private double currentTemperature;
    private boolean saltDispersionActive;

    public SmartRoadSafety64(double freezingPoint, double stopSaltDispersionTemp, double initialTemperature) {
        this.freezingPoint = freezingPoint;
        this.stopSaltDispersionTemp = stopSaltDispersionTemp;
        this.currentTemperature = initialTemperature;
        this.saltDispersionActive = false;
    }

    public void updateRoadTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        manageSaltDispersion();

        System.out.printf("Current Road Temperature: %.2f°C\n", currentTemperature);
        if (saltDispersionActive) {
            System.out.println("Anti-Icing Salt Dispersion Activated.");
        } else {
            System.out.println("Anti-Icing Salt Dispersion Deactivated.");
        }
    }

    private void manageSaltDispersion() {
        if (currentTemperature < freezingPoint) {
            saltDispersionActive = true;
        } else if (currentTemperature > stopSaltDispersionTemp) {
            saltDispersionActive = false;
        }
    }
}

public class c64_SmartRoadSafetySystem {
    public static void main(String[] args) {
        SmartRoadSafety64 roadSafety = new SmartRoadSafety64(0.0, 5.0, 3.0); 

        // testcase-VT:
//        roadSafety.updateRoadTemperature(-4.0);  
//        roadSafety.updateRoadTemperature(3.0);  
//        roadSafety.updateRoadTemperature(4.0);  
//        roadSafety.updateRoadTemperature(-7.0);
        
        // testcase-FT:
//        roadSafety.updateRoadTemperature(-3.1597835149418285E307);  
//        roadSafety.updateRoadTemperature(-1.7836486570745169E308);  
//        roadSafety.updateRoadTemperature(-4.9E-324);  
//        roadSafety.updateRoadTemperature(3.6603310227959246E298);
        
        // testcase-Z3:
//        roadSafety.updateRoadTemperature(-4.0);  
//        roadSafety.updateRoadTemperature(3.0);  
//        roadSafety.updateRoadTemperature(4.0);  
//        roadSafety.updateRoadTemperature(-7.0);
        
        // testcase-UVT:
        roadSafety.updateRoadTemperature(-4.0);  
        roadSafety.updateRoadTemperature(3.0);  
        roadSafety.updateRoadTemperature(4.0);  
        roadSafety.updateRoadTemperature(-7.0);
    }
}

