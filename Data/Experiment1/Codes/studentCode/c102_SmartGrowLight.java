package code;

public class c102_SmartGrowLight {

    private double minOptimalIntensity; 
    private double maxOptimalIntensity; 
    private double currentIntensity;    
    private double brightness;          

    public c102_SmartGrowLight(double minOptimalIntensity, double maxOptimalIntensity, double initialIntensity, double initialBrightness) {
        this.minOptimalIntensity = minOptimalIntensity;
        this.maxOptimalIntensity = maxOptimalIntensity;
        this.currentIntensity = initialIntensity;
        this.brightness = initialBrightness;
    }

    public void updateIntensity(double newIntensity) {
        currentIntensity = newIntensity;
        adjustBrightness();
        System.out.printf("Current Light Intensity: %.2f lumens, Brightness: %.2f%%%n", currentIntensity, brightness);
        if (currentIntensity < minOptimalIntensity) {
            System.out.println("ALERT: Light intensity too low. Increasing brightness.");
        } else if (currentIntensity > maxOptimalIntensity) {
            System.out.println("ALERT: Light intensity too high. Decreasing brightness.");
        } else {
            System.out.println("Light intensity is optimal. Maintaining current brightness.");
        }
    }

    private void adjustBrightness() {
        if (currentIntensity < minOptimalIntensity) {
            brightness = 100.0;
        } else if (currentIntensity > maxOptimalIntensity) {
            brightness = 50.0;
        } else {
            brightness = 75.0;
        }
    }

    public double getCurrentIntensity() {
        return currentIntensity;
    }

    public double getBrightness() {
        return brightness;
    }

    public static void main(String[] args) {
    	c102_SmartGrowLight growLight = new c102_SmartGrowLight(400.0, 800.0, 600.0, 75.0);
        
        // testcase-VT:
//        growLight.updateIntensity(350.0); 
//        growLight.updateIntensity(750.0);  
//        growLight.updateIntensity(850.0);  
        
        // testcase-FT:
//        growLight.updateIntensity(9.063142030601998E290); 
//        growLight.updateIntensity(2.3292275018647134E293);  
//        growLight.updateIntensity(6.7769769832148005E302);  
        
        // testcase-Z3:
//        growLight.updateIntensity(350.0); 
//        growLight.updateIntensity(750.0);  
//        growLight.updateIntensity(850.0);  
        
        // testcase-UVT:
        growLight.updateIntensity(350.0); 
        growLight.updateIntensity(750.0);  
        growLight.updateIntensity(850.0);  
    }
}
