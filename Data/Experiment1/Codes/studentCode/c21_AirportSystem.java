package code;

import java.util.*;

class BaggageCheck {
    private String passengerName;
    private double baggageWeight;
    private final double freeWeightLimit;
    private final double maxWeightLimit;
    private final double overweightFeePerKg;
    private double excessWeight;
    private double fee;

    public BaggageCheck(String passengerName, double baggageWeight, double freeWeightLimit, double maxWeightLimit, double overweightFeePerKg) {
        this.passengerName = passengerName;
        this.baggageWeight = baggageWeight;
        this.freeWeightLimit = freeWeightLimit;
        this.maxWeightLimit = maxWeightLimit;
        this.overweightFeePerKg = overweightFeePerKg;
        this.excessWeight = calculateExcessWeight();
        this.fee = calculateFee();
    }

    private double calculateExcessWeight() {
        if (baggageWeight > freeWeightLimit) {
            return baggageWeight - freeWeightLimit;
        } else {
            return 0;
        }
    }

    private double calculateFee() {
        if (baggageWeight > maxWeightLimit) {
            return -1; 
        } else if (excessWeight > 0) {
            return excessWeight * overweightFeePerKg;
        } else {
            return 0;
        }
    }

    public boolean isOverweight() {
        return fee > 0;
    }

    public boolean isRejected() {
        return fee == -1;
    }

    public String getBaggageDetails() {
        if (isRejected()) {
            return String.format("Passenger: %s | Baggage Weight: %.1f kg | EXCEEDS MAX LIMIT! Check-in Denied.", 
                    passengerName, baggageWeight);
        } else if (isOverweight()) {
            return String.format("Passenger: %s | Baggage Weight: %.1f kg | Excess: %.1f kg | Fee: $%.2f", 
                    passengerName, baggageWeight, excessWeight, fee);
        } else {
            return String.format("Passenger: %s | Baggage Weight: %.1f kg | Within Limit, No Extra Fee", 
                    passengerName, baggageWeight);
        }
    }
}

class AirportBaggageSystem {
    private List<String> baggageLog;

    public AirportBaggageSystem() {
        this.baggageLog = new ArrayList<>();
    }

    public void checkBaggage(String passengerName, double weight) {
        BaggageCheck check = new BaggageCheck(passengerName, weight, 20.0, 32.0, 10.0);
        System.out.println(check.getBaggageDetails());

        if (!check.isRejected()) {
            baggageLog.add(check.getBaggageDetails());
        }
    }

    public void printBaggageLog() {
        System.out.println("\nBaggage Check Log:");
        for (String log : baggageLog) {
            System.out.println(log);
        }
    }
}

public class c21_AirportSystem {
    public static void main(String[] args) {
        AirportBaggageSystem system = new AirportBaggageSystem();

        // testcase-VT:
//        system.checkBaggage("Alice", 18.0); 
//        system.checkBaggage("Bob", 23.0);   
//        system.checkBaggage("Charlie", 35.0); 
//        system.checkBaggage("David", 30.0); 
        
        // testcase-FT:
//        system.checkBaggage("", -1.7976931348623157E308); 
//        system.checkBaggage("??", 5.350177392258598E291);   
//        system.checkBaggage("??mmm", 1.508684118918264E306); 
//        system.checkBaggage("fhao0--", 1.5071135814397465E306); 
        
        // testcase-Z3:
//        system.checkBaggage("Alice", 17); 
//        system.checkBaggage("Bob", 19);   
//        system.checkBaggage("Charlie", 17); 
//        system.checkBaggage("David", 19); 
        
        // testcase-UVT:
        system.checkBaggage("Alice", 18); 
        system.checkBaggage("Bob", 23);   
        system.checkBaggage("Charlie", 17); 
        system.checkBaggage("David", 30); 
        system.printBaggageLog(); 
    }
}
