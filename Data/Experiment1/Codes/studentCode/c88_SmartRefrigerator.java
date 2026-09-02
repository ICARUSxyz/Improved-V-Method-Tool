package code;

public class c88_SmartRefrigerator {

    private double defrostThreshold;      
    private double currentFrostThickness; 
    private boolean defrostCycleActive;   

    public c88_SmartRefrigerator(double defrostThreshold, double initialFrostThickness) {
        this.defrostThreshold = defrostThreshold;
        this.currentFrostThickness = initialFrostThickness;
        this.defrostCycleActive = false;
    }

    public void updateFrostThickness(double newFrostThickness) {
        currentFrostThickness = newFrostThickness;
        adjustDefrostCycle();
        System.out.printf("Current Frost Thickness: %.2f mm, Defrost Cycle: %s%n",
                currentFrostThickness, defrostCycleActive ? "ACTIVE" : "INACTIVE");
        if (defrostCycleActive) {
            System.out.println("ALERT: Frost thickness exceeds threshold. Defrost cycle activated.");
        } else {
            System.out.println("Frost thickness is within acceptable limits. No defrost needed.");
        }
    }

    private void adjustDefrostCycle() {
        if (currentFrostThickness > defrostThreshold) {
            defrostCycleActive = true;
        } else {
            defrostCycleActive = false;
        }
    }

    public double getCurrentFrostThickness() {
        return currentFrostThickness;
    }

    public boolean isDefrostCycleActive() {
        return defrostCycleActive;
    }

    public static void main(String[] args) {
    	c88_SmartRefrigerator fridge = new c88_SmartRefrigerator(5.0, 3.0);

        // testcase-VT:
//        fridge.updateFrostThickness(4.0);  
//        fridge.updateFrostThickness(6.5);   
//        fridge.updateFrostThickness(5.0); 
        
        // testcase-FT:
//        fridge.updateFrostThickness(-1.7976931344437577E308);  
//        fridge.updateFrostThickness(-2.2250738585072014E-308);   
//        fridge.updateFrostThickness(1.3834084758073603E308); 
        
        // testcase-Z3:
//        fridge.updateFrostThickness(4.0);  
//        fridge.updateFrostThickness(6.5);   
//        fridge.updateFrostThickness(5.0); 
        
        // testcase-UVT:
        fridge.updateFrostThickness(4.0);  
        fridge.updateFrostThickness(6.5);   
        fridge.updateFrostThickness(5.0); 
    }
}
