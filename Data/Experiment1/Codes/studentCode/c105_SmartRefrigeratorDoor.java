package code;

public class c105_SmartRefrigeratorDoor {

    private double maxOpenTime;   
    private double currentOpenTime; 

    public c105_SmartRefrigeratorDoor(double maxOpenTime) {
        this.maxOpenTime = maxOpenTime;
        this.currentOpenTime = 0.0;
    }
    

    public void updateDoorOpenTime(double newOpenTime) {
        currentOpenTime = newOpenTime;
        System.out.printf("Current Door Open Time: %.2f seconds%n", currentOpenTime);
        if (currentOpenTime > maxOpenTime) {
            System.out.println("ALERT: Door has been open too long! Please close the door to save energy.");
        } else {
            System.out.println("Door open time is within safe limits.");
        }
    }

    public double getCurrentOpenTime() {
        return currentOpenTime;
    }

    public static void main(String[] args) {
    	c105_SmartRefrigeratorDoor doorMonitor = new c105_SmartRefrigeratorDoor(30.0);

        // testcase-VT:
//        doorMonitor.updateDoorOpenTime(20.0);  
//        doorMonitor.updateDoorOpenTime(35.0); 
//        doorMonitor.updateDoorOpenTime(25.0);  
        
        // testcase-FT:
//        doorMonitor.updateDoorOpenTime(1.6349922841177022E296);  
//        doorMonitor.updateDoorOpenTime(-1.7976931344437577E308); 
//        doorMonitor.updateDoorOpenTime(1.9490628022799996E289);  
        
        // testcase-Z3:
//        doorMonitor.updateDoorOpenTime(20.0);  
//        doorMonitor.updateDoorOpenTime(35.0); 
//        doorMonitor.updateDoorOpenTime(25.0);  
        
        // testcase-UVT:
        doorMonitor.updateDoorOpenTime(20.0);  
        doorMonitor.updateDoorOpenTime(35.0); 
        doorMonitor.updateDoorOpenTime(25.0);  
    }
}
