package code;

class SmartTreadmill {
    private double currentSpeed;        
    private double incline;              
    private double totalDistance;      
    private double totalCaloriesBurned;  

    public SmartTreadmill(double initialSpeed, double initialIncline) {
        this.currentSpeed = initialSpeed;
        this.incline = initialIncline;
        this.totalDistance = 0.0;
        this.totalCaloriesBurned = 0.0;
    }

    public void updateSpeed(double newSpeed) {
        currentSpeed = newSpeed;
        System.out.printf("Current speed updated to: %.2f km/h\n", currentSpeed);
    }

    public void updateIncline(double newIncline) {
        incline = newIncline;
        System.out.printf("Current incline updated to: %.2f%%\n", incline);
    }

    public void addDistance(double distance) {
        if (distance <= 0) {
            System.out.println("Distance must be positive.");
            return;
        }
        totalDistance += distance;
        double calories = distance * (1.2 * currentSpeed + 0.5 * incline);
        totalCaloriesBurned += calories;
        System.out.printf("Added %.2f km. Total Distance: %.2f km, Calories Burned: %.2f cal\n", distance, totalDistance, totalCaloriesBurned);
    }

    public double getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }
}

public class c71_SmartTreadmillSystem {
    public static void main(String[] args) {
        SmartTreadmill treadmill = new SmartTreadmill(8.0, 5.0);
        
        // testcase-VT:
//        treadmill.addDistance(1.0);    
//        treadmill.updateSpeed(10.0);   
//        treadmill.addDistance(2.0);     
//        treadmill.updateIncline(10.0);   
//        treadmill.addDistance(1.5);
//        treadmill.addDistance(-1.5);
        
        // testcase-FT:
//        treadmill.addDistance(1.7976931348623157E308);    
//        treadmill.addDistance(1.9490628022799995E291);   
//        treadmill.addDistance(6.361740986641919E293);     
//        treadmill.addDistance(1.8287080229312227E302);   
//        treadmill.addDistance(4.1845584833267585E298);
//        treadmill.addDistance(2.9235942034199993E289);
        
     // testcase-Z3:
//        treadmill.addDistance(1.0);    
//        treadmill.updateSpeed(10.0);   
//        treadmill.addDistance(2.0);     
//        treadmill.updateIncline(10.0);   
//        treadmill.addDistance(1.5);
//        treadmill.addDistance(-1.5);
        
     // testcase-UVT:
        treadmill.addDistance(1.0);    
        treadmill.updateSpeed(10.0);   
        treadmill.addDistance(2.0);     
        treadmill.updateIncline(10.0);   
        treadmill.addDistance(1.5);
        treadmill.addDistance(-1.5);
    }
}
