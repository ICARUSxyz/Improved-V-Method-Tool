package code;

import java.util.*;

class ProductionLine {
    private double maxSpeed;
    private double minSpeed;
    private double optimalSpeed;
    private double currentSpeed;
    private boolean maintenanceWarning;
    private List<String> log;

    public ProductionLine(double maxSpeed, double minSpeed, double optimalSpeed, double initialSpeed) {
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.optimalSpeed = optimalSpeed;
        this.currentSpeed = initialSpeed;
        this.maintenanceWarning = false;
        this.log = new ArrayList<>();
    }

    public void updateSpeed(double changeAmount) {
        currentSpeed += changeAmount;
        manageProductionEfficiency();

        String message = String.format("Current Speed: %.2f units/hour", currentSpeed);
        if (currentSpeed > maxSpeed) {
            message += " | WARNING: Overproduction! Risk of Equipment Wear.";
        } else if (currentSpeed < minSpeed) {
            message += " | ALERT: Low Efficiency! Consider Increasing Output.";
        } else if (currentSpeed > optimalSpeed) {
            message += " | INFO: Adjusting for Efficiency.";
        } else {
            message += " | Speed is Optimal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageProductionEfficiency() {
        if (currentSpeed > maxSpeed) {
            maintenanceWarning = true;
        } else {
            maintenanceWarning = false;
        }
    }

    public void printLog() {
        System.out.println("\nProduction Line Speed Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c50_SmartFactoryProduction {
    public static void main(String[] args) {
        ProductionLine productionLine = new ProductionLine(200.0, 50.0, 150.0, 120.0); 

        // testcase-VT:
//        productionLine.updateSpeed(40.0);  
//        productionLine.updateSpeed(-30.0); 
//        productionLine.updateSpeed(-90.0); 
//        productionLine.updateSpeed(100.0); 
//        productionLine.updateSpeed(80.0);  
        
        // testcase-VT:
//        productionLine.updateSpeed(0.0);  
//        productionLine.updateSpeed(-1.7976931348623157E308); 
//        productionLine.updateSpeed(5.992310449541052E307); 
//        productionLine.updateSpeed(6.237000967295999E290); 
//        productionLine.updateSpeed(-5.992310449541052E307); 
        
        // testcase-Z3:
//        productionLine.updateSpeed(40.0);  
//        productionLine.updateSpeed(-30.0); 
//        productionLine.updateSpeed(-90.0); 
//        productionLine.updateSpeed(100.0); 
//        productionLine.updateSpeed(80.0);  
//        productionLine.printLog();	
        
        // testcase-UVT:
        productionLine.updateSpeed(40.0);  
        productionLine.updateSpeed(-30.0); 
        productionLine.updateSpeed(-90.0); 
        productionLine.updateSpeed(100.0); 
        productionLine.updateSpeed(80.0);  
        productionLine.printLog();	
    }
}
