package code;

public class c85_SmartHeartRateMonitor {

    private double minHeartRate;    
    private double maxHeartRate;     
    private double currentHeartRate;  

    public c85_SmartHeartRateMonitor(double minHeartRate, double maxHeartRate, double initialHeartRate) {
        this.minHeartRate = minHeartRate;
        this.maxHeartRate = maxHeartRate;
        this.currentHeartRate = initialHeartRate;
    }

    public void updateHeartRate(double newHeartRate) {
        currentHeartRate = newHeartRate;
        System.out.printf("Current Heart Rate: %.2f BPM%n", currentHeartRate);
        if (currentHeartRate < minHeartRate) {
            System.out.println("ALERT: Heart rate is too low! Consider slowing down or stopping exercise.");
        } else if (currentHeartRate > maxHeartRate) {
            System.out.println("ALERT: Heart rate is too high! Please reduce exercise intensity.");
        } else {
            System.out.println("Heart rate is within the optimal range.");
        }
    }

    public double getCurrentHeartRate() {
        return currentHeartRate;
    }

    public static void main(String[] args) {
    	c85_SmartHeartRateMonitor monitor = new c85_SmartHeartRateMonitor(50.0, 160.0, 70.0);
        
        // testcase-VT:
//        monitor.updateHeartRate(45.0);   
//        monitor.updateHeartRate(75.0);   
//        monitor.updateHeartRate(170.0);  

        // testcase-FT:
//        monitor.updateHeartRate(1.6349678233795336E296);   
//        monitor.updateHeartRate(1.7976931348623157E308);   
//        monitor.updateHeartRate(-1.7976931348623157E308);  
    	
        // testcase-Z3:
//        monitor.updateHeartRate(45.0);   
//        monitor.updateHeartRate(75.0);   
//        monitor.updateHeartRate(170.0);  
        
        // testcase-UVT:
        monitor.updateHeartRate(45.0);   
        monitor.updateHeartRate(75.0);   
        monitor.updateHeartRate(170.0);  

    }
}
