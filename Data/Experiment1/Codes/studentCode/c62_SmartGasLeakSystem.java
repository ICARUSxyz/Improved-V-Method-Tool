package code;

class SmartGasSystem {
    private double maxSafeLevel;
    private double currentGasLevel;
    private boolean gasSupplyActive;

    public SmartGasSystem(double maxSafeLevel, double initialGasLevel) {
        this.maxSafeLevel = maxSafeLevel;
        this.currentGasLevel = initialGasLevel;
        this.gasSupplyActive = true;
    }

    public void updateGasLevel(double changeAmount) {
        currentGasLevel += changeAmount;
        manageGasSupply();

        System.out.printf("Current Gas Concentration: %.2f%%\n", currentGasLevel);
        if (!gasSupplyActive) {
            System.out.println("WARNING: Gas Leak Detected! Gas Supply Shut Off.");
        }
    }

    private void manageGasSupply() {
        if (currentGasLevel > maxSafeLevel) {
            gasSupplyActive = false;
        }
    }

    public void resetGasSupply() {
        if (currentGasLevel <= maxSafeLevel) {
            gasSupplyActive = true;
            System.out.println("Gas Supply Reactivated.");
        } else {
            System.out.println("Cannot Reactivate Gas Supply. Gas Concentration Still Unsafe.");
        }
    }
}

public class c62_SmartGasLeakSystem {
    public static void main(String[] args) {
        SmartGasSystem gasSystem = new SmartGasSystem(5.0, 2.0); 
        
        // testcase-VT:
        gasSystem.updateGasLevel(2.5); 
        gasSystem.updateGasLevel(1.0); 
        gasSystem.resetGasSupply();    
        gasSystem.updateGasLevel(-2.0); 
        gasSystem.resetGasSupply();     

        // testcase-FT:
//        gasSystem.updateGasLevel(1.7976931344486818E308); 
//        gasSystem.updateGasLevel(-4.9E-324); 
//        gasSystem.updateGasLevel(0.0);    
//        gasSystem.updateGasLevel(-1.7976931348623157E308); 
//        gasSystem.updateGasLevel(9.094212329303478E307);         
        
        // testcase-Z3:
//        gasSystem.updateGasLevel(2.5); 
//        gasSystem.updateGasLevel(1.0); 
//        gasSystem.resetGasSupply();    
//        gasSystem.updateGasLevel(-2.0); 
//        gasSystem.resetGasSupply();     

        // testcase-UVT:
        gasSystem.updateGasLevel(2.5); 
        gasSystem.updateGasLevel(1.0); 
        gasSystem.resetGasSupply();    
        gasSystem.updateGasLevel(-2.0); 
        gasSystem.resetGasSupply();     

    }
}

