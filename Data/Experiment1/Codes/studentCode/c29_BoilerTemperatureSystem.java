package code;

import java.util.*;

class Boiler {
    private double maxTemp;
    private double minTemp;
    private double currentTemp;
    private List<String> tempLog;

    public Boiler(double maxTemp, double minTemp, double initialTemp) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currentTemp = initialTemp;
        this.tempLog = new ArrayList<>();
    }

    public void updateTemperature(double changeAmount) {
        currentTemp += changeAmount;

        String message = String.format("Current Temperature: %.1f°C", currentTemp);
        if (currentTemp > maxTemp) {
            message += " | WARNING: Overheat Detected!";
        } else if (currentTemp < minTemp) {
            message += " | ALERT: Temperature Too Low! Activating Heating System.";
        }

        System.out.println(message);
        tempLog.add(message);
    }

    public void printTempLog() {
        System.out.println("\nTemperature Log:");
        for (String log : tempLog) {
            System.out.println(log);
        }
    }
}

public class c29_BoilerTemperatureSystem {
    public static void main(String[] args) {
        Boiler boiler = new Boiler(100.0, 50.0, 70.0); 

        // tasecase-VT:
//        boiler.updateTemperature(20.0); 
//        boiler.updateTemperature(-30.0); 
//        boiler.updateTemperature(-20.0); 
//        boiler.updateTemperature(50.0);
//        boiler.updateTemperature(15.0);

        // tasecase-FT:
//        boiler.updateTemperature(-1.7976931348614471E308); 
//        boiler.updateTemperature(2.7430620343943882E303); 
//        boiler.updateTemperature(2.5421930713382118E303); 
//        boiler.updateTemperature(1.6029092485950715E293);
//        boiler.updateTemperature(4.103512970007259E295);
        
        // tasecase-Z3:
//        boiler.updateTemperature(20); 
//        boiler.updateTemperature(30); 
//        boiler.updateTemperature(20); 
//        boiler.updateTemperature(50);
//        boiler.updateTemperature(15);
        
        // tasecase-UVT:
        boiler.updateTemperature(20.0); 
        boiler.updateTemperature(30.0); 
        boiler.updateTemperature(20.0); 
        boiler.updateTemperature(50.0);
        boiler.updateTemperature(15.0);
        
        boiler.printTempLog(); 
    }
}
