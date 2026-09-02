package code;

public class c84_SmartWaterPurifier {

    private double maxTDSThreshold;  
    private double minTDSThreshold;  
    private double currentTDS;        
    private boolean filterCleaningActive; 

    public c84_SmartWaterPurifier(double minTDSThreshold, double maxTDSThreshold, double initialTDS) {
        this.minTDSThreshold = minTDSThreshold;
        this.maxTDSThreshold = maxTDSThreshold;
        this.currentTDS = initialTDS;
        this.filterCleaningActive = false;
    }

    public void updateTDS(double newTDS) {
        currentTDS = newTDS;
        adjustFilterActivation();
        System.out.printf("Current TDS: %.2f ppm, Filter Cleaning: %s%n", 
                          currentTDS, filterCleaningActive ? "ACTIVE" : "INACTIVE");
        if (filterCleaningActive) {
            System.out.println("ALERT: TDS level high! Initiating filter cleaning cycle.");
        } else {
            System.out.println("TDS level is within acceptable limits. No action required.");
        }
    }

    private void adjustFilterActivation() {
        if (currentTDS > maxTDSThreshold) {
            filterCleaningActive = true;
        } else if (currentTDS < minTDSThreshold) {
            filterCleaningActive = false;
        } else {
            filterCleaningActive = false;
        }
    }

    public double getCurrentTDS() {
        return currentTDS;
    }

    public boolean isFilterCleaningActive() {
        return filterCleaningActive;
    }

    public static void main(String[] args) {
    	c84_SmartWaterPurifier purifier = new c84_SmartWaterPurifier(200.0, 400.0, 300.0);

        // testcase-VT:
//        purifier.updateTDS(350.0); 
//        purifier.updateTDS(450.0);  
//        purifier.updateTDS(180.0);  
        
        // testcase-FT:
//        purifier.updateTDS(1.7976931348623157E308); 
//        purifier.updateTDS(-1.7976931348623157E308);  
//        purifier.updateTDS(0.0); 
        
        // testcase-Z3:
//        purifier.updateTDS(350.0); 
//        purifier.updateTDS(450.0);  
//        purifier.updateTDS(180.0);  
        
        // testcase-UVT:
        purifier.updateTDS(350.0); 
        purifier.updateTDS(450.0);  
        purifier.updateTDS(180.0);  
    }
}
