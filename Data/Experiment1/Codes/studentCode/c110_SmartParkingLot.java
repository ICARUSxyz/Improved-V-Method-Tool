package code;

public class c110_SmartParkingLot {

    private int totalSpaces;      
    private int availableSpaces;   
    private int alertThreshold;    
    private boolean fullSignActive; 

    public c110_SmartParkingLot(int totalSpaces, int alertThreshold, int initialAvailableSpaces) {
        this.totalSpaces = totalSpaces;
        this.alertThreshold = alertThreshold;
        this.availableSpaces = initialAvailableSpaces;
        this.fullSignActive = false;
    }

    public void updateAvailableSpaces(int newAvailableSpaces) {
        availableSpaces = newAvailableSpaces;
        adjustParkingStatus();
        System.out.printf("Available Spaces: %d, Full Sign: %s%n",
                availableSpaces, fullSignActive ? "ON" : "OFF");

        if (fullSignActive) {
            System.out.println("ALERT: Parking lot full! No more vehicles allowed.");
        } else if (availableSpaces < alertThreshold) {
            System.out.println("WARNING: Parking lot almost full. Limited spaces available.");
        } else {
            System.out.println("Parking lot has sufficient space.");
        }
    }

    private void adjustParkingStatus() {
        if (availableSpaces == 0) {
            fullSignActive = true;
        } else {
            fullSignActive = false;
        }
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public static void main(String[] args) {
    	c110_SmartParkingLot parkingLot = new c110_SmartParkingLot(100, 10, 50);

        // testcase-VT:
//        parkingLot.updateAvailableSpaces(8);  
//        parkingLot.updateAvailableSpaces(0);   
//        parkingLot.updateAvailableSpaces(15);  
        
        // testcase-FT:
//        parkingLot.updateAvailableSpaces(1280);  
//        parkingLot.updateAvailableSpaces(129);   
//        parkingLot.updateAvailableSpaces(5);  
    	
        // testcase-Z3:
//        parkingLot.updateAvailableSpaces(8);  
//        parkingLot.updateAvailableSpaces(0);   
//        parkingLot.updateAvailableSpaces(15);  
        
        // testcase-UVT:
        parkingLot.updateAvailableSpaces(8);  
        parkingLot.updateAvailableSpaces(0);   
        parkingLot.updateAvailableSpaces(15);  
    }
}
