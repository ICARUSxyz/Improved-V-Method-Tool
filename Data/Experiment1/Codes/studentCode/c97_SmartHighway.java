package code;

public class c97_SmartHighway {

    private double maxTrafficDensity;  
    private double currentTrafficDensity;  
    private int normalSpeedLimit;  
    private int reducedSpeedLimit;
    private int currentSpeedLimit; 

    public c97_SmartHighway(double maxTrafficDensity, int normalSpeedLimit, int reducedSpeedLimit) {
        this.maxTrafficDensity = maxTrafficDensity;
        this.normalSpeedLimit = normalSpeedLimit;
        this.reducedSpeedLimit = reducedSpeedLimit;
        this.currentTrafficDensity = 0.0;
        this.currentSpeedLimit = normalSpeedLimit;
    }

    public void updateTrafficDensity(double newTrafficDensity) {
        currentTrafficDensity = newTrafficDensity;
        adjustSpeedLimit();
        System.out.printf("Current Traffic Density: %.2f vehicles/km, Speed Limit: %d km/h%n",
                currentTrafficDensity, currentSpeedLimit);

        if (currentTrafficDensity > maxTrafficDensity) {
            System.out.println("ALERT: High traffic detected. Speed limit reduced.");
        } else {
            System.out.println("Traffic conditions normal. Speed limit unchanged.");
        }
    }

    private void adjustSpeedLimit() {
        if (currentTrafficDensity > maxTrafficDensity) {
            currentSpeedLimit = reducedSpeedLimit;
        } else {
            currentSpeedLimit = normalSpeedLimit;
        }
    }

    public int getCurrentSpeedLimit() {
        return currentSpeedLimit;
    }

    public static void main(String[] args) {
    	c97_SmartHighway highway = new c97_SmartHighway(50.0, 120, 80);

        // testcase-VT:
//        highway.updateTrafficDensity(30.0);  
//        highway.updateTrafficDensity(60.0);  
//        highway.updateTrafficDensity(45.0);  
        
        // testcase-FT:
//        highway.updateTrafficDensity(0.0);  
//        highway.updateTrafficDensity(9.063142030601998E290);  
//        highway.updateTrafficDensity(-1.7976931348623157E308);
        
        // testcase-Z3:
//        highway.updateTrafficDensity(30.0);  
//        highway.updateTrafficDensity(60.0);  
//        highway.updateTrafficDensity(45.0);  
        
        // testcase-UVT:
        highway.updateTrafficDensity(30.0);  
        highway.updateTrafficDensity(60.0);  
        highway.updateTrafficDensity(45.0);  
    }
}
