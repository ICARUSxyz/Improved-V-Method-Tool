package code;

class SmartTire69 {
    private double minPressure; 
    private double maxPressure; 
    private double currentPressure; 

    public SmartTire69(double minPressure, double maxPressure, double initialPressure) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.currentPressure = initialPressure;
    }

    public void updatePressure(double changeAmount) {
        currentPressure += changeAmount;
        System.out.printf("Current Tire Pressure: %.2f psi\n", currentPressure);
        if (currentPressure < minPressure) {
            System.out.println("ALERT: Low Tire Pressure!");
        } else if (currentPressure > maxPressure) {
            System.out.println("ALERT: High Tire Pressure!");
        } else {
            System.out.println("Tire Pressure is Optimal.");
        }
    }
}

public class c69_SmartTireSystem {
    public static void main(String[] args) {
        SmartTire69 tire = new SmartTire69(30.0, 35.0, 33.0);
        
        // testcase-VT:
//        tire.updatePressure(-5.0);  
//        tire.updatePressure(8.0);  
//        tire.updatePressure(-2.0);
        
        // testcase-FT:
//        tire.updatePressure(8.812221249325049E307);  
//        tire.updatePressure(7.986142550757732E295);  
//        tire.updatePressure(3.4300223128453513E305);
        
        // testcase-Z3:
//        tire.updatePressure(-5.0);  
//        tire.updatePressure(8.0);  
//        tire.updatePressure(-2.0);
        
        // testcase-UVT:
        tire.updatePressure(-5.0);  
        tire.updatePressure(8.0);  
        tire.updatePressure(-2.0);
    }
}