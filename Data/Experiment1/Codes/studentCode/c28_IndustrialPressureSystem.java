package code;

import java.util.*;

class PressureMonitor {
    private double maxPressure;
    private double minPressure;
    private double currentPressure;
    private List<String> pressureLog;

    public PressureMonitor(double maxPressure, double minPressure, double initialPressure) {
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.currentPressure = initialPressure;
        this.pressureLog = new ArrayList<>();
    }

    public void updatePressure(double changeAmount) {
        currentPressure += changeAmount;

        String message = String.format("Current Pressure: %.1f bar", currentPressure);
        if (currentPressure > maxPressure) {
            message += " | WARNING: High Pressure Detected!";
        } else if (currentPressure < minPressure) {
            message += " | ALERT: Possible Leak Detected!";
        }

        System.out.println(message);
        pressureLog.add(message);
    }

    public void printPressureLog() {
        System.out.println("\nPressure Log:");
        for (String log : pressureLog) {
            System.out.println(log);
        }
    }
}

public class c28_IndustrialPressureSystem {
    public static void main(String[] args) {
        PressureMonitor monitor = new PressureMonitor(10.0, 2.0, 5.0); 
        
        // testcase-VT:
//        monitor.updatePressure(3.0);  
//        monitor.updatePressure(-4.0);
//        monitor.updatePressure(-3.0); 
//        monitor.updatePressure(6.0);  
//        monitor.updatePressure(5.0);
        
        // testcase-FT:
//        monitor.updatePressure(-2.608417489800224E307);  
//        monitor.updatePressure(1.7836486572462039E308);
//        monitor.updatePressure(-1.7976931348623157E308); 
//        monitor.updatePressure(3.172399649757028E307);  
//        monitor.updatePressure(-1.450546694021716E308);
        
        // testcase-VT:
//        monitor.updatePressure(3);  
//        monitor.updatePressure(4);
//        monitor.updatePressure(3); 
//        monitor.updatePressure(6);  
//        monitor.updatePressure(5);
        
        // testcase-VT:
        monitor.updatePressure(3.0);  
        monitor.updatePressure(4.0);
        monitor.updatePressure(3.0); 
        monitor.updatePressure(6.0);  
        monitor.updatePressure(5.0);
        
        monitor.printPressureLog(); 
    }
}
