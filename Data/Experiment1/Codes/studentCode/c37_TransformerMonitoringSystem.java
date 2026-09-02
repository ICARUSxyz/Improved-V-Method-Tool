package code;

import java.util.*;

class Transformer {
    private double maxCurrent;
    private double minCurrent;
    private double currentLoad;
    private List<String> log;

    public Transformer(double maxCurrent, double minCurrent, double initialLoad) {
        this.maxCurrent = maxCurrent;
        this.minCurrent = minCurrent;
        this.currentLoad = initialLoad;
        this.log = new ArrayList<>();
    }

    public void updateCurrent(double changeAmount) {
        currentLoad += changeAmount;

        String message = String.format("Current Load: %.2f A", currentLoad);
        if (currentLoad > maxCurrent) {
            message += " | WARNING: Overload Detected! Risk of Transformer Damage.";
        } else if (currentLoad < minCurrent) {
            message += " | ALERT: Underload Detected! Possible Fault or Disconnection.";
        }

        System.out.println(message);
        log.add(message);
    }

    public void printLog() {
        System.out.println("\nTransformer Load Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c37_TransformerMonitoringSystem {
    public static void main(String[] args) {
        Transformer transformer = new Transformer(200.0, 50.0, 100.0); 

        // testcase-VT:
//        transformer.updateCurrent(80.0);  
//        transformer.updateCurrent(-60.0); 
//        transformer.updateCurrent(-80.0); 
//        transformer.updateCurrent(90.0); 
//        transformer.updateCurrent(90.0);  
//        transformer.printLog(); 
//  
        // testcase-FT:
//        transformer.updateCurrent(4.185580495846825E298);
//        transformer.updateCurrent(1.7976931348623157E308);
//        transformer.updateCurrent(-1.7976931348623157E308);
//        transformer.updateCurrent(-4.9E-324);
//        transformer.updateCurrent(-1.7976931348623157E308);
//        transformer.printLog();
        
        // testcase-Z3:
//        transformer.updateCurrent(8);  
//        transformer.updateCurrent(6); 
//        transformer.updateCurrent(8); 
//        transformer.updateCurrent(9); 
//        transformer.updateCurrent(10);  
//        transformer.printLog(); 
        
        // testcase-UVT:
        transformer.updateCurrent(80);  
        transformer.updateCurrent(-60); 
        transformer.updateCurrent(80); 
        transformer.updateCurrent(90); 
        transformer.updateCurrent(90);  
//        transformer.printLog(); 
    }
}

