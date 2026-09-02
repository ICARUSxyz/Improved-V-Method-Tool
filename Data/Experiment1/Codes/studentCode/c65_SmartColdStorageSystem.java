package code;

class SmartColdStorage65 {
    private double maxTemperature;
    private double minTemperature;
    private double currentTemperature;
    private boolean coolingSystemActive;

    public SmartColdStorage65(double maxTemperature, double minTemperature, double initialTemperature) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.currentTemperature = initialTemperature;
        this.coolingSystemActive = false;
    }

    public void updateTemperature(double changeAmount) {
        currentTemperature += changeAmount;
        manageCoolingSystem();

        System.out.printf("Current Storage Temperature: %.2f°C\n", currentTemperature);
        if (coolingSystemActive) {
            System.out.println("Cooling System Activated.");
        } else {
            System.out.println("Cooling System Deactivated.");
        }
    }

    private void manageCoolingSystem() {
        if (currentTemperature > maxTemperature) {
            coolingSystemActive = true;
        } else if (currentTemperature < minTemperature) {
            coolingSystemActive = false;
        }
    }
}

public class c65_SmartColdStorageSystem {
    public static void main(String[] args) {
        SmartColdStorage65 coldStorage = new SmartColdStorage65(5.0, -5.0, 0.0); 

        // testcase-VT:
//        coldStorage.updateTemperature(6.0);   
//        coldStorage.updateTemperature(-4.0);  
//        coldStorage.updateTemperature(-7.0); 
//        coldStorage.updateTemperature(-12.0); 
//        coldStorage.updateTemperature(3.0); 
        
        // testcase-FT:
//        coldStorage.updateTemperature(1.6349721113176986E296);   
//        coldStorage.updateTemperature(-1.7976931348623157E308);  
//        coldStorage.updateTemperature(1.0222176649217088E308); 
//        coldStorage.updateTemperature(1.0432843813458766E308); 
//        coldStorage.updateTemperature(0.0); 
        
        // testcase-Z3:
//        coldStorage.updateTemperature(6.0);   
//        coldStorage.updateTemperature(-4.0);  
//        coldStorage.updateTemperature(-7.0); 
//        coldStorage.updateTemperature(-12.0); 
//        coldStorage.updateTemperature(3.0); 
        
        // testcase-UVT:
        coldStorage.updateTemperature(6.0);   
        coldStorage.updateTemperature(-4.0);  
        coldStorage.updateTemperature(-7.0); 
        coldStorage.updateTemperature(-12.0); 
        coldStorage.updateTemperature(3.0); 
    }
}
