package code;

import java.util.*;

class SmartPowerGrid {
    private double maxLoad;
    private double minLoad;
    private double currentLoad;
    private boolean powerSavingMode;
    private List<String> log;

    public SmartPowerGrid(double maxLoad, double minLoad, double initialLoad) {
        this.maxLoad = maxLoad;
        this.minLoad = minLoad;
        this.currentLoad = initialLoad;
        this.powerSavingMode = false;
        this.log = new ArrayList<>();
    }

    public void updateLoad(double changeAmount) {
        currentLoad += changeAmount;
        manageLoadBalancing();

        String message = String.format("Current Power Load: %.2f MW", currentLoad);
        if (currentLoad > maxLoad) {
            message += " | WARNING: Overload Risk! Activating Power-Saving Measures.";
        } else if (currentLoad < minLoad) {
            message += " | INFO: Low Demand! Storing Surplus Energy.";
        } else {
            message += " | Load is Balanced.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageLoadBalancing() {
        if (currentLoad > maxLoad) {
            powerSavingMode = true;
        } else {
            powerSavingMode = false;
        }
    }

    public void printLog() {
        System.out.println("\nPower Grid Load Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c54_SmartGridSystem {
    public static void main(String[] args) {
        SmartPowerGrid grid = new SmartPowerGrid(500.0, 100.0, 300.0); 

        // testcase-VT:
//        grid.updateLoad(150.0);   
//        grid.updateLoad(-200.0);  
//        grid.updateLoad(-180.0);
//        grid.updateLoad(250.0);  
//        grid.updateLoad(250.0);  
//        grid.printLog(); 
        
        // testcase-FT:
//        grid.updateLoad(1.6279547056043695E293);   
//        grid.updateLoad(1.4533186785200817E293);  
//        grid.updateLoad(0.0);
//        grid.updateLoad(-1.7976931348623157E308);  
//        grid.updateLoad(3.898125604559999E289);  
//        grid.printLog(); 
        
        // testcase-Z3:
//        grid.updateLoad(150);   
//        grid.updateLoad(-200);  
//        grid.updateLoad(-180);
//        grid.updateLoad(250);  
//        grid.updateLoad(250);  
//        grid.printLog(); 
        
        // testcase-UVT:
        grid.updateLoad(150.0);   
        grid.updateLoad(-200.0);  
        grid.updateLoad(-180.0);
        grid.updateLoad(250.0);  
        grid.updateLoad(250.0);  
        grid.printLog(); 
    }
}
