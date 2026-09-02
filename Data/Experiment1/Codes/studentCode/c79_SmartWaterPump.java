package code;

public class c79_SmartWaterPump {

    private double minFlowRate;     
    private double maxFlowRate;    
    private double currentFlowRate; 
    private double pumpSpeed;      

    public c79_SmartWaterPump(double minFlowRate, double maxFlowRate, double initialFlowRate, double initialPumpSpeed) {
        this.minFlowRate = minFlowRate;
        this.maxFlowRate = maxFlowRate;
        this.currentFlowRate = initialFlowRate;
        this.pumpSpeed = initialPumpSpeed;
    }

    public void updateFlowRate(double newFlowRate) {
        currentFlowRate = newFlowRate;
        adjustPumpSpeed();
        System.out.printf("Current Flow Rate: %.2f L/min, Pump Speed: %.2f%%%n", currentFlowRate, pumpSpeed);
        if (currentFlowRate < minFlowRate) {
            System.out.println("ALERT: Low water flow detected. Increasing pump speed.");
        } else if (currentFlowRate > maxFlowRate) {
            System.out.println("ALERT: High water flow detected. Reducing pump speed.");
        } else {
            System.out.println("Flow rate is optimal. Pump speed remains constant.");
        }
    }

    private void adjustPumpSpeed() {
        if (currentFlowRate < minFlowRate) {
            pumpSpeed = Math.min(pumpSpeed * 1.2, 100.0);
        } else if (currentFlowRate > maxFlowRate) {
            pumpSpeed = Math.max(pumpSpeed * 0.8, 20.0);  
        }
    }

    public double getPumpSpeed() {
        return pumpSpeed;
    }

    public double getCurrentFlowRate() {
        return currentFlowRate;
    }

    public static void main(String[] args) {
    	c79_SmartWaterPump pump = new c79_SmartWaterPump(10.0, 50.0, 30.0, 50.0);

        // testcase-VT:
//        pump.updateFlowRate(5.0);   
//        pump.updateFlowRate(55.0);  
//        pump.updateFlowRate(35.0);  
        
        // testcase-FT:
//        pump.updateFlowRate(-1.7976931348606807E308);   
//        pump.updateFlowRate(0.0);  
//        pump.updateFlowRate(-4.9E-324);  
        
        // testcase-Z3:
//        pump.updateFlowRate(5.0);   
//        pump.updateFlowRate(55.0);  
//        pump.updateFlowRate(35.0);  
        
        // testcase-UVT:
        pump.updateFlowRate(5.0);   
        pump.updateFlowRate(55.0);  
        pump.updateFlowRate(35.0);  
    }
}

