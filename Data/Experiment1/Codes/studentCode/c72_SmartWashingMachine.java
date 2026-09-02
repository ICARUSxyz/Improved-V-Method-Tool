package code;

class c72_SmartWashingMachine {
    private double maxCapacity;     
    private double baseCycleTime;    
    private double waterPerKg;      
    
    private double currentLoad;
    private double calculatedCycleTime;
    private double calculatedWaterUsage;
    
    public c72_SmartWashingMachine(double maxCapacity, double baseCycleTime, double waterPerKg) {
        this.maxCapacity = maxCapacity;
        this.baseCycleTime = baseCycleTime;
        this.waterPerKg = waterPerKg;
        this.currentLoad = 0.0;
        this.calculatedCycleTime = 0.0;
        this.calculatedWaterUsage = 0.0;
    }
    
    public void setLoad(double load) {
        currentLoad = load;
        if (currentLoad > maxCapacity) {
            System.out.println("WARNING: Load exceeds maximum capacity! Please reduce the laundry load.");
            calculatedCycleTime = 0.0;
            calculatedWaterUsage = 0.0;
        } else {
            calculatedCycleTime = baseCycleTime + (currentLoad / maxCapacity) * baseCycleTime;
            calculatedWaterUsage = currentLoad * waterPerKg;
            System.out.printf("Load accepted: %.2f kg\n", currentLoad);
            System.out.printf("Calculated Cycle Time: %.2f minutes\n", calculatedCycleTime);
            System.out.printf("Estimated Water Usage: %.2f liters\n", calculatedWaterUsage);
        }
    }
    
    public double getCycleTime() {
        return calculatedCycleTime;
    }
    
    public double getWaterUsage() {
        return calculatedWaterUsage;
    }
    
    public static void main(String[] args) {
    	c72_SmartWashingMachine machine = new c72_SmartWashingMachine(8.0, 30.0, 10.0);
        
        // testcase-VT:
//        machine.setLoad(5.0);  
//        machine.setLoad(9.0);  
//        machine.setLoad(7.0);
        
        // testcase-FT:
//        machine.setLoad(-1.7836486571579143E308);  
//        machine.setLoad(0.0);  
//        machine.setLoad(1.6757390077074176E303);
        
        // testcase-Z3:
//        machine.setLoad(5.0);  
//        machine.setLoad(9.0);  
//        machine.setLoad(7.0);
        
        // testcase-UVT:
        machine.setLoad(5.0);  
        machine.setLoad(9.0);  
        machine.setLoad(7.0);
    }
}
