package code;

public class c94_SmartWindTurbine {

    private double minWindSpeed; 
    private double maxWindSpeed; 
    private double currentWindSpeed; 
    private double maxPowerOutput; 
    private double currentPowerOutput;  

    public c94_SmartWindTurbine(double minWindSpeed, double maxWindSpeed, double maxPowerOutput, double initialWindSpeed) {
        this.minWindSpeed = minWindSpeed;
        this.maxWindSpeed = maxWindSpeed;
        this.maxPowerOutput = maxPowerOutput;
        this.currentWindSpeed = initialWindSpeed;
        this.currentPowerOutput = 0.0;
    }

    public void updateWindSpeed(double newWindSpeed) {
        currentWindSpeed = newWindSpeed;
        adjustPowerOutput();
        System.out.printf("Current Wind Speed: %.2f m/s, Power Output: %.2f MW%n",
                currentWindSpeed, currentPowerOutput);

        if (currentWindSpeed < minWindSpeed) {
            System.out.println("ALERT: Wind speed too low. Power generation halted.");
        } else if (currentWindSpeed > maxWindSpeed) {
            System.out.println("ALERT: Wind speed too high. Turbine shut down for safety.");
        } else {
            System.out.println("Turbine operating normally.");
        }
    }

    private void adjustPowerOutput() {
        if (currentWindSpeed < minWindSpeed || currentWindSpeed > maxWindSpeed) {
            currentPowerOutput = 0.0; 
        } else {
            currentPowerOutput = maxPowerOutput * Math.pow((currentWindSpeed / maxWindSpeed), 3);
        }
    }

    public double getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public double getCurrentPowerOutput() {
        return currentPowerOutput;
    }

    public static void main(String[] args) {
    	c94_SmartWindTurbine turbine = new c94_SmartWindTurbine(3.0, 25.0, 2.0, 10.0);

        // testcase-VT:
//        turbine.updateWindSpeed(2.0);  
//        turbine.updateWindSpeed(12.0); 
//        turbine.updateWindSpeed(28.0);
        
        // testcase-FT:
//        turbine.updateWindSpeed(1.0574665499190092E307);  
//        turbine.updateWindSpeed(-1.7976931348623157E308); 
//        turbine.updateWindSpeed(1.5205429148608833E298);
    	
        // testcase-Z3:
//        turbine.updateWindSpeed(2.0);  
//        turbine.updateWindSpeed(12.0); 
//        turbine.updateWindSpeed(28.0);
        
        // testcase-UVT:
        turbine.updateWindSpeed(2.0);  
        turbine.updateWindSpeed(12.0); 
        turbine.updateWindSpeed(28.0);
    }
}
