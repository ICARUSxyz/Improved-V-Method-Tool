package code;

public class c107_SmartSolarInverter {

    private double minVoltage;         
    private double maxVoltage;      
    private double currentVoltage;     
    private double inverterOutput;     

    public c107_SmartSolarInverter(double minVoltage, double maxVoltage, double initialVoltage, double initialOutput) {
        this.minVoltage = minVoltage;
        this.maxVoltage = maxVoltage;
        this.currentVoltage = initialVoltage;
        this.inverterOutput = initialOutput;
    }

    public void updateVoltage(double newVoltage) {
        currentVoltage = newVoltage;
        adjustInverterOutput();
        System.out.printf("Current Panel Voltage: %.2f V, Inverter Output: %.2f V%n", currentVoltage, inverterOutput);
        if (currentVoltage < minVoltage) {
            System.out.println("ALERT: Voltage too low. Increasing inverter output.");
        } else if (currentVoltage > maxVoltage) {
            System.out.println("ALERT: Voltage too high. Decreasing inverter output.");
        } else {
            System.out.println("Voltage is optimal. No adjustment required.");
        }
    }

    private void adjustInverterOutput() {
        if (currentVoltage < minVoltage) {
            inverterOutput = inverterOutput * 1.1;
        } else if (currentVoltage > maxVoltage) {
            inverterOutput = inverterOutput * 0.9;
        }
    }

    public double getInverterOutput() {
        return inverterOutput;
    }

    public static void main(String[] args) {
    	c107_SmartSolarInverter inverter = new c107_SmartSolarInverter(300.0, 400.0, 350.0, 350.0);

        // testcase-VT:
//        inverter.updateVoltage(280.0);  
//        inverter.updateVoltage(360.0);  
//        inverter.updateVoltage(420.0); 
        
        // testcase-FT:
//        inverter.updateVoltage(-4.1527529154101297E298);  
//        inverter.updateVoltage(-1.7976931348623157E308);  
//        inverter.updateVoltage(0.0); 
    	
        // testcase-Z3:
//        inverter.updateVoltage(280.0);  
//        inverter.updateVoltage(360.0);  
//        inverter.updateVoltage(420.0); 
        
        // testcase-UVT:
        inverter.updateVoltage(280.0);  
        inverter.updateVoltage(360.0);  
        inverter.updateVoltage(420.0); 
    }
}
