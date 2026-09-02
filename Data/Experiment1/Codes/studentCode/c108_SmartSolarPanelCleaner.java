package code;

public class c108_SmartSolarPanelCleaner {

    private double dustThreshold;       
    private double currentDustLevel;   
    private boolean cleaningCycleActive; 

    public c108_SmartSolarPanelCleaner(double dustThreshold, double initialDustLevel) {
        this.dustThreshold = dustThreshold;
        this.currentDustLevel = initialDustLevel;
        this.cleaningCycleActive = false;
    }

    public void updateDustLevel(double newDustLevel) {
        currentDustLevel = newDustLevel;
        adjustCleaningCycle();
        System.out.printf("Current Dust Level: %.2f%%%n", currentDustLevel);
        if (cleaningCycleActive) {
            System.out.println("ALERT: Dust level too high! Cleaning cycle activated.");
        } else {
            System.out.println("Dust level is within acceptable limits. No cleaning required.");
        }
    }

    private void adjustCleaningCycle() {
        if (currentDustLevel > dustThreshold) {
            cleaningCycleActive = true;
        } else {
            cleaningCycleActive = false;
        }
    }

    public double getCurrentDustLevel() {
        return currentDustLevel;
    }

    public boolean isCleaningCycleActive() {
        return cleaningCycleActive;
    }

    public static void main(String[] args) {
    	c108_SmartSolarPanelCleaner cleaner = new c108_SmartSolarPanelCleaner(50.0, 40.0);

        // testcase-VT:
//        cleaner.updateDustLevel(45.0);  
//        cleaner.updateDustLevel(55.0);  
//        cleaner.updateDustLevel(48.0);  
        
        // testcase-FT:
//        cleaner.updateDustLevel(1.2251194114176424E303);  
//        cleaner.updateDustLevel(-1.7976931348623157E308);  
//        cleaner.updateDustLevel(-1.515702054883285E308);  
    	
        // testcase-Z3:
//        cleaner.updateDustLevel(45.0);  
//        cleaner.updateDustLevel(55.0);  
//        cleaner.updateDustLevel(48.0);  
        
        // testcase-UVT:
        cleaner.updateDustLevel(45.0);  
        cleaner.updateDustLevel(55.0);  
        cleaner.updateDustLevel(48.0);  
    }
}
