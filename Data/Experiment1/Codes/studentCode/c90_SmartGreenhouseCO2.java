package code;

public class c90_SmartGreenhouseCO2 {

    private double minCO2;          
    private double maxCO2;        
    private double currentCO2;     
    private double defaultVentSetting; 
    private double currentVentSetting; 

    public c90_SmartGreenhouseCO2(double minCO2, double maxCO2, double initialCO2, double defaultVentSetting) {
        this.minCO2 = minCO2;
        this.maxCO2 = maxCO2;
        this.currentCO2 = initialCO2;
        this.defaultVentSetting = defaultVentSetting;
        this.currentVentSetting = defaultVentSetting;
    }

    public void updateCO2(double newCO2) {
        currentCO2 = newCO2;
        adjustVentilation();

        System.out.printf("Current CO₂ Level: %.2f ppm, Ventilation Setting: %.2f%%%n", currentCO2, currentVentSetting);
        if (currentCO2 > maxCO2) {
            System.out.println("ALERT: High CO₂ concentration detected! Increasing ventilation.");
        } else if (currentCO2 < minCO2) {
            System.out.println("ALERT: Low CO₂ concentration detected! Reducing ventilation.");
        } else {
            System.out.println("CO₂ level is optimal. Ventilation remains at default setting.");
        }
    }

    private void adjustVentilation() {
        if (currentCO2 > maxCO2) {
            currentVentSetting = 100.0;
        } else if (currentCO2 < minCO2) {
            currentVentSetting = 0.0;
        } else {
            currentVentSetting = defaultVentSetting;
        }
    }

    public double getCurrentCO2() {
        return currentCO2;
    }

    public double getCurrentVentSetting() {
        return currentVentSetting;
    }

    public static void main(String[] args) {
    	c90_SmartGreenhouseCO2 greenhouse = new c90_SmartGreenhouseCO2(300.0, 800.0, 500.0, 50.0);

        // testcase-VT:
//        greenhouse.updateCO2(850.0);  
//        greenhouse.updateCO2(250.0);  
//        greenhouse.updateCO2(600.0);  
        
        // testcase-FT:
//        greenhouse.updateCO2(-1.7976931348623157E308);  
//        greenhouse.updateCO2(1.7976931348623157E308);  
//        greenhouse.updateCO2(0.0); 
    	
        // testcase-Z3:
//        greenhouse.updateCO2(850.0);  
//        greenhouse.updateCO2(250.0);  
//        greenhouse.updateCO2(600.0);  

        // testcase-UVT:
        greenhouse.updateCO2(850.0);  
        greenhouse.updateCO2(250.0);  
        greenhouse.updateCO2(600.0);  
    }
}
