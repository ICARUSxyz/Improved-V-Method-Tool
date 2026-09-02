package code;
import java.util.ArrayList;
import java.util.List;

class TrafficSignal {
    private String intersection;
    private int greenTime; 
    private List<String> signalLog;

    public TrafficSignal(String intersection, int defaultGreenTime) {
        this.intersection = intersection;
        this.greenTime = defaultGreenTime;
        this.signalLog = new ArrayList<>();
    }

    public void updateGreenTime(int trafficDensity) {
        if (trafficDensity > 80 && trafficDensity <= 100) {
            greenTime = 45; 
        } else if (trafficDensity > 50 && trafficDensity <= 80) {
            greenTime = 30; 
        } else if (trafficDensity > 0 && trafficDensity <= 50){
            greenTime = 15; 
        } else {
        	greenTime = 0;
        }
        if(greenTime ==  0) {
        	System.out.printf("invalide input%n	");
        }else {
        signalLog.add(String.format("Intersection %s: Green time updated to %d seconds (Traffic: %d%%)",
                intersection, greenTime, trafficDensity));
        System.out.printf("Green light at %s set to %d seconds due to traffic density: %d%%%n",
                intersection, greenTime, trafficDensity);
        }
    }

    public void printSignalLog() {
        System.out.println("Traffic Signal Log for " + intersection + ":");
        for (String log : signalLog) {
            System.out.println(log);
        }
    }
}

public class c09_IntelligentTrafficSystem {
    public static void main(String[] args) {
        TrafficSignal signal = new TrafficSignal("Main St & 1st Ave", 15);

        // testcase-VT:
//        signal.updateGreenTime(-21); // trafficDensity < 0
//        signal.updateGreenTime(3);  // trafficDensity > 0 && trafficDensity <= 50
//        signal.updateGreenTime(62); // trafficDensity > 50 && trafficDensity <= 80
//        signal.updateGreenTime(87); // trafficDensity > 80 && trafficDensity <= 100
//        signal.updateGreenTime(134); // trafficDensity > 100
//        signal.printSignalLog();
        
        //testcase-FT:
//        signal.updateGreenTime(61); // trafficDensity < 0
//        signal.updateGreenTime(27965);  // trafficDensity > 0 && trafficDensity <= 50
//        signal.updateGreenTime(9006397); // trafficDensity > 50 && trafficDensity <= 80
//        signal.updateGreenTime(35181); // trafficDensity > 80 && trafficDensity <= 100
//        signal.updateGreenTime(96); // trafficDensity > 100
//        signal.printSignalLog();

        // testcase-Z3:
      signal.updateGreenTime(100); // trafficDensity < 0
      signal.updateGreenTime(79);  // trafficDensity > 0 && trafficDensity <= 50
      signal.updateGreenTime(101); // trafficDensity > 50 && trafficDensity <= 80
      signal.updateGreenTime(79); // trafficDensity > 80 && trafficDensity <= 100
      signal.updateGreenTime(101); // trafficDensity > 100
      signal.printSignalLog();
        
        // testcase-UVT:
//      signal.updateGreenTime(-21); // trafficDensity < 0
//      signal.updateGreenTime(3);  // trafficDensity > 0 && trafficDensity <= 50
//      signal.updateGreenTime(62); // trafficDensity > 50 && trafficDensity <= 80
//      signal.updateGreenTime(87); // trafficDensity > 80 && trafficDensity <= 100
//      signal.updateGreenTime(134); // trafficDensity > 100
//      signal.printSignalLog();
    }
}

