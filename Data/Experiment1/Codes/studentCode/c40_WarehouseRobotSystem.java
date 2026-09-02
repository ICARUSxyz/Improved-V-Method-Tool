package code;

import java.util.*;

class WarehouseRobot {
    private String id;
    private double maxLoad;
    private double currentLoad;
    private List<String> log;

    public WarehouseRobot(String id, double maxLoad) {
        this.id = id;
        this.maxLoad = maxLoad;
        this.currentLoad = 0.0;
        this.log = new ArrayList<>();
    }

    public void assignTask(double taskWeight) {
        if (currentLoad + taskWeight > maxLoad) {
            System.out.printf("Robot %s Overloaded! Task Rejected.%n", id);
            log.add(String.format("Overload Warning: Task %.1f kg rejected.", taskWeight));
            return;
        }

        currentLoad += taskWeight;
        System.out.printf("Robot %s Assigned Task: %.1f kg | Current Load: %.1f kg%n", id, taskWeight, currentLoad);
        log.add(String.format("Task Assigned: %.1f kg | New Load: %.1f kg", taskWeight, currentLoad));
    }

    public void completeTask(double taskWeight) {
        currentLoad = Math.max(0, currentLoad - taskWeight);
        System.out.printf("Robot %s Completed Task: %.1f kg | Remaining Load: %.1f kg%n", id, taskWeight, currentLoad);
        log.add(String.format("Task Completed: %.1f kg | Remaining Load: %.1f kg", taskWeight, currentLoad));
    }

    public void printLog() {
        System.out.printf("\nRobot %s Load Log:%n", id);
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c40_WarehouseRobotSystem {
    public static void main(String[] args) {

        // testcase-VT:
//    	WarehouseRobot robot1 = new WarehouseRobot("R1", 50.0);
//        WarehouseRobot robot2 = new WarehouseRobot("R2", 60.0);
//        robot1.assignTask(20.0);  
//        robot1.assignTask(35.0);  
//        robot1.completeTask(10.0); 
//        robot1.assignTask(30.0);  
//        robot1.printLog(); 
//
//        robot2.assignTask(50.0);  
//        robot2.completeTask(20.0); 
//        robot2.assignTask(20.0);  
//        robot2.assignTask(15.0);  
//        robot2.printLog(); 
        
     // testcase-FT:
//    	WarehouseRobot robot1 = new WarehouseRobot("R1", 50.0);
//        robot1.assignTask(-4.9E-324);  
//        robot1.assignTask(7.022238808055905E305);  
//        robot1.assignTask(-1.7976931348623157E308); 
//        robot1.assignTask(0.0);  
//        robot1.assignTask(-9.376203409281882E307);  
//        robot1.assignTask(-7.022238808055905E305);  
//        robot1.assignTask(-1.0589518656958033E301); 
//        robot1.assignTask(6.364956940265681E293);  
//        robot1.printLog(); 
    	
        // testcase-Z3:
//    	WarehouseRobot robot1 = new WarehouseRobot("R1", 50.0);
////        WarehouseRobot robot2 = new WarehouseRobot("R2", 60.0);
//        robot1.assignTask(20.0);  
//        robot1.assignTask(35.0);  
//        robot1.completeTask(10.0); 
//        robot1.assignTask(30.0);  
////        robot1.printLog(); 
//
//        robot1.assignTask(50.0);  
//        robot1.completeTask(20.0); 
//        robot1.assignTask(20.0);  
//        robot1.assignTask(15.0);  
////        robot1.printLog(); 
        
        // testcase-UVT:
    	WarehouseRobot robot1 = new WarehouseRobot("R1", 50.0);
        WarehouseRobot robot2 = new WarehouseRobot("R2", 60.0);
        robot1.assignTask(20.0);  
        robot1.assignTask(35.0);  
        robot1.completeTask(10.0); 
        robot1.assignTask(30.0);  
        robot1.printLog(); 

        robot2.assignTask(50.0);  
        robot2.completeTask(20.0); 
        robot2.assignTask(20.0);  
        robot2.assignTask(15.0);  
        robot2.printLog(); 
    }
}

