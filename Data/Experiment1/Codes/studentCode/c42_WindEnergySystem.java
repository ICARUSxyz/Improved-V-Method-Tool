package code;
import java.util.*;

class WindTurbine42 {
    private double maxWindSpeed;
    private double minWindSpeed;
    private double currentWindSpeed;
    private double bladeAngle; 
    private List<String> log;

    public WindTurbine42(double maxWindSpeed, double minWindSpeed, double initialWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
        this.minWindSpeed = minWindSpeed;
        this.currentWindSpeed = initialWindSpeed;
        this.bladeAngle = 30.0; 
        this.log = new ArrayList<>();
    }

    public void updateWindSpeed(double changeAmount) {
        currentWindSpeed += changeAmount;
        adjustBladeAngle();

        String message = String.format("Wind Speed: %.2f m/s | Blade Angle: %.1f°", currentWindSpeed, bladeAngle);
        if (currentWindSpeed > maxWindSpeed) {
            message += " | WARNING: High Wind Speed! Adjusting Blades to Reduce Stress.";
        } else if (currentWindSpeed < minWindSpeed) {
            message += " | ALERT: Low Wind Speed! Adjusting Blades to Maximize Efficiency.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void adjustBladeAngle() {
        if (currentWindSpeed > maxWindSpeed) {
            bladeAngle = 75.0; 
        } else if (currentWindSpeed < minWindSpeed) {
            bladeAngle = 15.0; 
        } else {
            bladeAngle = 30.0; 
        }
    }

    public void printLog() {
        System.out.println("\nWind Turbine Adjustment Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c42_WindEnergySystem {
    public static void main(String[] args) {
        WindTurbine42 turbine = new WindTurbine42(25.0, 5.0, 12.0); 

        // testcase-VT:
//        turbine.updateWindSpeed(10.0);  
//        turbine.updateWindSpeed(-8.0);  
//        turbine.updateWindSpeed(-10.0); 
//        turbine.updateWindSpeed(15.0);  
//        turbine.updateWindSpeed(10.0);
        
        // testcase-FT:
//        turbine.updateWindSpeed(-1.7976931348623157E308);  
//        turbine.updateWindSpeed(1.1209145429141497E308);  
//        turbine.updateWindSpeed(1.7976828080405392E308); 
//        turbine.updateWindSpeed(0.0);  
//        turbine.updateWindSpeed(-6.838283689477282E307);
        
        // testcase-Z3:
//        turbine.updateWindSpeed(10);  
//        turbine.updateWindSpeed(8);  
//        turbine.updateWindSpeed(10); 
//        turbine.updateWindSpeed(15);  
//        turbine.updateWindSpeed(10);
        
        // testcase-UVT:
        turbine.updateWindSpeed(10.0);  
        turbine.updateWindSpeed(-8.0);  
        turbine.updateWindSpeed(-10.0); 
        turbine.updateWindSpeed(15.0);  
        turbine.updateWindSpeed(10.0);
        
//        turbine.printLog(); 
    }
}
