package code;

import java.util.*;

class SmartTrafficSignal {
    private int maxTrafficDensity;
    private int minTrafficDensity;
    private int currentTrafficDensity;
    private int greenLightDuration;
    private List<String> log;

    public SmartTrafficSignal(int maxTrafficDensity, int minTrafficDensity, int initialTrafficDensity, int initialGreenLightDuration) {
        this.maxTrafficDensity = maxTrafficDensity;
        this.minTrafficDensity = minTrafficDensity;
        this.currentTrafficDensity = initialTrafficDensity;
        this.greenLightDuration = initialGreenLightDuration;
        this.log = new ArrayList<>();
    }

    public void updateTrafficDensity(int newDensity) {
        currentTrafficDensity = newDensity;
        adjustSignalTiming();

        String message = String.format("Current Traffic Density: %d vehicles | Green Light: %d seconds", 
                                       currentTrafficDensity, greenLightDuration);
        if (currentTrafficDensity > maxTrafficDensity) {
            message += " | WARNING: High Congestion! Extending Green Light Duration.";
        } else if (currentTrafficDensity < minTrafficDensity) {
            message += " | INFO: Low Traffic! Reducing Green Light Duration.";
        } else {
            message += " | Traffic Flow is Optimal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void adjustSignalTiming() {
        if (currentTrafficDensity > maxTrafficDensity) {
            greenLightDuration += 10; 
        } else if (currentTrafficDensity < minTrafficDensity) {
            greenLightDuration = Math.max(10, greenLightDuration - 5); 
        }
    }

    public void printLog() {
        System.out.println("\nTraffic Signal Adjustment Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c53_SmartTrafficSystem {
    public static void main(String[] args) {
        SmartTrafficSignal signal = new SmartTrafficSignal(50, 10, 30, 30);

        // testcase-VT:
        signal.updateTrafficDensity(60); 
        signal.updateTrafficDensity(40); 
        signal.updateTrafficDensity(5);  
        signal.updateTrafficDensity(20);  
        signal.updateTrafficDensity(70);  
        signal.printLog();  
        
        // testcase-FT:
//        signal.updateTrafficDensity(36); 
//        signal.updateTrafficDensity(40); 
//        signal.updateTrafficDensity(10280);  
//        signal.updateTrafficDensity(10446);  
//        signal.updateTrafficDensity(189);  
//        signal.printLog();
        
        // testcase-Z3:
//        signal.updateTrafficDensity(60); 
//        signal.updateTrafficDensity(40); 
//        signal.updateTrafficDensity(5);  
//        signal.updateTrafficDensity(20);  
//        signal.updateTrafficDensity(70);  
//        signal.printLog(); 
        
        // testcase-UVT:
        signal.updateTrafficDensity(60); 
        signal.updateTrafficDensity(40); 
        signal.updateTrafficDensity(5);  
        signal.updateTrafficDensity(20);  
        signal.updateTrafficDensity(70);  
        signal.printLog(); 
    }
}
