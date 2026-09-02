package code;

public class c104_SmartNoiseMonitor {

    private double noiseThreshold;   
    private double currentNoise;     

    public c104_SmartNoiseMonitor(double noiseThreshold, double initialNoise) {
        this.noiseThreshold = noiseThreshold;
        this.currentNoise = initialNoise;
    }

    public void updateNoise(double newNoise) {
        currentNoise = newNoise;
        System.out.printf("Current Noise Level: %.2f dB%n", currentNoise);
        if (currentNoise > noiseThreshold) {
            System.out.println("ALERT: Noise level too high! Intervention required.");
        } else {
            System.out.println("Noise level is within safe limits.");
        }
    }

    public double getCurrentNoise() {
        return currentNoise;
    }

    public static void main(String[] args) {
    	c104_SmartNoiseMonitor monitor = new c104_SmartNoiseMonitor(85.0, 70.0);

        // testcase-VT:
//        monitor.updateNoise(75.0); 
//        monitor.updateNoise(90.0);  
//        monitor.updateNoise(80.0); 
        
        // testcase-FT:
//        monitor.updateNoise(-1.7976931348623157E308); 
//        monitor.updateNoise(-1.0715086069367872E301);  
//        monitor.updateNoise(-2.4850550729069995E291); 
    	
        // testcase-Z3:
//        monitor.updateNoise(75.0); 
//        monitor.updateNoise(90.0);  
//        monitor.updateNoise(80.0); 
        
        // testcase-UVT:
        monitor.updateNoise(75.0); 
        monitor.updateNoise(90.0);  
        monitor.updateNoise(80.0); 
    }
}
