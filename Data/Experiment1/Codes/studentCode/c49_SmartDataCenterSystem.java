package code;

import java.util.*;

class DataCenterCooling {
    private double maxTemperature;
    private double optimalMinTemperature;
    private double optimalMaxTemperature;
    private double currentTemperature;
    private boolean coolingActive;
    private List<String> log;

    public DataCenterCooling(double maxTemperature, double optimalMinTemperature, double optimalMaxTemperature, double initialTemperature) {
        this.maxTemperature = maxTemperature;
        this.optimalMinTemperature = optimalMinTemperature;
        this.optimalMaxTemperature = optimalMaxTemperature;
        this.currentTemperature = initialTemperature;
        this.coolingActive = false;
        this.log = new ArrayList<>();
    }

    public void updateTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        manageCooling();

        String message = String.format("Current Temperature: %.2f°C", currentTemperature);
        if (currentTemperature > maxTemperature) {
            message += " | WARNING: Overheating Risk! Increasing Cooling Power.";
        } else if (currentTemperature < optimalMinTemperature) {
            message += " | ALERT: Low Temperature! Reducing Cooling to Save Energy.";
        } else if (currentTemperature > optimalMaxTemperature) {
            message += " | INFO: Adjusting Cooling for Efficiency.";
        } else {
            message += " | Temperature is Optimal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageCooling() {
        if (currentTemperature > maxTemperature) {
            coolingActive = true;
        } else if (currentTemperature < optimalMinTemperature) {
            coolingActive = false;
        }
    }

    public void printLog() {
        System.out.println("\nData Center Temperature Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c49_SmartDataCenterSystem {
    public static void main(String[] args) {
        DataCenterCooling dataCenter = new DataCenterCooling(35.0, 18.0, 28.0, 25.0); 

        // testcase-VT:
//        dataCenter.updateTemperature(4.0); 
//        dataCenter.updateTemperature(-6.0);
//        dataCenter.updateTemperature(-8.0);
//        dataCenter.updateTemperature(12.0);
//        dataCenter.updateTemperature(10.0);
//        dataCenter.printLog(); 
        
        // testcase-FT:
//        dataCenter.updateTemperature(4.9E-324); 
//        dataCenter.updateTemperature(-1.7976931348623157E308);
//        dataCenter.updateTemperature(0.0);
//        dataCenter.updateTemperature(6.750504225312172E302);
//        dataCenter.updateTemperature(-1.4170051768914723E308);
//        dataCenter.printLog(); 
        
        // testcase-Z3:
//        dataCenter.updateTemperature(4); 
//        dataCenter.updateTemperature(-6);
//        dataCenter.updateTemperature(-8);
//        dataCenter.updateTemperature(12);
//        dataCenter.updateTemperature(10);
//        dataCenter.printLog(); 
        
        // testcase-UVT:
        dataCenter.updateTemperature(4.0); 
        dataCenter.updateTemperature(-6.0);
        dataCenter.updateTemperature(-8.0);
        dataCenter.updateTemperature(12.0);
        dataCenter.updateTemperature(10.0);
        dataCenter.printLog(); 
    }
}
