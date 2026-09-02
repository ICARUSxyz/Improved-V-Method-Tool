package code;

public class c100_SmartGasStove {

    private double minFlameIntensity;  
    private double maxFlameIntensity; 
    private double currentFlameIntensity;  
    private double gasFlowRate; 

    public c100_SmartGasStove(double minFlameIntensity, double maxFlameIntensity, double initialFlameIntensity, double initialGasFlowRate) {
        this.minFlameIntensity = minFlameIntensity;
        this.maxFlameIntensity = maxFlameIntensity;
        this.currentFlameIntensity = initialFlameIntensity;
        this.gasFlowRate = initialGasFlowRate;
    }

    public void updateFlameIntensity(double newFlameIntensity) {
        currentFlameIntensity = newFlameIntensity;
        adjustGasFlow();
        System.out.printf("Current Flame Intensity: %.2f, Gas Flow Rate: %.2f L/min%n",
                          currentFlameIntensity, gasFlowRate);

        if (currentFlameIntensity < minFlameIntensity) {
            System.out.println("ALERT: Flame intensity too low! Increasing gas flow.");
        } else if (currentFlameIntensity > maxFlameIntensity) {
            System.out.println("ALERT: Flame intensity too high! Decreasing gas flow.");
        } else {
            System.out.println("Flame intensity is optimal. No adjustment needed.");
        }
    }

    private void adjustGasFlow() {
        if (currentFlameIntensity < minFlameIntensity) {
            gasFlowRate = gasFlowRate * 1.2;
        } else if (currentFlameIntensity > maxFlameIntensity) {
            gasFlowRate = gasFlowRate * 0.8;
        }
    }

    public double getCurrentFlameIntensity() {
        return currentFlameIntensity;
    }

    public double getGasFlowRate() {
        return gasFlowRate;
    }

    public static void main(String[] args) {
    	c100_SmartGasStove stove = new c100_SmartGasStove(50.0, 80.0, 70.0, 1.0);
        
        // testcase-VT:
//        stove.updateFlameIntensity(45.0); 
//        stove.updateFlameIntensity(85.0); 
//        stove.updateFlameIntensity(65.0);  
        
        // testcase-FT:
//        stove.updateFlameIntensity(-1.7976931348623157E308); 
//        stove.updateFlameIntensity(0.0); 
//        stove.updateFlameIntensity(-4.9E-324); 
    	
        // testcase-Z3:
//        stove.updateFlameIntensity(45.0); 
//        stove.updateFlameIntensity(85.0); 
//        stove.updateFlameIntensity(65.0);  
        
        // testcase-UVT:
        stove.updateFlameIntensity(45.0); 
        stove.updateFlameIntensity(85.0); 
        stove.updateFlameIntensity(65.0);  
    }
}
