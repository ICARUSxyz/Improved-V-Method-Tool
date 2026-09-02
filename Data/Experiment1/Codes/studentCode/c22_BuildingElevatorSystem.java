package code;

import java.util.*;

class Elevator {
    private double maxCapacity;
    private double currentLoad;
    private int passengerCount;
    private List<String> tripLog;

    public Elevator(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentLoad = 0.0;
        this.passengerCount = 0;
        this.tripLog = new ArrayList<>();
    }

    public void enterElevator(String passenger, double weight) {
        currentLoad += weight;
        passengerCount++;

        if (currentLoad > maxCapacity) {
            System.out.printf("ALERT! Overload detected! Passenger %s (%.1f kg) exceeded capacity!%n", passenger, weight);
            tripLog.add(String.format("Overload! Passenger: %s | Weight: %.1f kg | Total: %.1f kg (Exceeded!)", passenger, weight, currentLoad));
        } else {
            System.out.printf("Passenger %s (%.1f kg) entered. Current Load: %.1f kg%n", passenger, weight, currentLoad);
            tripLog.add(String.format("Passenger: %s | Weight: %.1f kg | Total: %.1f kg", passenger, weight, currentLoad));
        }
    }

    public void completeTrip() {
        System.out.printf("Elevator trip complete. Final Load: %.1f kg | Passengers: %d%n", currentLoad, passengerCount);
        tripLog.add(String.format("Trip Completed | Final Load: %.1f kg | Passengers: %d", currentLoad, passengerCount));

        currentLoad = 0.0;
        passengerCount = 0;
    }

    public void printTripLog() {
        System.out.println("\nElevator Trip Log:");
        for (String log : tripLog) {
            System.out.println(log);
        }
    }
}

public class c22_BuildingElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(600.0);

        // testcase-VT:
//        elevator.enterElevator("Alice", 65.0); 
//        elevator.enterElevator("Bob", 80.0);   
//        elevator.enterElevator("Charlie", 75.0); 
//        elevator.enterElevator("David", 200.0); 
//        elevator.enterElevator("Eve", 220.0);   
//        elevator.completeTrip(); 
        
        // testcase-FT:
//        elevator.enterElevator("??", -1.7976931348608188E308); 
//        elevator.enterElevator("", 1.9490628022799996E289);   
//        elevator.enterElevator("??mmm", -1.5439011628817536E308); 
//        elevator.enterElevator("fhao0--", 0.0); 
//        elevator.enterElevator("99AJFE", 3.800672464445999E290);  
//        elevator.completeTrip(); 
        
        // testcase-Z3:
//        elevator.enterElevator("Alice", 65); 
//        elevator.enterElevator("Bob", 80);   
//        elevator.enterElevator("Charlie", 75); 
//        elevator.enterElevator("David", 200); 
//        elevator.enterElevator("Eve", 220);   
//        elevator.completeTrip(); 
        
        // testcase-UVT:
        elevator.enterElevator("Alice", 65.0); 
        elevator.enterElevator("Bob", 80.0);   
        elevator.enterElevator("Charlie", 75.0); 
        elevator.enterElevator("David", 200.0); 
        elevator.enterElevator("Eve", 220.0);   
        elevator.completeTrip(); 
        elevator.printTripLog(); 
    }
}
