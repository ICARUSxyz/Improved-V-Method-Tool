package code;

public class c91_SmartCO2Control {

    private double minCO2;         
    private double maxCO2;        
    private double currentCO2;     
    private boolean generatorActive;  
    private boolean ventilationActive;  

    public c91_SmartCO2Control(double minCO2, double maxCO2, double initialCO2) {
        this.minCO2 = minCO2;
        this.maxCO2 = maxCO2;
        this.currentCO2 = initialCO2;
        this.generatorActive = false;
        this.ventilationActive = false;
    }

    public void updateCO2(double newCO2) {
        currentCO2 = newCO2;
        adjustControlSystem();
        System.out.printf("Current CO2 Concentration: %.2f ppm%n", currentCO2);
        if (generatorActive) {
            System.out.println("ALERT: CO2 level too low. Activating CO2 generator.");
        } else if (ventilationActive) {
            System.out.println("ALERT: CO2 level too high. Activating ventilation system.");
        } else {
            System.out.println("CO2 level is optimal. No action required.");
        }
    }

    private void adjustControlSystem() {
        if (currentCO2 < minCO2) {
            generatorActive = true;
            ventilationActive = false;
        } else if (currentCO2 > maxCO2) {
            generatorActive = false;
            ventilationActive = true;
        } else {
            generatorActive = false;
            ventilationActive = false;
        }
    }

    public double getCurrentCO2() {
        return currentCO2;
    }
    
    public boolean isGeneratorActive() {
        return generatorActive;
    }
    
    public boolean isVentilationActive() {
        return ventilationActive;
    }
    
    public static void main(String[] args) {
    	c91_SmartCO2Control co2Control = new c91_SmartCO2Control(350.0, 800.0, 500.0);
        
        // testcase-VT:
//        co2Control.updateCO2(300.0);  
//        co2Control.updateCO2(750.0);  
//        co2Control.updateCO2(850.0);
        
        // testcase-FT:
//        co2Control.updateCO2(1.7976931348623157E308);  
//        co2Control.updateCO2(0.0);  
//        co2Control.updateCO2(9.745314011399998E288);
    	
        // testcase-Z3:
//        co2Control.updateCO2(300.0);  
//        co2Control.updateCO2(750.0);  
//        co2Control.updateCO2(850.0);
        
        // testcase-UVT:
        co2Control.updateCO2(300.0);  
        co2Control.updateCO2(750.0);  
        co2Control.updateCO2(850.0);
    }
}
