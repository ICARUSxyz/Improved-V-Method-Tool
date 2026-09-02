package code;

import java.util.*;

class SpeedViolation {
    private String licensePlate;
    private double speed;
    private double speedLimit;
    private double fineAmount;

    public SpeedViolation(String licensePlate, double speed, double speedLimit) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.speedLimit = speedLimit;
        this.fineAmount = calculateFine();
    }

    private double calculateFine() {
        double overSpeed = speed - speedLimit;
        if (overSpeed <= 0) {
            return 0.0;
        } else if (overSpeed <= 10) {
            return 50.0;  
        } else if (overSpeed <= 30) {
            return 200.0; 
        } else {
            return 500.0; 
        }
    }

    public boolean isViolation() {
        return fineAmount > 0;
    }

    public String getViolationDetails() {
        if (isViolation()) {
            return String.format("License Plate: %s | Speed: %.1f km/h | Limit: %.1f km/h | Fine: $%.2f", 
                    licensePlate, speed, speedLimit, fineAmount);
        } else {
            return String.format("License Plate: %s | Speed: %.1f km/h | Limit: %.1f km/h | No Violation", 
                    licensePlate, speed, speedLimit);
        }
    }
}

class SpeedMonitor {
    private double speedLimit;
    private List<String> violationLog;

    public SpeedMonitor(double speedLimit) {
        this.speedLimit = speedLimit;
        this.violationLog = new ArrayList<>();
    }

    public void recordSpeed(String licensePlate, double speed) {
        SpeedViolation violation = new SpeedViolation(licensePlate, speed, speedLimit);
        System.out.println(violation.getViolationDetails());

        if (violation.isViolation()) {
            violationLog.add(violation.getViolationDetails());
        }
    }

    public void printViolationLog() {
        System.out.println("\nSpeed Violation Log:");
        for (String log : violationLog) {
            System.out.println(log);
        }
    }
}

public class c18_VehicleSpeedSystem {
    public static void main(String[] args) {
        SpeedMonitor monitor = new SpeedMonitor(60.0); 

        // testcase-VT:
//        monitor.recordSpeed("ABC123", 55.0); 
//        monitor.recordSpeed("XYZ789", 65.0); 
//        monitor.recordSpeed("LMN456", 85.0); 
//        monitor.recordSpeed("QWE222", 120.0); 
        
        // testcase-FT:
//        monitor.recordSpeed("", -1.7976931348623157E308); 
//        monitor.recordSpeed("", 0); 
//        monitor.recordSpeed("4USS", -4.9E-324); 
//        monitor.recordSpeed("???", -9.658194489260283E307); 
        
        // testcase-Z3:
//        monitor.recordSpeed("ABC123", 0); 
//        monitor.recordSpeed("XYZ789", -1); 
//        monitor.recordSpeed("LMN456", 31); 
//        monitor.recordSpeed("QWE222", 9); 
        
        // testcase-VT:
        monitor.recordSpeed("ABC123", 55); 
        monitor.recordSpeed("XYZ789", 65); 
        monitor.recordSpeed("LMN456", 85); 
        monitor.recordSpeed("QWE222", 12); 
        
        monitor.printViolationLog(); 
    }
}


