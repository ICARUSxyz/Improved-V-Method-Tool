package code;

import java.util.*;

class Battery {
    private double maxCharge;
    private double minCharge;
    private double currentCharge;
    private List<String> chargeLog;

    public Battery(double maxCharge, double minCharge, double initialCharge) {
        this.maxCharge = maxCharge;
        this.minCharge = minCharge;
        this.currentCharge = initialCharge;
        this.chargeLog = new ArrayList<>();
    }

    public void updateCharge(double changeAmount) {
        currentCharge += changeAmount;

        String message = String.format("Current Charge Level: %.1f%%", currentCharge);
        if (currentCharge > maxCharge) {
            message += " | WARNING: Overcharge Detected! Stop Charging Immediately.";
        } else if (currentCharge < minCharge) {
            message += " | ALERT: Low Battery! Immediate Charging Recommended.";
        }

        System.out.println(message);
        chargeLog.add(message);
    }

    public void printChargeLog() {
        System.out.println("\nBattery Charge Log:");
        for (String log : chargeLog) {
            System.out.println(log);
        }
    }
}

public class c34_BatteryManagementSystem {
    public static void main(String[] args) {
        Battery battery = new Battery(100.0, 20.0, 50.0); 

        // testcase-VT:
//        battery.updateCharge(30.0);  
//        battery.updateCharge(-40.0); 
//        battery.updateCharge(-25.0); 
//        battery.updateCharge(60.0);  
//        battery.updateCharge(35.0);  
        
        // testcase-FT:
//        battery.updateCharge(-1.7976931348623157E308);  
//        battery.updateCharge(1.7976931348623157E308); 
//        battery.updateCharge(2.0444353298434178E307); 
//        battery.updateCharge(0);  
//        battery.updateCharge(-4.9E-324); 
        
        // testcase-VT:
//      battery.updateCharge(3.0);  
//      battery.updateCharge(4.0); 
//      battery.updateCharge(2.0); 
//      battery.updateCharge(6.0);  
//      battery.updateCharge(3.0);  
//        
        // testcase-VT:
      battery.updateCharge(3);  
      battery.updateCharge(-4); 
      battery.updateCharge(-2); 
      battery.updateCharge(600);  
      battery.updateCharge(3);  
        
//        battery.printChargeLog(); 
    }
}
