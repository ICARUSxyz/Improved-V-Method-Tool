package code;

class SmartSolarPanel66 {
    private double maxOptimalPower;
    private double minOptimalPower;
    private double currentPowerOutput;
    private double panelTiltAngle;

    public SmartSolarPanel66(double maxOptimalPower, double minOptimalPower, double initialPower, double initialAngle) {
        this.maxOptimalPower = maxOptimalPower;
        this.minOptimalPower = minOptimalPower;
        this.currentPowerOutput = initialPower;
        this.panelTiltAngle = initialAngle;
    }

    public void updatePowerOutput(double changeAmount) {
        currentPowerOutput += changeAmount;
        adjustTiltAngle();

        System.out.printf("Current Power Output: %.2f W\n", currentPowerOutput);
        System.out.printf("Panel Tilt Angle: %.2f°\n", panelTiltAngle);
    }

    private void adjustTiltAngle() {
        if (currentPowerOutput < minOptimalPower) {
            panelTiltAngle += 5.0; 
        } else if (currentPowerOutput > maxOptimalPower) {
            panelTiltAngle -= 5.0; 
        }
    }
}

public class c66_SmartSolarSystem {
    public static void main(String[] args) {
        SmartSolarPanel66 solarPanel = new SmartSolarPanel66(500.0, 200.0, 300.0, 30.0); 

        // testcase-VT:
//        solarPanel.updatePowerOutput(-150.0);  
//        solarPanel.updatePowerOutput(100.0);   
//        solarPanel.updatePowerOutput(300.0);   
//        solarPanel.updatePowerOutput(-50.0); 
        
        // testcase-FT:
//        solarPanel.updatePowerOutput(-4.9E-324);  
//        solarPanel.updatePowerOutput(0.0);   
//        solarPanel.updatePowerOutput(-1.7976931348623157E308);   
//        solarPanel.updatePowerOutput(2.2250738585072014E-308); 
        
        // testcase-Z3:
//        solarPanel.updatePowerOutput(-150.0);  
//        solarPanel.updatePowerOutput(100.0);   
//        solarPanel.updatePowerOutput(300.0);   
//        solarPanel.updatePowerOutput(-50.0); 
        
        // testcase-UVT:
        solarPanel.updatePowerOutput(-150.0);  
        solarPanel.updatePowerOutput(100.0);   
        solarPanel.updatePowerOutput(300.0);   
        solarPanel.updatePowerOutput(-50.0); 
    }
}
