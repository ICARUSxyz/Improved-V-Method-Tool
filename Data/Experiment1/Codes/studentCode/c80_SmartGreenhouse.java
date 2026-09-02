package code;

public class c80_SmartGreenhouse {

    private double minHumidity;  
    private double maxHumidity;  
    private double currentHumidity;  
    private boolean humidifierActive;  
    private boolean dehumidifierActive; 

    public c80_SmartGreenhouse(double minHumidity, double maxHumidity, double initialHumidity) {
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
        this.currentHumidity = initialHumidity;
        this.humidifierActive = false;
        this.dehumidifierActive = false;
    }

    public void updateHumidity(double newHumidity) {
        currentHumidity = newHumidity;
        adjustHumidityControl();
        System.out.printf("Current Humidity: %.2f%%, Humidifier: %s, Dehumidifier: %s%n",
                currentHumidity,
                humidifierActive ? "ON" : "OFF",
                dehumidifierActive ? "ON" : "OFF");

        if (humidifierActive) {
            System.out.println("ALERT: Low humidity detected. Humidifier activated.");
        } else if (dehumidifierActive) {
            System.out.println("ALERT: High humidity detected. Dehumidifier activated.");
        } else {
            System.out.println("Humidity is optimal. No action needed.");
        }
    }

    private void adjustHumidityControl() {
        if (currentHumidity < minHumidity) {
            humidifierActive = true;
            dehumidifierActive = false;
        } else if (currentHumidity > maxHumidity) {
            humidifierActive = false;
            dehumidifierActive = true;
        } else {
            humidifierActive = false;
            dehumidifierActive = false;
        }
    }

    public double getCurrentHumidity() {
        return currentHumidity;
    }

    public static void main(String[] args) {
    	c80_SmartGreenhouse greenhouse = new c80_SmartGreenhouse(40.0, 70.0, 50.0);

        // testcase-VT:
//        greenhouse.updateHumidity(35.0);  
//        greenhouse.updateHumidity(75.0);  
//        greenhouse.updateHumidity(60.0);
        
        // testcase-FT:
//        greenhouse.updateHumidity(-1.6284984868752742E308);  
//        greenhouse.updateHumidity(-1.7976931348623157E308);  
//        greenhouse.updateHumidity(2.3264264098218203E307);
        
        // testcase-Z3:
//        greenhouse.updateHumidity(35.0);  
//        greenhouse.updateHumidity(75.0);  
//        greenhouse.updateHumidity(60.0);
        
        // testcase-UVT:
        greenhouse.updateHumidity(35.0);  
        greenhouse.updateHumidity(75.0);  
        greenhouse.updateHumidity(60.0);
    }
}
