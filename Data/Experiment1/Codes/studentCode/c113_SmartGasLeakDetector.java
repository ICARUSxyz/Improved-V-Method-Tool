package code;

public class c113_SmartGasLeakDetector {

    private double warningThreshold;   
    private double dangerThreshold;    
    private double currentGasLevel;    
    private boolean emergencyShutdown; 

    public c113_SmartGasLeakDetector(double warningThreshold, double dangerThreshold, double initialGasLevel) {
        this.warningThreshold = warningThreshold;
        this.dangerThreshold = dangerThreshold;
        this.currentGasLevel = initialGasLevel;
        this.emergencyShutdown = false;
    }

    public void updateGasLevel(double newGasLevel) {
        currentGasLevel = newGasLevel;
        checkGasLeak();
        System.out.printf("Current Gas Level: %.2f%% LEL, Emergency Shutdown: %s%n",
                currentGasLevel, emergencyShutdown ? "ACTIVE" : "INACTIVE");

        if (emergencyShutdown) {
            System.out.println("ALERT: Critical gas leak detected! Emergency shutdown initiated.");
        } else if (currentGasLevel > warningThreshold) {
            System.out.println("WARNING: Gas level high. Immediate attention required.");
        } else {
            System.out.println("Gas concentration is within safe limits.");
        }
    }

    private void checkGasLeak() {
        if (currentGasLevel > dangerThreshold) {
            emergencyShutdown = true;
        } else {
            emergencyShutdown = false;
        }
    }

    public double getCurrentGasLevel() {
        return currentGasLevel;
    }

    public static void main(String[] args) {
    	c113_SmartGasLeakDetector detector = new c113_SmartGasLeakDetector(20.0, 40.0, 10.0);

        // testcase-VT:
//        detector.updateGasLevel(15.0); 
//        detector.updateGasLevel(25.0);
//        detector.updateGasLevel(45.0); 
        
        // testcase-FT:
//        detector.updateGasLevel(6.365249299686023E293); 
//        detector.updateGasLevel(1.6349709418800172E296);
//        detector.updateGasLevel(2.3630739519577067E295); 

        // testcase-Z3:
//        detector.updateGasLevel(15.0); 
//        detector.updateGasLevel(25.0);
//        detector.updateGasLevel(45.0); 
        
        // testcase-UVT:
        detector.updateGasLevel(15.0); 
        detector.updateGasLevel(25.0);
        detector.updateGasLevel(45.0); 
    }
}

