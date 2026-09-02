package code;

class SmartLiquidTank67 {
    private double maxLiquidLevel;
    private double minLiquidLevel;
    private double currentLiquidLevel;
    private boolean refillActive;

    public SmartLiquidTank67(double maxLiquidLevel, double minLiquidLevel, double initialLiquidLevel) {
        this.maxLiquidLevel = maxLiquidLevel;
        this.minLiquidLevel = minLiquidLevel;
        this.currentLiquidLevel = initialLiquidLevel;
        this.refillActive = false;
    }

    public void updateLiquidLevel(double changeAmount) {
        currentLiquidLevel += changeAmount;
        manageRefillSystem();

        System.out.printf("Current Liquid Level: %.2f liters\n", currentLiquidLevel);
        if (refillActive) {
            System.out.println("Refill System Activated.");
        } else {
            System.out.println("Refill System Deactivated.");
        }
    }

    private void manageRefillSystem() {
        if (currentLiquidLevel < minLiquidLevel) {
            refillActive = true;
        } else if (currentLiquidLevel > maxLiquidLevel) {
            refillActive = false;
        }
    }
}

public class c67_SmartLiquidSystem {
    public static void main(String[] args) {
        SmartLiquidTank67 tank = new SmartLiquidTank67(100.0, 30.0, 50.0); 

        // testcase-VT:
//        tank.updateLiquidLevel(-25.0); 
//        tank.updateLiquidLevel(20.0);   
//        tank.updateLiquidLevel(60.0);   
//        tank.updateLiquidLevel(-10.0);  
        
        // testcase-FT:
//        tank.updateLiquidLevel(3.139306941570492E305); 
//        tank.updateLiquidLevel(2.563310792133412E305);   
//        tank.updateLiquidLevel(-1.7976931348623157E308);   
//        tank.updateLiquidLevel(-4.092711172425034E306);  

        // testcase-Z3:
//        tank.updateLiquidLevel(-25.0); 
//        tank.updateLiquidLevel(20.0);   
//        tank.updateLiquidLevel(60.0);   
//        tank.updateLiquidLevel(-10.0);
        
        // testcase-UVT:
        tank.updateLiquidLevel(-25.0); 
        tank.updateLiquidLevel(20.0);   
        tank.updateLiquidLevel(60.0);   
        tank.updateLiquidLevel(-10.0);
    }
}

