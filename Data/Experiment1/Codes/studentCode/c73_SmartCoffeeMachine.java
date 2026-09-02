package code;

class c73_SmartCoffeeMachine {
    private double targetTemperature;    
    private double currentTemperature;  
    private double brewTime;           
    private double coffeeStrength;      

    public c73_SmartCoffeeMachine(double targetTemperature, double initialTemperature, double baseBrewTime, double defaultStrength) {
        this.targetTemperature = targetTemperature;
        this.currentTemperature = initialTemperature;
        this.brewTime = baseBrewTime;
        this.coffeeStrength = defaultStrength;
    }

    public void updateBrewConditions(double tempChange, double strengthChange) {
        currentTemperature += tempChange;
        coffeeStrength += strengthChange;
        adjustBrewTime();

        System.out.printf("Current Temperature: %.2f°C, Coffee Strength: %.2f, Brew Time: %.2f minutes%n",
                          currentTemperature, coffeeStrength, brewTime);

        if (currentTemperature < targetTemperature - 5) {
            System.out.println("ALERT: Temperature too low, consider pre-heating.");
        } else if (currentTemperature > targetTemperature + 5) {
            System.out.println("ALERT: Temperature too high, risk of over-extraction.");
        }

        if (coffeeStrength < 3) {
            System.out.println("ALERT: Coffee too weak, consider adjusting grind size or amount.");
        } else if (coffeeStrength > 8) {
            System.out.println("ALERT: Coffee too strong, may be over-extracted.");
        }
    }

    private void adjustBrewTime() {
        if (currentTemperature < targetTemperature) {
            brewTime = brewTime * 1.1; 
        } else {
            brewTime = brewTime * 0.9;  
        }
    }

    public double getCycleTime() {
        return brewTime;
    }

    public double getCoffeeStrength() {
        return coffeeStrength;
    }

    public static void main(String[] args) {
    	c73_SmartCoffeeMachine machine = new c73_SmartCoffeeMachine(90.0, 80.0, 5.0, 5.0);

        // testcase-VT:
//        machine.updateBrewConditions(3.0, 2.0);  
//        machine.updateBrewConditions(10.0, -1.0); 
//        machine.updateBrewConditions(-15.0, 0.0);
//        machine.updateBrewConditions(15.0, -10.0);
//        machine.updateBrewConditions(9.0, 15.0);
//        machine.updateBrewConditions(-100.0, 15.0);
        
        // testcase-FT:
//        machine.updateBrewConditions(7.325806634504615E300, 0.0);  
//        machine.updateBrewConditions(-1.7976930616042493E308, 0.0); 
//        machine.updateBrewConditions(-9.058687296395083E307, -1.7976931348623157E308);
//        machine.updateBrewConditions(4.915567166162387E307, 0.0);
//        machine.updateBrewConditions(-4.9E-324, 0.0);
//        machine.updateBrewConditions(-4.9E-324, -9.058687296395083E307);
        
        // testcase-Z3:
//        machine.updateBrewConditions(3.0, 2.0);  
//        machine.updateBrewConditions(10.0, -1.0); 
//        machine.updateBrewConditions(-15.0, 0.0);
//        machine.updateBrewConditions(15.0, -10.0);
//        machine.updateBrewConditions(9.0, 15.0);
//        machine.updateBrewConditions(-100.0, 15.0);
        
        // testcase-UVT:
        machine.updateBrewConditions(3.0, 2.0);  
        machine.updateBrewConditions(10.0, -1.0); 
        machine.updateBrewConditions(-15.0, 0.0);
        machine.updateBrewConditions(15.0, -10.0);
        machine.updateBrewConditions(9.0, 15.0);
        machine.updateBrewConditions(-100.0, 15.0);
    }
}


