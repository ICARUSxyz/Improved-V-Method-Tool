package code;

import java.util.*;

class FactoryEnergySystem {
    private double maxEnergyThreshold;
    private double minEfficiencyThreshold;
    private double currentEnergyUsage;
    private boolean powerSavingMode;
    private List<String> log;

    public FactoryEnergySystem(double maxEnergyThreshold, double minEfficiencyThreshold, double initialEnergyUsage) {
        this.maxEnergyThreshold = maxEnergyThreshold;
        this.minEfficiencyThreshold = minEfficiencyThreshold;
        this.currentEnergyUsage = initialEnergyUsage;
        this.powerSavingMode = false;
        this.log = new ArrayList<>();
    }

    public void updateEnergyUsage(double changeAmount) {
        currentEnergyUsage += changeAmount;
        manageEnergyEfficiency();

        String message = String.format("Current Energy Usage: %.2f kWh", currentEnergyUsage);
        if (currentEnergyUsage > maxEnergyThreshold) {
            message += " | WARNING: High Energy Consumption! Activating Power-Saving Mode.";
        } else if (currentEnergyUsage < minEfficiencyThreshold) {
            message += " | ALERT: Low Efficiency! Optimizing Machine Operation.";
        } else {
            message += " | Energy Usage is Normal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageEnergyEfficiency() {
        if (currentEnergyUsage > maxEnergyThreshold) {
            powerSavingMode = true; 
        } else {
            powerSavingMode = false;
        }
    }

    public void printLog() {
        System.out.println("\nFactory Energy Consumption Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c47_SmartFactorySystem {
    public static void main(String[] args) {
        FactoryEnergySystem factory = new FactoryEnergySystem(5000.0, 1000.0, 3000.0); 

        // testcase-VT:
//        factory.updateEnergyUsage(1200.0); 
//        factory.updateEnergyUsage(-1500.0); 
//        factory.updateEnergyUsage(-1800.0); 
//        factory.updateEnergyUsage(2500.0);  
//        factory.updateEnergyUsage(1800.0);  
//        factory.printLog(); 
        
        // testcase-FT:
//        factory.updateEnergyUsage(2.3292275018647134E293); 
//        factory.updateEnergyUsage(-1.7976931348623157E308); 
//        factory.updateEnergyUsage(1.7976931348623157E308); 
//        factory.updateEnergyUsage(0.0);  
//        factory.updateEnergyUsage(6.838283689476259E307);  
//        factory.printLog(); 
        
        // testcase-Z3:
//        factory.updateEnergyUsage(1200); 
//        factory.updateEnergyUsage(-1500); 
//        factory.updateEnergyUsage(-1800); 
//        factory.updateEnergyUsage(2500);  
//        factory.updateEnergyUsage(1800);  
//        factory.printLog(); 
        
        // testcase-UVT:
        factory.updateEnergyUsage(1200.0); 
        factory.updateEnergyUsage(-1500.0); 
        factory.updateEnergyUsage(-1800.0); 
        factory.updateEnergyUsage(2500.0);  
        factory.updateEnergyUsage(1800.0);  
        factory.printLog(); 
    }
}

