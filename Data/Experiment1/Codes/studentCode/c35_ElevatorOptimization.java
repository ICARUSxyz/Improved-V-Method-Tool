package code;

import java.util.*;

class ElevatorSystem {
    private double maxLoad;
    private double energyThreshold;
    private double currentLoad;
    private List<String> log;

    public ElevatorSystem(double maxLoad, double energyThreshold) {
        this.maxLoad = maxLoad;
        this.energyThreshold = energyThreshold;
        this.currentLoad = 0.0;
        this.log = new ArrayList<>();
    }

    public void enterElevator(double weight) {
        currentLoad += weight;

        String message = String.format("Current Load: %.1f kg", currentLoad);
        if (currentLoad > maxLoad) {
            message += " | WARNING: Overload Detected! Reduce Load Immediately.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void calculateEnergyUsage(double travelDistance) {
        double energyUsage = (currentLoad / maxLoad) * travelDistance * 2; 
        String message = String.format("Estimated Energy Usage: %.2f kWh for %.1f meters travel", energyUsage, travelDistance);
        
        if (energyUsage > energyThreshold) {
            message += " | ALERT: High Energy Usage! Consider Load Optimization.";
        }

        System.out.println(message);
        log.add(message);
    }


    public void printLog() {
        System.out.println("\nElevator System Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c35_ElevatorOptimization {
    public static void main(String[] args) {
        ElevatorSystem elevator = new ElevatorSystem(1000.0, 5.0); 
        
        // testcase-VT:
//        elevator.enterElevator(200.0); 
//        elevator.enterElevator(500.0); 
//        elevator.enterElevator(400.0); 
//        elevator.calculateEnergyUsage(10.0);
//        elevator.calculateEnergyUsage(25.0); 
//        elevator.calculateEnergyUsage(1.0); 
//        elevator.printLog(); 
        
        // testcase-FT:
//        elevator.enterElevator(-4.9E-324);
//        elevator.enterElevator(0.0);
//        elevator.enterElevator(1.7976931348623157E308);
//        elevator.enterElevator(-1.7976931348623157E308);
//        elevator.enterElevator(7.754754699406067E306);
//        elevator.enterElevator(9.799190029249484E307);
//        elevator.printLog(); 
        
        // testcase-Z3:
//        elevator.enterElevator(2); 
//        elevator.enterElevator(5); 
//        elevator.enterElevator(4); 
//        elevator.enterElevator(1);
//        elevator.enterElevator(2); 
//        elevator.enterElevator(1); 
        
        // testcase-UVT:
        elevator.enterElevator(200.0); 
        elevator.enterElevator(500.0); 
        elevator.enterElevator(400.0); 
        elevator.enterElevator(200.0); 
        elevator.enterElevator(500.0); 
        elevator.enterElevator(400.0);
    }
}