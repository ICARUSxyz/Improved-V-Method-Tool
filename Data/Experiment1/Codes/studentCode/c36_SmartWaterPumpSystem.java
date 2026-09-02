package code;

import java.util.*;

class WaterPump {
    private double minFlowRate;
    private double maxEnergyUsage;
    private double currentFlowRate;
    private double currentEnergyUsage;
    private List<String> log;

    public WaterPump(double minFlowRate, double maxEnergyUsage, double initialFlowRate) {
        this.minFlowRate = minFlowRate;
        this.maxEnergyUsage = maxEnergyUsage;
        this.currentFlowRate = initialFlowRate;
        this.currentEnergyUsage = 0.0;
        this.log = new ArrayList<>();
    }

    public void updateFlowRate(double changeAmount) {
        currentFlowRate += changeAmount;

        String message = String.format("Current Flow Rate: %.2f L/min", currentFlowRate);
        if (currentFlowRate < minFlowRate) {
            message += " | ALERT: Low Flow Detected! Possible Clogging or Low Pressure.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void calculateEnergyUsage(double runTime) {
        currentEnergyUsage = (currentFlowRate / minFlowRate) * runTime * 1.5;
        String message = String.format("Estimated Energy Usage: %.2f kWh for %.1f minutes operation", currentEnergyUsage, runTime);

        if (currentEnergyUsage > maxEnergyUsage) {
            message += " | WARNING: High Energy Consumption! Consider Efficiency Optimization.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void printLog() {
        System.out.println("\nWater Pump System Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c36_SmartWaterPumpSystem {
    public static void main(String[] args) {
        WaterPump pump = new WaterPump(30.0, 10.0, 50.0); 

        // testcase-VT:
//        pump.updateFlowRate(-10.0); 
//        pump.updateFlowRate(-15.0);  
//        pump.calculateEnergyUsage(20.0); 
//        pump.calculateEnergyUsage(60.0); 
//        pump.calculateEnergyUsage(1.0);
//        pump.printLog(); 
        
        // testcase-FT:
//        pump.updateFlowRate(-1.7976931348623157E308);
//        pump.updateFlowRate(0.0);
//        pump.updateFlowRate(2.4850550729069995E291);
//        pump.updateFlowRate(6.384642474568709E293);
//        pump.updateFlowRate(7.016626088207998E290);
//        pump.printLog(); 
        
        // testcase-Z3:
	      pump.updateFlowRate(-100); 
	      pump.updateFlowRate(-15);  
	      pump.calculateEnergyUsage(20); 
	      pump.calculateEnergyUsage(600); 
	      pump.calculateEnergyUsage(1);
        
        // testcase-UVT:
//	      pump.updateFlowRate(10); 
//	      pump.updateFlowRate(15);  
//	      pump.calculateEnergyUsage(20); 
//	      pump.calculateEnergyUsage(60); 
//	      pump.calculateEnergyUsage(1);

    }
}
