package code;

public class c83_SmartPool {

    private double optimalLow;   
    private double optimalHigh;  
    private double currentPH;   

    public c83_SmartPool(double optimalLow, double optimalHigh, double initialPH) {
        this.optimalLow = optimalLow;
        this.optimalHigh = optimalHigh;
        this.currentPH = initialPH;
    }

    public void updatePH(double newPH) {
        currentPH = newPH;
        System.out.printf("Current pH: %.2f%n", currentPH);
        if (currentPH < optimalLow) {
            System.out.println("ALERT: pH is too low. Dosing alkaline chemicals to raise pH.");
        } else if (currentPH > optimalHigh) {
            System.out.println("ALERT: pH is too high. Dosing acidic chemicals to lower pH.");
        } else {
            System.out.println("pH is optimal. No chemical dosing required.");
        }
    }

    public double getCurrentPH() {
        return currentPH;
    }

    public static void main(String[] args) {
    	c83_SmartPool pool = new c83_SmartPool(7.2, 7.8, 7.5);

        // testcase-VT:
//        pool.updatePH(6.8);  
//        pool.updatePH(7.5);  
//        pool.updatePH(8.0);  
        
        // testcase-FT:
//        pool.updatePH(-1.7976931348623157E308);  
//        pool.updatePH(1.0622392272425998E291);  
//        pool.updatePH(2.7308318922745074E293);
        
        // testcase-Z3:
//        pool.updatePH(6.8);  
//        pool.updatePH(7.5);  
//        pool.updatePH(8.0);  
        
        // testcase-UVT:
        pool.updatePH(6.8);  
        pool.updatePH(7.5);  
        pool.updatePH(8.0);  
    }
}
