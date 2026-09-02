package code;

public class c106_SmartTireTreadMonitor {

    private double minTreadDepth;  
    private double currentTreadDepth; 

    public c106_SmartTireTreadMonitor(double minTreadDepth, double initialTreadDepth) {
        this.minTreadDepth = minTreadDepth;
        this.currentTreadDepth = initialTreadDepth;
    }

    public void updateTreadDepth(double newTreadDepth) {
        currentTreadDepth = newTreadDepth;
        System.out.printf("Current Tire Tread Depth: %.2f mm%n", currentTreadDepth);
        if (currentTreadDepth < minTreadDepth) {
            System.out.println("ALERT: Tire tread depth too low! Tire replacement required.");
        } else {
            System.out.println("Tire tread depth is within safe limits.");
        }
    }

    public double getCurrentTreadDepth() {
        return currentTreadDepth;
    }

    public static void main(String[] args) {
    	c106_SmartTireTreadMonitor monitor = new c106_SmartTireTreadMonitor(3.0, 4.5);

        // testcase-VT:
//        monitor.updateTreadDepth(4.0); 
//        monitor.updateTreadDepth(2.5); 
//        monitor.updateTreadDepth(3.5);  
        
        // testcase-FT:
//        monitor.updateTreadDepth(-4.864346129627444E307); 
//        monitor.updateTreadDepth(0.0); 
//        monitor.updateTreadDepth(-1.7976931348623131E308);  
    	
        // testcase-Z3:
//        monitor.updateTreadDepth(4.0); 
//        monitor.updateTreadDepth(2.5); 
//        monitor.updateTreadDepth(3.5);  
        
        // testcase-UVT:
        monitor.updateTreadDepth(4.0); 
        monitor.updateTreadDepth(2.5); 
        monitor.updateTreadDepth(3.5);  
    }
}
