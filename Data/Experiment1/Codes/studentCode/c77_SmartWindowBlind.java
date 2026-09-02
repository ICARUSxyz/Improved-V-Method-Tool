package code;

public class c77_SmartWindowBlind {

    private double highBrightnessThreshold; 
    private double lowBrightnessThreshold; 
    private double currentBrightness;      
    private double blindAngle;             

    public c77_SmartWindowBlind(double highThreshold, double lowThreshold, double initialBrightness, double initialAngle) {
        this.highBrightnessThreshold = highThreshold;
        this.lowBrightnessThreshold = lowThreshold;
        this.currentBrightness = initialBrightness;
        this.blindAngle = initialAngle;
    }

    public void updateBrightness(double newBrightness) {
        currentBrightness = newBrightness;
        adjustBlindAngle();
        System.out.printf("Current Brightness: %.2f lux, Blind Angle: %.2f°%n", currentBrightness, blindAngle);
        if (currentBrightness > highBrightnessThreshold) {
            System.out.println("ALERT: High brightness detected. Blinds lowered to reduce sunlight.");
        } else if (currentBrightness < lowBrightnessThreshold) {
            System.out.println("ALERT: Low brightness detected. Blinds raised to allow more light.");
        } else {
            System.out.println("Brightness is optimal. Blinds maintained at intermediate angle.");
        }
    }

    private void adjustBlindAngle() {
        if (currentBrightness > highBrightnessThreshold) {
            blindAngle = 80.0; 
        } else if (currentBrightness < lowBrightnessThreshold) {
            blindAngle = 20.0; 
        } else {
            blindAngle = 50.0; 
        }
    }
    
    public double getBlindAngle() {
        return blindAngle;
    }
    
    public double getCurrentBrightness() {
        return currentBrightness;
    }
    
    public static void main(String[] args) {
    	c77_SmartWindowBlind blindSystem = new c77_SmartWindowBlind(800.0, 300.0, 500.0, 50.0);
        
        // testcase-VT:
//        blindSystem.updateBrightness(900.0);  
//        blindSystem.updateBrightness(250.0); 
//        blindSystem.updateBrightness(600.0);  
        
        // testcase-FT:
//        blindSystem.updateBrightness(3.832023139620673E294);  
//        blindSystem.updateBrightness(-1.7976931348623157E308); 
//        blindSystem.updateBrightness(1.6309011038425763E296);  
    	
        // testcase-Z3:
//        blindSystem.updateBrightness(900.0);  
//        blindSystem.updateBrightness(250.0); 
//        blindSystem.updateBrightness(600.0); 
        
        // testcase-UVT:
        blindSystem.updateBrightness(900.0);  
        blindSystem.updateBrightness(250.0); 
        blindSystem.updateBrightness(600.0); 
    }
}
