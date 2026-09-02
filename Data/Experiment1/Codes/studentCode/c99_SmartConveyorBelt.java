package code;

public class c99_SmartConveyorBelt {

    private double loadThreshold;      
    private double optimalSpeed;      
    private double currentLoad;        
    private double currentSpeed;       

    public c99_SmartConveyorBelt(double loadThreshold, double optimalSpeed) {
        this.loadThreshold = loadThreshold;
        this.optimalSpeed = optimalSpeed;
        this.currentLoad = 0.0;
        this.currentSpeed = optimalSpeed;
    }

    public void updateLoad(double newLoad) {
        currentLoad = newLoad;
        adjustBeltSpeed();
        System.out.printf("Current Load: %.2f kg, Conveyor Belt Speed: %.2f m/s%n",
                          currentLoad, currentSpeed);
        if (currentLoad > loadThreshold) {
            System.out.println("ALERT: Load exceeds threshold. Conveyor belt speed reduced.");
        } else {
            System.out.println("Load is within safe limits. Conveyor belt operating at optimal speed.");
        }
    }

    private void adjustBeltSpeed() {
        if (currentLoad > loadThreshold) {
            currentSpeed = optimalSpeed * 0.8; 
        } else {
            currentSpeed = optimalSpeed;      
        }
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public static void main(String[] args) {
    	c99_SmartConveyorBelt belt = new c99_SmartConveyorBelt(100.0, 2.0);

        // testcase-VT:
//        belt.updateLoad(80.0);   
//        belt.updateLoad(120.0); 
//        belt.updateLoad(95.0);   
        
        // testcase-FT:
//        belt.updateLoad(-1.2007939425236886E308);   
//        belt.updateLoad(-1.1867492506025853E308); 
//        belt.updateLoad(-1.7836486571938841E308);   
    	
        // testcase-Z3:
//        belt.updateLoad(80.0);   
//        belt.updateLoad(120.0); 
//        belt.updateLoad(95.0);   
        
        // testcase-uVT:
        belt.updateLoad(80.0);   
        belt.updateLoad(120.0); 
        belt.updateLoad(95.0);   
    }
}
