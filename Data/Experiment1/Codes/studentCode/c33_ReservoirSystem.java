package code;

import java.util.*;

class Reservoir {
    private double maxLevel;
    private double minLevel;
    private double currentLevel;
    private List<String> levelLog;

    public Reservoir(double maxLevel, double minLevel, double initialLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
        this.currentLevel = initialLevel;
        this.levelLog = new ArrayList<>();
    }

    public void updateWaterLevel(double changeAmount) {
        currentLevel += changeAmount;

        String message = String.format("Current Water Level: %.1f meters", currentLevel);
        if (currentLevel > maxLevel) {
            message += " | WARNING: Overflow Risk! Immediate Water Release Required.";
        } else if (currentLevel < minLevel) {
            message += " | ALERT: Drought Risk! Water Conservation Recommended.";
        }

        System.out.println(message);
        levelLog.add(message);
    }

    public void printLevelLog() {
        System.out.println("\nWater Level Log:");
        for (String log : levelLog) {
            System.out.println(log);
        }
    }
}

public class c33_ReservoirSystem {
    public static void main(String[] args) {
        Reservoir reservoir = new Reservoir(50.0, 10.0, 30.0); 

        // testcase-VT:
//        reservoir.updateWaterLevel(79.2);
//        reservoir.updateWaterLevel(-120.3);
//        reservoir.updateWaterLevel(40.3);
        
        
        // testcase-FT:
//        reservoir.updateWaterLevel(1.3394576298974116E307);
//        reservoir.updateWaterLevel(-1.7976931348623157E308);
//        reservoir.updateWaterLevel(4.482844445243999E290);

        // testcase-Z3:
		  reservoir.updateWaterLevel(79);
		  reservoir.updateWaterLevel(120);
		  reservoir.updateWaterLevel(40);
      
        // testcase-UVT:
//	      reservoir.updateWaterLevel(55);
//	      reservoir.updateWaterLevel(-13);
//	      reservoir.updateWaterLevel(30);
      
//        reservoir.printLevelLog(); 
    }
}

