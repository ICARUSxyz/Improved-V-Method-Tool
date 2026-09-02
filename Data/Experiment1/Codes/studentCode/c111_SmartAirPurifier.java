package code;

public class c111_SmartAirPurifier {

    private double normalAQIThreshold;  
    private double hazardousAQIThreshold; 
    private double currentAQI;        
    private int fanSpeed;              

    public c111_SmartAirPurifier(double normalAQIThreshold, double hazardousAQIThreshold, double initialAQI) {
        this.normalAQIThreshold = normalAQIThreshold;
        this.hazardousAQIThreshold = hazardousAQIThreshold;
        this.currentAQI = initialAQI;
        this.fanSpeed = 1;
    }

    public void updateAQI(double newAQI) {
        currentAQI = newAQI;
        adjustFanSpeed();
        System.out.printf("Current AQI: %.2f, Fan Speed: %d%n", currentAQI, fanSpeed);
        if (currentAQI >= hazardousAQIThreshold) {
            System.out.println("ALERT: Hazardous air quality detected! Take protective measures.");
        } else if (currentAQI > normalAQIThreshold) {
            System.out.println("WARNING: Poor air quality. Increasing fan speed.");
        } else {
            System.out.println("Air quality is good. Operating at normal speed.");
        }
    }

    private void adjustFanSpeed() {
        if (currentAQI >= hazardousAQIThreshold) {
            fanSpeed = 2; 
        } else if (currentAQI > normalAQIThreshold) {
            fanSpeed = 2; 
        } else {
            fanSpeed = 1;
        }
    }

    public double getCurrentAQI() {
        return currentAQI;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public static void main(String[] args) {
    	c111_SmartAirPurifier purifier = new c111_SmartAirPurifier(100.0, 200.0, 80.0);

        // testcase-VT:
//        purifier.updateAQI(90.0);  
//        purifier.updateAQI(150.0);  
//        purifier.updateAQI(220.0);  
        
        // testcase-FT:
//        purifier.updateAQI(5.639821599568049E306);  
//        purifier.updateAQI(0.0);  
//        purifier.updateAQI(-1.7976931348623157E308);  
    	
        // testcase-Z3:
//        purifier.updateAQI(90.0);  
//        purifier.updateAQI(150.0);  
//        purifier.updateAQI(220.0);  
        
        // testcase-UVT:
        purifier.updateAQI(90.0);  
        purifier.updateAQI(150.0);  
        purifier.updateAQI(220.0);  
    }
}
