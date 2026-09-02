package code;

public class c89_SmartEVRegenerativeBraking {

    private double currentSpeed;    
    private double decelerationRate; 
    private double recoveredEnergy; 
    private double regenThreshold;   
    private double efficiencyFactor;  

    public c89_SmartEVRegenerativeBraking(double initialSpeed, double regenThreshold, double efficiencyFactor) {
        this.currentSpeed = initialSpeed;
        this.decelerationRate = 0.0;
        this.recoveredEnergy = 0.0;
        this.regenThreshold = regenThreshold;
        this.efficiencyFactor = efficiencyFactor;
    }

    public void updateDeceleration(double newDecelerationRate) {
        decelerationRate = newDecelerationRate;
        if (decelerationRate >= regenThreshold) {
            recoveredEnergy = currentSpeed * decelerationRate * efficiencyFactor;
            System.out.printf("Deceleration Rate: %.2f km/h/s exceeds threshold %.2f km/h/s.%n", decelerationRate, regenThreshold);
            System.out.printf("Recovered Energy: %.4f kWh%n", recoveredEnergy);
            System.out.println("Regenerative braking activated.");
        } else {
            recoveredEnergy = 0.0;
            System.out.printf("Deceleration Rate: %.2f km/h/s below threshold %.2f km/h/s.%n", decelerationRate, regenThreshold);
            System.out.println("No regenerative braking.");
        }
    }

    public void updateSpeed(double newSpeed) {
        currentSpeed = newSpeed;
        System.out.printf("Current Speed updated to: %.2f km/h%n", currentSpeed);
    }

    public double getRecoveredEnergy() {
        return recoveredEnergy;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    public static void main(String[] args) {
    	c89_SmartEVRegenerativeBraking evRegen = new c89_SmartEVRegenerativeBraking(80.0, 10.0, 0.0005);
       
        // testcase-VT:
//        evRegen.updateSpeed(80.0);                 
//        evRegen.updateDeceleration(8.0);            
//        evRegen.updateDeceleration(12.0);           
//        evRegen.updateSpeed(60.0);                 
//        evRegen.updateDeceleration(15.0); 
        
        // testcase-FT:
//        evRegen.updateDeceleration(2.1537143965193995E291);                 
//        evRegen.updateSpeed(-1.7976931348623157E308);            
//        evRegen.updateSpeed(2.3238675791584434E29);           
//        evRegen.updateSpeed(7.402265849433064E307);                 
//        evRegen.updateDeceleration(5.992310449541052E307); 

        // testcase-Z3:
//        evRegen.updateSpeed(80.0);                 
//        evRegen.updateDeceleration(8.0);            
//        evRegen.updateDeceleration(12.0);           
//        evRegen.updateSpeed(60.0);                 
//        evRegen.updateDeceleration(15.0); 
        
        // testcase-UVT:
        evRegen.updateSpeed(80.0);                 
        evRegen.updateDeceleration(8.0);            
        evRegen.updateDeceleration(12.0);           
        evRegen.updateSpeed(60.0);                 
        evRegen.updateDeceleration(15.0); 
    }
}
