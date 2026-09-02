package code;

public class c05_TemperatureController {
	 	private double temperature;  
	    private final double MIN_TEMP = 16.0; 
	    private final double MAX_TEMP = 23.0;  

	    public c05_TemperatureController(double initialTemp) {
	        this.temperature = initialTemp;
	    }

	    public void setTemperature(double newTemp) {
	        this.temperature = newTemp;
	        if (newTemp < MIN_TEMP) {
	            System.out.println("Warning: Temperature too low! Activating heating system...");
	        } else if (newTemp > MAX_TEMP) {
	            System.out.println("Warning: Temperature too high! Activating cooling system...");
	        } else {
	            System.out.println("Temperature is stable. No action required.");
	        }
	    }

	    public double getTemperature() {
	        return temperature;
	    }

	    public static void main(String[] args) {
	    	// testcase-VT:
//	    	c05_TemperatureController controller1 = new c05_TemperatureController(20.0); 
//	        controller1.setTemperature(18.3);   //newTemp >= 16 && newTemp <= 23
//	    	c05_TemperatureController controller2 = new c05_TemperatureController(20.0); 
//	        controller2.setTemperature(37.433);   //newTemp > 23
//	    	c05_TemperatureController controller3 = new c05_TemperatureController(20.0); 
//	        controller3.setTemperature(0);   //newTemp < 16
	        
	    	// testcase-FT:
//	    	c05_TemperatureController controller1 = new c05_TemperatureController(20.0); 
//	        controller1.setTemperature(-1.7976931348623157E308);   
//	    	c05_TemperatureController controller2 = new c05_TemperatureController(20.0); 
//	        controller2.setTemperature(1.1209145429141497E308);   
//	    	c05_TemperatureController controller3 = new c05_TemperatureController(20.0); 
//	        controller3.setTemperature(0);   
	        

	    	// testcase-Z3:
//	    	c05_TemperatureController controller1 = new c05_TemperatureController(20.0); 
//	        controller1.setTemperature(16);   //newTemp >= 16 && newTemp <= 23
//	    	c05_TemperatureController controller2 = new c05_TemperatureController(20.0); 
//	        controller2.setTemperature(15);   //newTemp > 23
//	    	c05_TemperatureController controller3 = new c05_TemperatureController(20.0); 
//	        controller3.setTemperature(24);   //newTemp < 16
	        
	    	// testcase-FT:
	    	c05_TemperatureController controller1 = new c05_TemperatureController(20.0); 
	        controller1.setTemperature(8);   
	    	c05_TemperatureController controller2 = new c05_TemperatureController(20.0); 
	        controller2.setTemperature(308);   
	    	c05_TemperatureController controller3 = new c05_TemperatureController(20.0); 
	        controller3.setTemperature(20);   
	    }
}