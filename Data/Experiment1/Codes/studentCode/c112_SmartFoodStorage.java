package code;

public class c112_SmartFoodStorage {

    private double minHumidity;      
    private double maxHumidity;      
    private double currentHumidity;  
    private boolean humidifierActive;   
    private boolean dehumidifierActive; 

    public c112_SmartFoodStorage(double minHumidity, double maxHumidity, double initialHumidity) {
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
                currentHumidity, humidifierActive ? "ON" : "OFF", dehumidifierActive ? "ON" : "OFF");

        if (humidifierActive) {
            System.out.println("Humidifier activated to increase humidity.");
        } else if (dehumidifierActive) {
            System.out.println("Dehumidifier activated to reduce humidity.");
        } else {
            System.out.println("Humidity is within the optimal range.");
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
    	c112_SmartFoodStorage storage = new c112_SmartFoodStorage(50.0, 80.0, 65.0);

        // testcase-VT:
//        storage.updateHumidity(45.0); 
//        storage.updateHumidity(75.0); 
//        storage.updateHumidity(85.0); 
        
        // testcase-FT:
//        storage.updateHumidity(-1.7976931344689044E308); 
//        storage.updateHumidity(1.552019316280681E296); 
//        storage.updateHumidity(1.3800241718403422E294); 
    	
        // testcase-Z3:
//        storage.updateHumidity(45.0); 
//        storage.updateHumidity(75.0); 
//        storage.updateHumidity(85.0); 
        
        // testcase-UVT:
        storage.updateHumidity(45.0); 
        storage.updateHumidity(75.0); 
        storage.updateHumidity(85.0); 
    }
}
