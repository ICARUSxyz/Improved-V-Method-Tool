package code;

public class c96_SmartElevator {

    private double maxLoadCapacity;  
    private double currentLoad;     

    public c96_SmartElevator(double maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
        this.currentLoad = 0.0;
    }

    public void updateLoad(double newLoad) {
        currentLoad = newLoad;
        System.out.printf("Current Load: %.2f kg%n", currentLoad);
        
        if (currentLoad > maxLoadCapacity) {
            System.out.println("ALERT: Overload detected! Elevator cannot operate.");
        } else {
            System.out.println("Elevator operating normally.");
        }
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public static void main(String[] args) {
    	c96_SmartElevator elevator = new c96_SmartElevator(800.0);

        // testcase-VT:
//        elevator.updateLoad(750.0);  
//        elevator.updateLoad(850.0);  
//        elevator.updateLoad(800.0); 
        
        // testcase-FT:
//        elevator.updateLoad(-1.7836486571137695E308);  
//        elevator.updateLoad(-1.2359056723264467E308);  
//        elevator.updateLoad(-1.193771596563137E308); 
    	
        // testcase-Z3:
//        elevator.updateLoad(750.0);  
//        elevator.updateLoad(850.0);  
//        elevator.updateLoad(800.0); 
        
        // testcase-UVT:
        elevator.updateLoad(750.0);  
        elevator.updateLoad(850.0);  
        elevator.updateLoad(800.0); 
    }
}
