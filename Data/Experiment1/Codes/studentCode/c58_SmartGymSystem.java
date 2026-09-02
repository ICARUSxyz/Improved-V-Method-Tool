package code;

import java.util.*;

class GymEquipment {
    private String name;
    private int maxCapacity;
    private int currentUsers;
    private List<String> log;

    public GymEquipment(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentUsers = 0;
        this.log = new ArrayList<>();
    }

    public void useEquipment(int numUsers) {
        if (currentUsers + numUsers > maxCapacity) {
            System.out.printf("WARNING: %s is Overcrowded! Suggesting Alternative Exercises.%n", name);
            log.add("Overcrowding Alert: Suggested alternative exercises.");
            return;
        }

        currentUsers += numUsers;
        System.out.printf("%d Members Started Using %s | Current Users: %d/%d%n", numUsers, name, currentUsers, maxCapacity);
        log.add(String.format("%d Members Started Using | New Count: %d/%d", numUsers, currentUsers, maxCapacity));
    }

    public void leaveEquipment(int numUsers) {
        currentUsers = Math.max(0, currentUsers - numUsers);
        System.out.printf("%d Members Left %s | Remaining Users: %d/%d%n", numUsers, name, currentUsers, maxCapacity);
        log.add(String.format("%d Members Left | Remaining Count: %d/%d", numUsers, currentUsers, maxCapacity));
    }

    public void printLog() {
        System.out.printf("\n%s Usage Log:%n", name);
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c58_SmartGymSystem {
    public static void main(String[] args) {
        GymEquipment treadmill = new GymEquipment("Treadmill", 5);
        GymEquipment benchPress = new GymEquipment("Bench Press", 3);

        // testcase-VT:
//        treadmill.useEquipment(3); 
//        treadmill.useEquipment(2); 
//        treadmill.useEquipment(1);  
//        treadmill.leaveEquipment(2);  
//        benchPress.useEquipment(2);  
//        benchPress.leaveEquipment(1);
//        treadmill.printLog(); 
//        benchPress.printLog(); 

        // testcase-FT:
//        treadmill.useEquipment(-574478552); 
//        treadmill.useEquipment(-656877352); 
//        treadmill.useEquipment(-29);  
//        treadmill.useEquipment(0);  
//        benchPress.useEquipment(-61);  
//        benchPress.useEquipment(0);
//        treadmill.printLog(); 
//        benchPress.printLog();      
        
        // testcase-Z3:
//        treadmill.useEquipment(3); 
//        treadmill.useEquipment(2); 
//        treadmill.useEquipment(1);  
//        treadmill.leaveEquipment(2);  
//        benchPress.useEquipment(2);  
//        benchPress.leaveEquipment(1);
//        treadmill.printLog(); 
//        benchPress.printLog(); 
        
        // testcase-UVT:
        treadmill.useEquipment(3); 
        treadmill.useEquipment(2); 
        treadmill.useEquipment(1);  
        treadmill.leaveEquipment(2);  
        benchPress.useEquipment(2);  
        benchPress.leaveEquipment(1);
        treadmill.printLog(); 
        benchPress.printLog(); 

    }
}
