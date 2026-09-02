package code;

public class c101_SmartVibrationMonitor {

    private double maxVibrationThreshold; 
    private double currentVibration;         

    public c101_SmartVibrationMonitor(double maxVibrationThreshold, double initialVibration) {
        this.maxVibrationThreshold = maxVibrationThreshold;
        this.currentVibration = initialVibration;
    }

    public void updateVibration(double newVibration) {
        currentVibration = newVibration;
        System.out.printf("Current Vibration: %.2f mm/s%n", currentVibration);
        if (currentVibration > maxVibrationThreshold) {
            System.out.println("ALERT: Vibration level too high! Maintenance required.");
        } else {
            System.out.println("Vibration level is within safe limits.");
        }
    }

    public double getCurrentVibration() {
        return currentVibration;
    }

    public static void main(String[] args) {
    	c101_SmartVibrationMonitor monitor = new c101_SmartVibrationMonitor(20.0, 15.0);

        // testcase-VT:
//        monitor.updateVibration(18.0); 
//        monitor.updateVibration(22.5); 
//        monitor.updateVibration(19.0); 
        
        // testcase-FT:
//        monitor.updateVibration(9.063142030601998E290); 
//        monitor.updateVibration(2.3292275018647134E293); 
//        monitor.updateVibration(6.7769769832148005E302); 
    	
        // testcase-Z3:
//        monitor.updateVibration(18.0); 
//        monitor.updateVibration(22.5); 
//        monitor.updateVibration(19.0); 
        
        // testcase-UVT:
        monitor.updateVibration(18.0); 
        monitor.updateVibration(22.5); 
        monitor.updateVibration(19.0); 
    }
}
