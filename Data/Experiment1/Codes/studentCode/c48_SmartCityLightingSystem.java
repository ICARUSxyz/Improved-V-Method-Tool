package code;

import java.util.*;

class SmartStreetlight {
    private double maxBrightness;
    private double minBrightness;
    private double currentBrightness;
    private boolean motionDetected;
    private double ambientLight; 
    private List<String> log;

    public SmartStreetlight(double maxBrightness, double minBrightness, double initialBrightness, double ambientLight) {
        this.maxBrightness = maxBrightness;
        this.minBrightness = minBrightness;
        this.currentBrightness = initialBrightness;
        this.ambientLight = ambientLight;
        this.motionDetected = false;
        this.log = new ArrayList<>();
    }

    public void updateAmbientLight(double newLightLevel) {
        ambientLight = newLightLevel;
        adjustBrightness();
    }

    public void detectMotion(boolean isMotionDetected) {
        motionDetected = isMotionDetected;
        adjustBrightness();
    }

    private void adjustBrightness() {
        if (ambientLight > 500) {
            currentBrightness = minBrightness;
        } else if (motionDetected) { 
            currentBrightness = maxBrightness;
        } else { 
            currentBrightness = minBrightness * 2;
        }

        String message = String.format("Brightness Adjusted: %.2f%% | Ambient Light: %.2f lux | Motion Detected: %b",
                                        currentBrightness, ambientLight, motionDetected);
        System.out.println(message);
        log.add(message);
    }

    public void printLog() {
        System.out.println("\nStreetlight Adjustment Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c48_SmartCityLightingSystem {
    public static void main(String[] args) {
        SmartStreetlight streetlight = new SmartStreetlight(100.0, 10.0, 50.0, 200.0);  

        // testcase-VT:
//        streetlight.updateAmbientLight(600.0);  
//        streetlight.updateAmbientLight(100.0);  
//        streetlight.detectMotion(true);        
//        streetlight.detectMotion(false);       
//        streetlight.updateAmbientLight(700.0); 
//        streetlight.printLog();      
        
        // testcase-FT:
//        streetlight.updateAmbientLight(7.521898124600501E300);  
//        streetlight.detectMotion(false);   
//        streetlight.updateAmbientLight(0.0); 
//        streetlight.detectMotion(false);       
//        streetlight.updateAmbientLight(-1.7976931348623157E308); 
//        streetlight.printLog(); 
        
        // testcase-Z3:
//        streetlight.updateAmbientLight(600);  
//        streetlight.updateAmbientLight(100);  
//        streetlight.detectMotion(true);        
//        streetlight.detectMotion(false);       
//        streetlight.updateAmbientLight(700); 
//        streetlight.printLog();   

        // testcase-UVT:
        streetlight.updateAmbientLight(600.0);  
        streetlight.updateAmbientLight(100.0);  
        streetlight.detectMotion(true);        
        streetlight.detectMotion(false);       
        streetlight.updateAmbientLight(700.0); 
        streetlight.printLog();    
    }
}
