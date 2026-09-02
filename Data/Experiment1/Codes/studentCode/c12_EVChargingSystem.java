package code;
import java.util.*;

class Vehicle {
    private String licensePlate;
    private double chargeTime; 
    
    public Vehicle(String licensePlate, double chargeTime) {
        this.licensePlate = licensePlate;
        this.chargeTime = chargeTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getChargeTime() {
        return chargeTime;
    }
}

class ChargingStation {
    private int totalSlots;
    private double costPerHour;
    private Queue<Vehicle> waitingQueue;
    private Map<String, Double> activeCharging;
    private List<String> transactionLog;

    public ChargingStation(int totalSlots, double costPerHour) {
        this.totalSlots = totalSlots;
        this.costPerHour = costPerHour;
        this.waitingQueue = new LinkedList<>();
        this.activeCharging = new HashMap<>();
        this.transactionLog = new ArrayList<>();
    }

    public void requestCharging(String licensePlate, double chargeTime) {
        if (chargeTime <= 0) {
            System.out.println("Invalid charge time! Must be greater than zero.");
            return;
        }

        if (activeCharging.size() < totalSlots) {
            activeCharging.put(licensePlate, chargeTime);
            System.out.printf("Vehicle %s assigned to charging slot for %.2f hours.%n", licensePlate, chargeTime);
        } else {
            waitingQueue.add(new Vehicle(licensePlate, chargeTime));
            System.out.printf("All slots occupied! Vehicle %s added to waiting queue.%n", licensePlate);
        }
    }

    public void completeCharging(String licensePlate) {
        if (activeCharging.containsKey(licensePlate)) {
            double chargeTime = activeCharging.remove(licensePlate);
            double cost = chargeTime * costPerHour;
            transactionLog.add(String.format("Charged: %s - %.2f hours, Cost: $%.2f", licensePlate, chargeTime, cost));
            System.out.printf("Charging completed for %s. Cost: $%.2f%n", licensePlate, cost);

            if (!waitingQueue.isEmpty()) {
                Vehicle nextVehicle = waitingQueue.poll();
                activeCharging.put(nextVehicle.getLicensePlate(), nextVehicle.getChargeTime());
                System.out.printf("Next in queue: %s assigned to charging slot.%n", nextVehicle.getLicensePlate());
            }
        } else {
            System.out.println("Vehicle not found in active charging slots.");
        }
    }

    public void printTransactionLog() {
        System.out.println("\nCharging Transaction Log:");
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}

public class c12_EVChargingSystem {
    public static void main(String[] args) {
        ChargingStation station = new ChargingStation(2, 5.0); 

        // testcase-VT:
//        station.requestCharging("ABC123", 2.3); 
//        station.requestCharging("XYZ789", 1.2);
//        station.requestCharging("LMN456", 5.5); 
//        station.completeCharging("ABC123"); 
//        station.completeCharging("XYZ789");
//        station.completeCharging("LMN456"); 
//        station.completeCharging("LMN456"); 
//        station.requestCharging("QWE222", -1.9);
        
        // testcase-FT:
//        station.requestCharging("", 0); 
//        station.requestCharging("z?d", 1.3951725578848605E298);
//        station.requestCharging("", -1.7976931348623157E308); 
//        station.completeCharging(""); 
//        station.completeCharging("z?d");
//        station.completeCharging(""); 
//        station.completeCharging("deuu"); 
//        station.requestCharging("deUU", 0);  
        
        // testcase-Z3:
//        station.requestCharging("ABC123", 4); 
//        station.requestCharging("XYZ789", -1);
//        station.requestCharging("LMN456", 101); 
//        station.requestCharging("ABC123", -1); 
//        station.requestCharging("XYZ789", 101);
//        station.requestCharging("LMN456", 9); 
//        station.requestCharging("QWE222", 11);
//        station.requestCharging("QWE222", 9);
        
        // testcase-UVT:
      station.requestCharging("ABC123", 0); 
      station.requestCharging("XYZ789", 1.3);
      station.requestCharging("LMN456", -1.79); 
      station.completeCharging("ABC123"); 
      station.completeCharging("XYZ789");
      station.completeCharging("LMN456"); 
      station.completeCharging("QWE222"); 
      station.requestCharging("QWE222", 0);  
        
        station.printTransactionLog(); 
    }
}
