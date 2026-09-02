package code;

import java.util.*;

class IrrigationSystem {
    private double moistureThreshold;
    private double maxWaterPerSession;
    private Map<String, Double> cropWaterNeeds;
    private List<String> irrigationLog;

    public IrrigationSystem(double moistureThreshold, double maxWaterPerSession) {
        this.moistureThreshold = moistureThreshold;
        this.maxWaterPerSession = maxWaterPerSession;
        this.irrigationLog = new ArrayList<>();

        this.cropWaterNeeds = new HashMap<>();
        cropWaterNeeds.put("Wheat", 10.0);
        cropWaterNeeds.put("Corn", 15.0);
        cropWaterNeeds.put("Rice", 20.0);
    }

    public void irrigateField(String cropType, double currentMoisture, double temperature) {
        if (!cropWaterNeeds.containsKey(cropType)) {
            System.out.printf("Error: Unknown crop type '%s'.%n", cropType);
            return;
        }

        if (currentMoisture >= moistureThreshold) {
            System.out.printf("Moisture level sufficient (%.1f%%). No irrigation needed.%n", currentMoisture);
            irrigationLog.add(String.format("Irrigation Skipped: Crop = %s, Moisture = %.1f%%", cropType, currentMoisture));
            return;
        }

        double baseWaterNeed = cropWaterNeeds.get(cropType);
        double adjustedWater = baseWaterNeed * (1 + (temperature - 25) * 0.02); 
        double waterToApply = Math.min(adjustedWater, maxWaterPerSession);

        System.out.printf("Irrigating %s field: Applying %.1f liters of water.%n", cropType, waterToApply);
        irrigationLog.add(String.format("Irrigation Applied: Crop = %s, Water = %.1f L, Moisture = %.1f%%", 
                                        cropType, waterToApply, currentMoisture));
    }

    public void printIrrigationLog() {
        System.out.println("\nIrrigation Log:");
        for (String log : irrigationLog) {
            System.out.println(log);
        }
    }
}

public class c23_SmartIrrigationSystem {
    public static void main(String[] args) {
        IrrigationSystem system = new IrrigationSystem(40.0, 25.0); 

        // testcase-VT:
//        system.irrigateField("Wheat", 35.0, 30.0); 
//        system.irrigateField("Corn", 45.0, 28.0);  
//        system.irrigateField("Rice", 25.0, 35.0);  
//        system.irrigateField("Soybean", 30.0, 32.0); 
        
        // testcase-FT:
//        system.irrigateField("??", -1.7976931348623157E308, -1.7976931348623157E308); 
//        system.irrigateField("", -1.12091454291415E308, -1.12091454291415E308);  
//        system.irrigateField("'&'", 5.005341669616643E307, 5.005341669616643E307);  
//        system.irrigateField("GGGGW", -1.374706514894712E308, -1.7976931348623157E308); 

        // testcase-Z3:
//        system.irrigateField("Wheat", 35, 30); 
//        system.irrigateField("Corn", 45, 28);  
//        system.irrigateField("Rice", 25, 35);  
//        system.irrigateField("Soybean", 30, 32); 
        
        // testcase-UVT:
        system.irrigateField("Wheat", 35.0, 30.0); 
        system.irrigateField("Corn", 45.0, 28.0);  
        system.irrigateField("Rice", 25.0, 35.0);  
        system.irrigateField("Soybean", 30.0, 32.0); 
        system.printIrrigationLog(); 
    }
}
