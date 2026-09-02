package code;

public class c82_SmartFertilizerDispenser {

    private double minNutrientLevel;   
    private double maxNutrientLevel;   
    private double currentNutrientLevel; 
    private boolean dispensingActive;  

    public c82_SmartFertilizerDispenser(double minNutrientLevel, double maxNutrientLevel, double initialNutrientLevel) {
        this.minNutrientLevel = minNutrientLevel;
        this.maxNutrientLevel = maxNutrientLevel;
        this.currentNutrientLevel = initialNutrientLevel;
        this.dispensingActive = false;
    }

    public void updateNutrientLevel(double newNutrientLevel) {
        currentNutrientLevel = newNutrientLevel;
        adjustFertilizerDispensing();
        System.out.printf("Current Nutrient Level: %.2f%%, Fertilizer Dispensing: %s%n",
                          currentNutrientLevel,
                          dispensingActive ? "ON" : "OFF");

        if (dispensingActive) {
            System.out.println("ALERT: Low nutrient level detected. Activating fertilizer dispenser.");
        } else if (currentNutrientLevel > maxNutrientLevel) {
            System.out.println("INFO: Nutrient level is high. Fertilizer dispensing is deactivated.");
        } else {
            System.out.println("Nutrient level is optimal. No action needed.");
        }
    }

    private void adjustFertilizerDispensing() {
        if (currentNutrientLevel < minNutrientLevel) {
            dispensingActive = true;
        } else if (currentNutrientLevel > maxNutrientLevel) {
            dispensingActive = false;
        } else {
            dispensingActive = false;
        }
    }

    public double getCurrentNutrientLevel() {
        return currentNutrientLevel;
    }
    
    public boolean isDispensingActive() {
        return dispensingActive;
    }
    
    public static void main(String[] args) {
    	c82_SmartFertilizerDispenser dispenser = new c82_SmartFertilizerDispenser(40.0, 70.0, 55.0);
        
        // testcase-VT:
//        dispenser.updateNutrientLevel(35.0);  
//        dispenser.updateNutrientLevel(65.0);  
//        dispenser.updateNutrientLevel(75.0);
        
        // testcase-FT:
//        dispenser.updateNutrientLevel(0.0);  
//        dispenser.updateNutrientLevel(1.7976931348623157E308);  
//        dispenser.updateNutrientLevel(-5.005342255597914E307);
        
        // testcase-Z3:
//        dispenser.updateNutrientLevel(35.0);  
//        dispenser.updateNutrientLevel(65.0);  
//        dispenser.updateNutrientLevel(75.0);
        
        // testcase-UVT:
        dispenser.updateNutrientLevel(35.0);  
        dispenser.updateNutrientLevel(65.0);  
        dispenser.updateNutrientLevel(75.0);
    }
}
