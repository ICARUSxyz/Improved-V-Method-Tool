package code;

import java.util.*;

class SmartReservoir {
    private double maxWaterLevel;
    private double minWaterLevel;
    private double currentWaterLevel;
    private boolean drainageActive;
    private List<String> log;

    public SmartReservoir(double maxWaterLevel, double minWaterLevel, double initialWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
        this.minWaterLevel = minWaterLevel;
        this.currentWaterLevel = initialWaterLevel;
        this.drainageActive = false;
        this.log = new ArrayList<>();
    }

    public void updateWaterLevel(double changeAmount) {
        currentWaterLevel += changeAmount;
        manageFloodControl();

        String message = String.format("Current Water Level: %.2f meters", currentWaterLevel);
        if (currentWaterLevel > maxWaterLevel) {
            message += " | WARNING: Flood Risk! Activating Controlled Drainage.";
        } else if (currentWaterLevel < minWaterLevel) {
            message += " | ALERT: Water Shortage! Implementing Conservation Measures.";
        } else {
            message += " | Water Level is Stable.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageFloodControl() {
        if (currentWaterLevel > maxWaterLevel) {
            drainageActive = true;
        } else {
            drainageActive = false;
        }
    }

    public void printLog() {
        System.out.println("\nReservoir Water Level Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c55_SmartReservoirSystem {
    public static void main(String[] args) {
        SmartReservoir reservoir = new SmartReservoir(50.0, 10.0, 30.0); 

        // testcase-VT:
//        reservoir.updateWaterLevel(15.0);  
//        reservoir.updateWaterLevel(-20.0); 
//        reservoir.updateWaterLevel(-18.0); 
//        reservoir.updateWaterLevel(20.0);  
//        reservoir.updateWaterLevel(30.0); 
        
        // testcase-FT:
//        reservoir.updateWaterLevel(0.0);  
//        reservoir.updateWaterLevel(-1.7976931348623157E308); 
//        reservoir.updateWaterLevel(1.6349922841177022E296); 
//        reservoir.updateWaterLevel(1.0715086069397108E301);  
//        reservoir.updateWaterLevel(6.362033346062261E293); 
        
        // testcase-Z3:
//        reservoir.updateWaterLevel(15);  
//        reservoir.updateWaterLevel(-20); 
//        reservoir.updateWaterLevel(-18); 
//        reservoir.updateWaterLevel(20);  
//        reservoir.updateWaterLevel(30); 
//        reservoir.printLog(); 
        
        // testcase-UVT:
        reservoir.updateWaterLevel(15.0);  
        reservoir.updateWaterLevel(-20.0); 
        reservoir.updateWaterLevel(-18.0); 
        reservoir.updateWaterLevel(20.0);  
        reservoir.updateWaterLevel(30.0); 
        reservoir.printLog(); 
    }
}
