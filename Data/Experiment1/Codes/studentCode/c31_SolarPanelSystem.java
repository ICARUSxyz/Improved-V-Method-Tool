package code;

import java.util.*;

class SolarPanel {
    private double maxVoltage;
    private double minVoltage;
    private double currentVoltage;
    private List<String> voltageLog;

    public SolarPanel(double maxVoltage, double minVoltage, double initialVoltage) {
        this.maxVoltage = maxVoltage;
        this.minVoltage = minVoltage;
        this.currentVoltage = initialVoltage;
        this.voltageLog = new ArrayList<>();
    }

    public void updateVoltage(double changeAmount) {
        currentVoltage += changeAmount;

        String message = String.format("Current Voltage: %.2f V", currentVoltage);
        if (currentVoltage > maxVoltage) {
            message += " | WARNING: Overvoltage Detected! Risk of Electrical Damage.";
        } else if (currentVoltage < minVoltage) {
            message += " | ALERT: Low Voltage! Possible Fault or Shading Issue.";
        }

        System.out.println(message);
        voltageLog.add(message);
    }

    public void printVoltageLog() {
        System.out.println("\nVoltage Log:");
        for (String log : voltageLog) {
            System.out.println(log);
        }
    }
}

public class c31_SolarPanelSystem {
    public static void main(String[] args) {
        SolarPanel panel = new SolarPanel(50.0, 20.0, 35.0); 

        // testcase-VT:
//        panel.updateVoltage(10.0);  
//        panel.updateVoltage(-15.0); 
//        panel.updateVoltage(-12.0); 
//        panel.updateVoltage(8.0); 
//        panel.updateVoltage(87.0); 
//        panel.updateVoltage(30.0); 
//        panel.printVoltageLog();
        
        // testcase-FT:
//        panel.updateVoltage(1.7976930277114552E308);
//        panel.updateVoltage(-1.7976931348623157E308);
//        panel.updateVoltage(0.0);
//        panel.updateVoltage(-1.2971589679006513E308);
//        panel.updateVoltage(4.0183728896922353E307);
//        panel.updateVoltage(1.1596923673565998E291);
//        panel.printVoltageLog(); 
        
        // testcase-Z3:
//	      panel.updateVoltage(10.0);  
//	      panel.updateVoltage(15.0); 
//	      panel.updateVoltage(0); 
//	      panel.updateVoltage(8.0); 
//	      panel.updateVoltage(87.0); 
//	      panel.updateVoltage(30.0); 
//	      panel.printVoltageLog();
        
        // testcase-UVT:
	      panel.updateVoltage(10);  
	      panel.updateVoltage(15); 
	      panel.updateVoltage(12); 
	      panel.updateVoltage(8); 
	      panel.updateVoltage(87); 
	      panel.updateVoltage(30); 
//	      panel.printVoltageLog();
    }
}

