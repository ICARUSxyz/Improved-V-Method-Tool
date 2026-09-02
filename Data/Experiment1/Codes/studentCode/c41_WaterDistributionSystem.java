package code;

import java.util.*;

class WaterPipeline {
    private double maxPressure;
    private double minPressure;
    private double currentPressure;
    private List<String> log;

    public WaterPipeline(double maxPressure, double minPressure, double initialPressure) {
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.currentPressure = initialPressure;
        this.log = new ArrayList<>();
    }

    public void updatePressure(double changeAmount) {
        currentPressure += changeAmount;

        String message = String.format("Current Water Pressure: %.2f bar", currentPressure);
        if (currentPressure > maxPressure) {
            message += " | WARNING: Overpressure Detected! Risk of Pipe Bursting.";
        } else if (currentPressure < minPressure) {
            message += " | ALERT: Possible Leak Detected! Immediate Inspection Required.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void printLog() {
        System.out.println("\nWater Pressure Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c41_WaterDistributionSystem {
    public static void main(String[] args) {
        WaterPipeline pipeline = new WaterPipeline(8.0, 3.0, 5.0); 

        // testcase-VT:
//	        pipeline.updatePressure(2.5);  
//	        pipeline.updatePressure(-3.0); 
//	        pipeline.updatePressure(-2.0); 
//	        pipeline.updatePressure(4.0); 
//	        pipeline.updatePressure(3.5);  
        
        // testcase-FT:
//        pipeline.updatePressure(-1.7976931348623157E308);  
//        pipeline.updatePressure(1.1444946573542756E297); 
//        pipeline.updatePressure(8.174961810401071E296); 
//        pipeline.updatePressure(0.0); 
//        pipeline.updatePressure(1.5368928377020603E298);
	        
	        // testcase-Z3:
//	        pipeline.updatePressure(2);  
//	        pipeline.updatePressure(3); 
//	        pipeline.updatePressure(2); 
//	        pipeline.updatePressure(4); 
//	        pipeline.updatePressure(3);  
	        
	        // testcase-VT:
	        pipeline.updatePressure(2.5);  
	        pipeline.updatePressure(-3.0); 
	        pipeline.updatePressure(-2.0); 
	        pipeline.updatePressure(4.0); 
	        pipeline.updatePressure(3.5);  
        
//        pipeline.printLog(); 
    }
}
