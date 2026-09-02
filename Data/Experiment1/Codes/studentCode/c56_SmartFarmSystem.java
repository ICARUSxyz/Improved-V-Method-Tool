package code;

import java.util.*;

class SmartIrrigation {
    private double maxMoisture;
    private double minMoisture;
    private double currentMoisture;
    private boolean irrigationActive;
    private List<String> log;

    public SmartIrrigation(double maxMoisture, double minMoisture, double initialMoisture) {
        this.maxMoisture = maxMoisture;
        this.minMoisture = minMoisture;
        this.currentMoisture = initialMoisture;
        this.irrigationActive = false;
        this.log = new ArrayList<>();
    }

    public void updateMoisture(double changeAmount) {
        currentMoisture += changeAmount;
        manageIrrigation();

        String message = String.format("Current Soil Moisture: %.2f%%", currentMoisture);
        if (currentMoisture < minMoisture) {
            message += " | ALERT: Dry Soil! Activating Irrigation.";
        } else if (currentMoisture > maxMoisture) {
            message += " | INFO: Excess Moisture! Pausing Irrigation.";
        } else {
            message += " | Moisture Level is Optimal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageIrrigation() {
        if (currentMoisture < minMoisture) {
            irrigationActive = true;
        } else if (currentMoisture > maxMoisture) {
            irrigationActive = false;
        }
    }

    public void printLog() {
        System.out.println("\nIrrigation System Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c56_SmartFarmSystem {
    public static void main(String[] args) {
        SmartIrrigation irrigation = new SmartIrrigation(60.0, 30.0, 45.0); 

        // testcase-VT:
//        irrigation.updateMoisture(-20.0);  
//        irrigation.updateMoisture(15.0);   
//        irrigation.updateMoisture(25.0);   
//        irrigation.updateMoisture(-10.0);  
//        irrigation.printLog(); 
        
        // testcase-FT:
//        irrigation.updateMoisture(0.0);  
//        irrigation.updateMoisture(-1.7976931348623157E308);   
//        irrigation.updateMoisture(1.7976931348623157E308);   
//        irrigation.updateMoisture(-8.812221795584368E307);  
//        irrigation.printLog(); 
        
        // testcase-Z3:
//        irrigation.updateMoisture(-20);  
//        irrigation.updateMoisture(15);   
//        irrigation.updateMoisture(25);   
//        irrigation.updateMoisture(-10);  
//        irrigation.printLog(); 
        
        // testcase-UVT:
        irrigation.updateMoisture(-20.0);  
        irrigation.updateMoisture(15.0);   
        irrigation.updateMoisture(25.0);   
        irrigation.updateMoisture(-10.0);  
        irrigation.printLog(); 
    }
}
