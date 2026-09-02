package code;

public class c92_SmartWaterPressureSystem {

    private double minPressure;      
    private double maxPressure;      
    private double currentPressure; 
    private boolean pumpActive;     
    private boolean releaseValveActive;

    public c92_SmartWaterPressureSystem(double minPressure, double maxPressure, double initialPressure) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.currentPressure = initialPressure;
        this.pumpActive = false;
        this.releaseValveActive = false;
    }

    public void updatePressure(double newPressure) {
        currentPressure = newPressure;
        adjustPressureControl();
        System.out.printf("Current Water Pressure: %.2f bar%n", currentPressure);
        if (pumpActive) {
            System.out.println("ALERT: Low pressure detected. Activating water pump.");
        } else if (releaseValveActive) {
            System.out.println("ALERT: High pressure detected. Activating pressure release valve.");
        } else {
            System.out.println("Water pressure is optimal. No action required.");
        }
    }

    private void adjustPressureControl() {
        if (currentPressure < minPressure) {
            pumpActive = true;
            releaseValveActive = false;
        } else if (currentPressure > maxPressure) {
            pumpActive = false;
            releaseValveActive = true;
        } else {
            pumpActive = false;
            releaseValveActive = false;
        }
    }

    public double getCurrentPressure() {
        return currentPressure;
    }

    public boolean isPumpActive() {
        return pumpActive;
    }

    public boolean isReleaseValveActive() {
        return releaseValveActive;
    }

    public static void main(String[] args) {
    	c92_SmartWaterPressureSystem waterSystem = new c92_SmartWaterPressureSystem(2.0, 6.0, 4.0);
        
        // testcase-VT:
//        waterSystem.updatePressure(1.5);  
//        waterSystem.updatePressure(4.5);  
//        waterSystem.updatePressure(6.5); 
        
        // testcase-FT:
//        waterSystem.updatePressure(1.7976931348623157E308);  
//        waterSystem.updatePressure(-1.7976931348623157E308);  
//        waterSystem.updatePressure(0.0); 
    	
        // testcase-Z3:
//        waterSystem.updatePressure(1.5);  
//        waterSystem.updatePressure(4.5);  
//        waterSystem.updatePressure(6.5); 
        
        // testcase-UVT:
        waterSystem.updatePressure(1.5);  
        waterSystem.updatePressure(4.5);  
        waterSystem.updatePressure(6.5); 
    }
}
