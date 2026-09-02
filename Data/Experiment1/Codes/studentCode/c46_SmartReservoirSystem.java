package code;

import java.util.*;

class Reservoir46 {
    private double maxLevel;
    private double minLevel;
    private double currentLevel;
    private boolean drainageActive;
    private List<String> log;

    public Reservoir46(double maxLevel, double minLevel, double initialLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
        this.currentLevel = initialLevel;
        this.drainageActive = false;
        this.log = new ArrayList<>();
    }

    public void updateWaterLevel(double changeAmount) {
        currentLevel += changeAmount;
        manageDrainage();

        String message = String.format("Current Water Level: %.2f meters", currentLevel);
        if (currentLevel > maxLevel) {
            message += " | WARNING: Flood Risk! Activating Controlled Drainage.";
        } else if (currentLevel < minLevel) {
            message += " | ALERT: Water Shortage Risk! Implementing Conservation Measures.";
        } else {
            message += " | Water Level is Normal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageDrainage() {
        if (currentLevel > maxLevel) {
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

public class c46_SmartReservoirSystem {
    public static void main(String[] args) {
        Reservoir46 reservoir = new Reservoir46(50.0, 10.0, 30.0); 

        // testcase-VT:
//        reservoir.updateWaterLevel(15.0); 
//        reservoir.updateWaterLevel(-20.0); 
//        reservoir.updateWaterLevel(-18.0); 
//        reservoir.updateWaterLevel(20.0);  
//        reservoir.updateWaterLevel(30.0); 
//        reservoir.printLog(); 
        
        // testcase-FT:
//        reservoir.updateWaterLevel(7.0220245063344835E305); 
//        reservoir.updateWaterLevel(-1.7976931348623157E308); 
//        reservoir.updateWaterLevel(4.582355049649039E307); 
//        reservoir.updateWaterLevel(0.0);  
//        reservoir.updateWaterLevel(2.7414542845469334E293); 
//        reservoir.printLog(); 
        
        // testcase-Z3:
//        reservoir.updateWaterLevel(15); 
//        reservoir.updateWaterLevel(20); 
//        reservoir.updateWaterLevel(18); 
//        reservoir.updateWaterLevel(20);  
//        reservoir.updateWaterLevel(30); 
//        reservoir.printLog(); 
        
        // testcase-UVT:
        reservoir.updateWaterLevel(15); 
        reservoir.updateWaterLevel(-20); 
        reservoir.updateWaterLevel(-18); 
        reservoir.updateWaterLevel(20);  
        reservoir.updateWaterLevel(30); 
//        reservoir.printLog(); 
    }
}
