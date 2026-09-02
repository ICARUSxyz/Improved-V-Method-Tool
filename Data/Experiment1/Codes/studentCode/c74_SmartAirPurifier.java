package code;

public class c74_SmartAirPurifier {

    private double pm25;                     
    private double fanSpeed;             
    private double minFanSpeed;         
    private double maxFanSpeed;           
    private double filterUsageHours;        
    private double filterReplacementThreshold; 

    public c74_SmartAirPurifier(double initialPM25, double minFanSpeed, double maxFanSpeed, 
                            double initialFilterUsage, double filterReplacementThreshold) {
        this.pm25 = initialPM25;
        this.minFanSpeed = minFanSpeed;
        this.maxFanSpeed = maxFanSpeed;
        this.filterUsageHours = initialFilterUsage;
        this.filterReplacementThreshold = filterReplacementThreshold;
    }

    public void updateAirQuality(double newPM25) {
        pm25 = newPM25;
        adjustFanSpeed();
        System.out.printf("Updated PM2.5: %.2f µg/m³, Fan Speed: %.2f%%\n", pm25, fanSpeed);
        if (filterUsageHours >= filterReplacementThreshold) {
            System.out.println("ALERT: Filter replacement needed.");
        }
    }

    private void adjustFanSpeed() {
        if (pm25 > 75) {
            fanSpeed = maxFanSpeed; 
        } else if (pm25 < 35) {
            fanSpeed = minFanSpeed; 
        } else {
            fanSpeed = minFanSpeed + (maxFanSpeed - minFanSpeed) * ((pm25 - 35) / (75 - 35));
        }
    }

    public void updateFilterUsage(double additionalHours) {
        if (additionalHours < 0) {
            System.out.println("Invalid usage time. Must be positive.");
            return;
        }
        filterUsageHours += additionalHours;
        System.out.printf("Updated Filter Usage: %.2f hours\n", filterUsageHours);
        if (filterUsageHours >= filterReplacementThreshold) {
            System.out.println("ALERT: Filter replacement needed.");
        }
    }
    
    public double getFanSpeed() {
        return fanSpeed;
    }

    public double getFilterUsageHours() {
        return filterUsageHours;
    }

    public static void main(String[] args) {
    	c74_SmartAirPurifier purifier = new c74_SmartAirPurifier(50.0, 20.0, 100.0, 100.0, 500.0);
        
        // testcase-VT:
//        purifier.updateAirQuality(80.0);  
//        purifier.updateAirQuality(30.0);  
//        purifier.updateAirQuality(55.0);
//        purifier.updateFilterUsage(200.0); 
//        purifier.updateFilterUsage(250.0);
//        purifier.updateFilterUsage(-2.0);
//        purifier.updateFilterUsage(550.0);
//        purifier.updateAirQuality(55.0);
        
        // testcase-FT:
//        purifier.updateAirQuality(1.6425793966244292E308);  
//        purifier.updateAirQuality(-1.7976931348623157E308);  
//        purifier.updateAirQuality(1.9490628022799996E289);
//        purifier.updateAirQuality(-1.5861998248785138E308); 
//        purifier.updateAirQuality(0.0);
//        purifier.updateAirQuality(3.511119404027329E306);
//        purifier.updateAirQuality(1.3465074068968717E308);
//        purifier.updateAirQuality(9.063142030601998E290);
    	
    	// testcase-Z3:
//        purifier.updateAirQuality(80.0);  
//        purifier.updateAirQuality(30.0);  
//        purifier.updateAirQuality(55.0);
//        purifier.updateFilterUsage(200.0); 
//        purifier.updateFilterUsage(250.0);
//        purifier.updateFilterUsage(-2.0);
//        purifier.updateFilterUsage(550.0);
//        purifier.updateAirQuality(55.0);
        
     // testcase-UVT:
        purifier.updateAirQuality(80.0);  
        purifier.updateAirQuality(30.0);  
        purifier.updateAirQuality(55.0);
        purifier.updateFilterUsage(200.0); 
        purifier.updateFilterUsage(250.0);
        purifier.updateFilterUsage(-2.0);
        purifier.updateFilterUsage(550.0);
        purifier.updateAirQuality(55.0);
    }
}

