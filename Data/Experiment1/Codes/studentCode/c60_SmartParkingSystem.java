package code;

import java.util.*;

class ParkingLot {
    private int totalSpaces;
    private int availableSpaces;
    private Queue<String> waitlist;
    private List<String> log;

    public ParkingLot(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.availableSpaces = totalSpaces;
        this.waitlist = new LinkedList<>();
        this.log = new ArrayList<>();
    }

    public void parkVehicle(String vehicle) {
        if (availableSpaces > 0) {
            availableSpaces--;
            System.out.printf("%s parked | Available Spaces: %d/%d%n", vehicle, availableSpaces, totalSpaces);
            log.add(String.format("%s parked | Remaining: %d/%d", vehicle, availableSpaces, totalSpaces));
        } else {
            waitlist.add(vehicle);
            System.out.printf("No spaces available. %s added to the waiting list.%n", vehicle);
            log.add(String.format("%s added to waitlist | No spaces available", vehicle));
        }
    }

    public void leaveParking(String vehicle) {
        if (!waitlist.isEmpty()) {
            String nextVehicle = waitlist.poll();
            System.out.printf("%s left. %s can now park.%n", vehicle, nextVehicle);
            log.add(String.format("%s left | Assigned to %s", vehicle, nextVehicle));
        } else {
            availableSpaces = Math.min(totalSpaces, availableSpaces + 1);
            System.out.printf("%s left | Available Spaces: %d/%d%n", vehicle, availableSpaces, totalSpaces);
            log.add(String.format("%s left | Available: %d/%d", vehicle, availableSpaces, totalSpaces));
        }
    }

    public void printLog() {
        System.out.println("\nParking Lot Log:");
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c60_SmartParkingSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3); 
        
        // testcase-VT:
//        parkingLot.parkVehicle("Car A"); 
//        parkingLot.parkVehicle("Car B"); 
//        parkingLot.parkVehicle("Car C"); 
//        parkingLot.parkVehicle("Car D");  
//        parkingLot.leaveParking("Car B"); 
//        parkingLot.leaveParking("Car A"); 
//        parkingLot.printLog();  
        
        // testcase-FT:
//        parkingLot.parkVehicle("mz"); 
//        parkingLot.parkVehicle("mO"); 
//        parkingLot.parkVehicle("m`"); 
//        parkingLot.parkVehicle("mo");  
//        parkingLot.leaveParking("m/"); 
//        parkingLot.leaveParking("mm"); 
//        parkingLot.printLog();  
        
        // testcase-Z3:
//        parkingLot.parkVehicle("Car A"); 
//        parkingLot.parkVehicle("Car B"); 
//        parkingLot.parkVehicle("Car C"); 
//        parkingLot.parkVehicle("Car D");  
//        parkingLot.leaveParking("Car B"); 
//        parkingLot.leaveParking("Car A"); 
//        parkingLot.printLog();  
        
        // testcase-UVT:
        parkingLot.parkVehicle("Car A"); 
        parkingLot.parkVehicle("Car B"); 
        parkingLot.parkVehicle("Car C"); 
        parkingLot.parkVehicle("Car D");  
        parkingLot.leaveParking("Car B"); 
        parkingLot.leaveParking("Car A"); 
        parkingLot.printLog();  
    }
}

