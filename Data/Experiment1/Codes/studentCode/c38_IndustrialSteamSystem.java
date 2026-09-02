package code;

import java.util.*;

class SteamSystem {
    private double maxPressure;
    private double minPressure;
    private double currentPressure;
    private List<String> log;

    public SteamSystem(double maxPressure, double minPressure, double initialPressure) {
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.currentPressure = initialPressure;
        this.log = new ArrayList<>();
    }

    public void updatePressure(double changeAmount) {
        currentPressure += changeAmount;

        String message = String.format("Current Steam Pressure: %.2f bar", currentPressure);
        if (currentPressure > maxPressure) {
            message += " | WARNING: Overpressure Detected! Risk of System Failure.";
        } else if (currentPressure < minPressure) {
            message += " | ALERT: Possible Leak Detected! Efficiency Loss Risk.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void printLog() {
        System.out.println("\nSteam Pressure Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c38_IndustrialSteamSystem {
    public static void main(String[] args) {
        SteamSystem steamSystem = new SteamSystem(10.0, 3.0, 6.0); 

        // testcase-VT:
//        steamSystem.updatePressure(3.5); 
//        steamSystem.updatePressure(-4.0); 
//        steamSystem.updatePressure(-3.0); 
//        steamSystem.updatePressure(4.5);  
//        steamSystem.updatePressure(4.0);  
        
        //testcase-FT:
//        steamSystem.updatePressure(6.416398597203269E305); 
//        steamSystem.updatePressure(-1.7976931348623157E308); 
//        steamSystem.updatePressure(3.9229556063199447E298); 
//        steamSystem.updatePressure(-6.838283965724573E307);  
//        steamSystem.updatePressure(1.1092300594210293E296); 

        // testcase-Z3:
//        steamSystem.updatePressure(3.5); 
//        steamSystem.updatePressure(4.0); 
//        steamSystem.updatePressure(3.0); 
//        steamSystem.updatePressure(4.5);  
//        steamSystem.updatePressure(4.0); 
        
        // testcase-UVT:
        steamSystem.updatePressure(3); 
        steamSystem.updatePressure(-40); 
        steamSystem.updatePressure(-30); 
        steamSystem.updatePressure(45);  
        steamSystem.updatePressure(4);
        
//        steamSystem.printLog(); 
    }
}

	