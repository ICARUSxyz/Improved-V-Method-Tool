package code;

import java.util.*;

class Elevator45 {
    private String id;
    private int maxCapacity;
    private int currentLoad;
    private int currentFloor;
    private List<String> log;

    public Elevator45(String id, int maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentLoad = 0;
        this.currentFloor = 1; 
        this.log = new ArrayList<>();
    }

    public boolean enterElevator(int numPassengers) {
        if (currentLoad + numPassengers > maxCapacity) {
            System.out.printf("Elevator %s Overloaded! Redirecting Passengers.%n", id);
            log.add("Overload Warning: Redirecting passengers.");
            return false;
        }

        currentLoad += numPassengers;
        System.out.printf("Elevator %s: %d Passengers Entered | Current Load: %d/%d%n", id, numPassengers, currentLoad, maxCapacity);
        log.add(String.format("Passengers Entered: %d | Load: %d/%d", numPassengers, currentLoad, maxCapacity));
        return true;
    }

    public void exitElevator(int numPassengers) {
        currentLoad = Math.max(0, currentLoad - numPassengers);
        System.out.printf("Elevator %s: %d Passengers Exited | Remaining Load: %d/%d%n", id, numPassengers, currentLoad, maxCapacity);
        log.add(String.format("Passengers Exited: %d | Load: %d/%d", numPassengers, currentLoad, maxCapacity));
    }

    public void moveElevator(int targetFloor) {
        if (targetFloor == currentFloor) {
            System.out.printf("Elevator %s is already on Floor %d.%n", id, targetFloor);
            return;
        }

        System.out.printf("Elevator %s Moving: Floor %d → Floor %d%n", id, currentFloor, targetFloor);
        log.add(String.format("Moved from Floor %d to Floor %d", currentFloor, targetFloor));
        currentFloor = targetFloor;
    }

    public void printLog() {
        System.out.printf("\nElevator %s Operation Log:%n", id);
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c45_SmartElevatorSystem {
    public static void main(String[] args) {
        Elevator45 elevatorA = new Elevator45("A", 10);

        // testcase-VT:
//        elevatorA.enterElevator(5);  
//        elevatorA.enterElevator(7);   
//        elevatorA.moveElevator(5); 
//        elevatorA.exitElevator(3);  
//        elevatorA.moveElevator(1); 
//        elevatorA.moveElevator(1); 
        
        // testcase-VT:
//        elevatorA.enterElevator(83886080);  
//        elevatorA.enterElevator(327727);   
//        elevatorA.moveElevator(47); 
//        elevatorA.exitElevator(5066061);  
//        elevatorA.moveElevator(5); 
//        elevatorA.moveElevator(8830); 
        
        // testcase-Z3:
//        elevatorA.enterElevator(5);  
//        elevatorA.enterElevator(7);   
//        elevatorA.enterElevator(7);
//        elevatorA.exitElevator(3);  
//        elevatorA.enterElevator(7);
//        elevatorA.enterElevator(7);
        
        // testcase-UVT:
        elevatorA.enterElevator(5);  
        elevatorA.enterElevator(7);   
        elevatorA.moveElevator(5); 
        elevatorA.exitElevator(3);  
        elevatorA.moveElevator(1); 
        elevatorA.moveElevator(1); 
//        elevatorA.printLog();        

    }
}
