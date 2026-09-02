package code;

import java.util.*;

class SmartWaterPump {
    private double maxPressure;
    private double minPressure;
    private double currentPressure;
    private boolean pumpActive;
    private List<String> log;

    public SmartWaterPump(double maxPressure, double minPressure, double initialPressure) {
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.currentPressure = initialPressure;
        this.pumpActive = true;
        this.log = new ArrayList<>();
    }

    public void updatePressure(double changeAmount) {
        currentPressure += changeAmount;
        managePumpOperation();

        String message = String.format("Current Pressure: %.2f bar", currentPressure);
        if (currentPressure > maxPressure) {
            message += " | WARNING: High Pressure! Reducing Pump Power.";
        } else if (currentPressure < minPressure) {
            message += " | ALERT: Possible Leak Detected! Inspection Required.";
        } else {
            message += " | Pressure is Normal.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void managePumpOperation() {
        if (currentPressure > maxPressure) {
            pumpActive = false;
        } else if (currentPressure < minPressure) {
            pumpActive = true;
        }
    }

    public void printLog() {
        System.out.println("\nWater Pump Pressure Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c52_SmartWaterPumpSystem {
    public static void main(String[] args) {
        SmartWaterPump pump = new SmartWaterPump(8.0, 3.0, 5.0); 

        // testcase-VT:
//        pump.updatePressure(2.5);  
//        pump.updatePressure(-3.0); 
//        pump.updatePressure(-2.0); 
//        pump.updatePressure(4.0);  
//        pump.updatePressure(3.5);  
//        pump.printLog(); 
    
        // testcase-FT:
//        pump.updatePressure(-1.7976931348623157E308);  
//        pump.updatePressure(0.0); 
//        pump.updatePressure(1.7976931348623157E308); 
//        pump.updatePressure(8.530048910211935E300);  
//        pump.updatePressure(4.665666536097863E293);  
//        pump.printLog(); 
        
        // testcase-Z3:
//        pump.updatePressure(2);  
//        pump.updatePressure(-3); 
//        pump.updatePressure(-2); 
//        pump.updatePressure(4);  
//        pump.updatePressure(3);  
//        pump.printLog(); 
        
        // testcase-UVT:
        pump.updatePressure(2.5);  
        pump.updatePressure(-3.0); 
        pump.updatePressure(-2.0); 
        pump.updatePressure(4.0);  
        pump.updatePressure(3.5);  
        pump.printLog(); 
    }
}

