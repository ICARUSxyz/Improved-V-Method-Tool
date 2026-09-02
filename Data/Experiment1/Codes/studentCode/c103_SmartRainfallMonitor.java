package code;

public class c103_SmartRainfallMonitor {

    private double rainfallThreshold;  
    private double currentRainfall;   

    public c103_SmartRainfallMonitor(double rainfallThreshold, double initialRainfall) {
        this.rainfallThreshold = rainfallThreshold;
        this.currentRainfall = initialRainfall;
    }

    public void updateRainfall(double newRainfall) {
        currentRainfall = newRainfall;
        System.out.printf("Current Rainfall Intensity: %.2f mm/h%n", currentRainfall);
        if (currentRainfall > rainfallThreshold) {
            System.out.println("ALERT: Heavy rain detected! Please take precautionary measures.");
        } else {
            System.out.println("Rainfall intensity is normal.");
        }
    }

    public double getCurrentRainfall() {
        return currentRainfall;
    }

    public static void main(String[] args) {
    	c103_SmartRainfallMonitor monitor = new c103_SmartRainfallMonitor(20.0, 10.0);

        // testcase-VT:
//        monitor.updateRainfall(15.0);  
//        monitor.updateRainfall(25.0);  
//        monitor.updateRainfall(18.0); 
        
        // testcase-FT:
//        monitor.updateRainfall(2.743040779495874E303);  
//        monitor.updateRainfall(1.071500304489605E301);  
//        monitor.updateRainfall(-1.7976931348623157E308); 
    	
        // testcase-Z3:
//        monitor.updateRainfall(15.0);  
//        monitor.updateRainfall(25.0);  
//        monitor.updateRainfall(18.0); 
        
        // testcase-UVT:
        monitor.updateRainfall(15.0);  
        monitor.updateRainfall(25.0);  
        monitor.updateRainfall(18.0); 
    }
}
