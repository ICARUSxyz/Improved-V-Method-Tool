package code;

import java.util.*;

class WarehouseEnvironment {
    private double maxTemperature;
    private double minTemperature;
    private double maxHumidity;
    private double minHumidity;
    private double currentTemperature;
    private double currentHumidity;
    private boolean coolingActive;
    private boolean dehumidifierActive;
    private List<String> log;

    public WarehouseEnvironment(double maxTemperature, double minTemperature, double maxHumidity, double minHumidity, double initialTemperature, double initialHumidity) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.maxHumidity = maxHumidity;
        this.minHumidity = minHumidity;
        this.currentTemperature = initialTemperature;
        this.currentHumidity = initialHumidity;
        this.coolingActive = false;
        this.dehumidifierActive = false;
        this.log = new ArrayList<>();
    }

    public void updateEnvironment(double tempChange, double humidityChange) {
        currentTemperature += tempChange;
        currentHumidity += humidityChange;
        manageClimateControl();

        String message = String.format("Current Temp: %.2f°C | Humidity: %.2f%%", currentTemperature, currentHumidity);
        if (currentTemperature > maxTemperature) {
            message += " | WARNING: Overheating! Cooling System Activated.";
        } else if (currentTemperature < minTemperature) {
            message += " | ALERT: Too Cold! Adjusting Heating System.";
        }

        if (currentHumidity > maxHumidity) {
            message += " | WARNING: High Humidity! Dehumidifier Activated.";
        } else if (currentHumidity < minHumidity) {
            message += " | ALERT: Low Humidity! Adjusting Humidification System.";
        }

        System.out.println(message);
        log.add(message);
    }

    private void manageClimateControl() {
        coolingActive = currentTemperature > maxTemperature;
        dehumidifierActive = currentHumidity > maxHumidity;
    }

    public void printLog() {
        System.out.println("\nWarehouse Environment Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c51_SmartWarehouseSystem {
    public static void main(String[] args) {
        WarehouseEnvironment warehouse = new WarehouseEnvironment(30.0, 5.0, 70.0, 30.0, 20.0, 50.0);

        // testcase-VT:
//        warehouse.updateEnvironment(8.0, 10.0);  
//        warehouse.updateEnvironment(5.0, 20.0);  
//        warehouse.updateEnvironment(-10.0, -15.0); 
//        warehouse.updateEnvironment(-20.0, -30.0); 
//        warehouse.updateEnvironment(-20.0, -30.0); 
//        warehouse.updateEnvironment(-20.0, -70.0); 
//        warehouse.printLog(); 
        
        // testcase-FT:
//        warehouse.updateEnvironment(0.0, 0.0);  
//        warehouse.updateEnvironment(-1.0582717256057185E308, 0.0);  
//        warehouse.updateEnvironment(-1.7836486571955191E308, 0.0); 
//        warehouse.updateEnvironment(0.0, -1.0582717256057185E308); 
//        warehouse.updateEnvironment(0.0, -1.7836486571955191E308); 
//        warehouse.updateEnvironment(1.5448925437890742E307, -1.797654840028587E308); 
//        warehouse.printLog(); 
        
        // testcase-Z3:
//        warehouse.updateEnvironment(8, 10);  
//        warehouse.updateEnvironment(5, 20);  
//        warehouse.updateEnvironment(-10, -15); 
//        warehouse.updateEnvironment(-20, -30); 
//        warehouse.updateEnvironment(-20, -30); 
//        warehouse.updateEnvironment(-20, -70); 
//        warehouse.printLog(); 
        
        // testcase-UVT:
        warehouse.updateEnvironment(8.0, 10.0);  
        warehouse.updateEnvironment(5.0, 20.0);  
        warehouse.updateEnvironment(-10.0, -15.0); 
        warehouse.updateEnvironment(-20.0, -30.0); 
        warehouse.updateEnvironment(-20.0, -30.0); 
        warehouse.updateEnvironment(-20.0, -70.0); 
        warehouse.printLog(); 
    }
}
