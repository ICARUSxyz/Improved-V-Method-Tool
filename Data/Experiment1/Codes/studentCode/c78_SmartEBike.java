package code;

public class c78_SmartEBike {

    private double currentSpeed;      
    private double assistancePower;   
    private double targetSpeed;      
    
    public c78_SmartEBike(double initialSpeed, double initialAssistance, double targetSpeed) {
        this.currentSpeed = initialSpeed;
        this.assistancePower = initialAssistance;
        this.targetSpeed = targetSpeed;
    }
    
    public void updateSpeed(double changeAmount) {
        currentSpeed += changeAmount;
        adjustAssistance();
        System.out.printf("Current Speed: %.2f km/h, Assistance Power: %.2f W%n", currentSpeed, assistancePower);
        if (currentSpeed < targetSpeed) {
            System.out.println("ALERT: Speed below target! Increasing motor assistance.");
        } else if (currentSpeed > targetSpeed) {
            System.out.println("ALERT: Speed above target! Decreasing motor assistance.");
        } else {
            System.out.println("Speed is optimal. Motor assistance remains unchanged.");
        }
    }
    
    private void adjustAssistance() {
        if (currentSpeed < targetSpeed) {
            assistancePower = assistancePower * 1.2;
        }
        else if (currentSpeed > targetSpeed) {
            assistancePower = assistancePower * 0.8;
        }
    }
    
    public double getAssistancePower() {
        return assistancePower;
    }
    
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    public static void main(String[] args) {
    	c78_SmartEBike bike = new c78_SmartEBike(15.0, 200.0, 20.0);
        
        // testcase-VT:
//        bike.updateSpeed(3.0);   
//        bike.updateSpeed(5.0);   
//        bike.updateSpeed(-3.0); 
        
        // testcase-FT:
//        bike.updateSpeed(4.580297585357999E290);   
//        bike.updateSpeed(-1.7976931348623157E308);   
//        bike.updateSpeed(1.7976931348623157E308); 
    	
        // testcase-Z3:
//        bike.updateSpeed(3.0);   
//        bike.updateSpeed(5.0);   
//        bike.updateSpeed(-3.0);
        
        // testcase-UVT:
        bike.updateSpeed(3.0);   
        bike.updateSpeed(5.0);   
        bike.updateSpeed(-3.0);
    }
}
