package code;

import java.util.*;

class WaterRequest {
    private String sector; 
    private double requestedAmount; 

    public WaterRequest(String sector, double requestedAmount) {
        this.sector = sector;
        this.requestedAmount = requestedAmount;
    }

    public String getSector() {
        return sector;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}

class WaterResourceManager {
    private double totalWaterSupply; 
    private Map<String, Double> sectorPriority; 
    private List<String> allocationLog;

    public WaterResourceManager(double totalWaterSupply) {
        this.totalWaterSupply = totalWaterSupply;
        this.sectorPriority = new HashMap<>();
        this.allocationLog = new ArrayList<>();

        sectorPriority.put("Agriculture", 1.5);
        sectorPriority.put("Residential", 1.0);
        sectorPriority.put("Industry", 0.8);
    }

    public void allocateWater(List<WaterRequest> requests) {
        double totalDemand = requests.stream().mapToDouble(WaterRequest::getRequestedAmount).sum();

        if (totalDemand <= totalWaterSupply) {
            for (WaterRequest req : requests) {
                allocateSectorWater(req.getSector(), req.getRequestedAmount());
            }
        } else {
            System.out.println("Water supply insufficient! Implementing rationing...");
            enforceRationing(requests, totalDemand);
        }
    }

    private void allocateSectorWater(String sector, double amount) {
        totalWaterSupply -= amount;
        allocationLog.add(String.format("Allocated: %.2f cubic meters to %s", amount, sector));
        System.out.printf("Allocated %.2f cubic meters to %s%n", amount, sector);
    }

    private void enforceRationing(List<WaterRequest> requests, double totalDemand) {
        double scalingFactor = totalWaterSupply / totalDemand;
        
        requests.sort((a, b) -> Double.compare(sectorPriority.get(b.getSector()), sectorPriority.get(a.getSector())));

        for (WaterRequest req : requests) {
            double allocatedAmount = req.getRequestedAmount() * scalingFactor * sectorPriority.get(req.getSector());
            allocateSectorWater(req.getSector(), allocatedAmount);
        }
    }

    public void printAllocationLog() {
        System.out.println("\nWater Allocation Log:");
        for (String log : allocationLog) {
            System.out.println(log);
        }
    }
}

public class c14_SmartWaterSystem {
    public static void main(String[] args) {
    	
//    	//testcase-VT:
//        WaterResourceManager manager1 = new WaterResourceManager(500); 
//        List<WaterRequest> requests1 = Arrays.asList(
//            new WaterRequest("Agriculture", 489),
//            new WaterRequest("Industry", 479),
//            new WaterRequest("Residential", 521)
//        );
//        manager1.allocateWater(requests1);
//        manager1.printAllocationLog(); 
//        
//        WaterResourceManager manager2 = new WaterResourceManager(500); 
//        List<WaterRequest> requests2 = Arrays.asList(
//            new WaterRequest("Agriculture", -234),
//            new WaterRequest("Industry", -24),
//            new WaterRequest("Residential", 0)
//        );
//        manager2.allocateWater(requests2); 
//        manager2.printAllocationLog(); 
//        
//        WaterResourceManager manager3 = new WaterResourceManager(500); 
//        List<WaterRequest> requests3 = Arrays.asList(
//            new WaterRequest("Agriculture", 327),
//            new WaterRequest("Industry", 21),
//            new WaterRequest("Residential", 94)
//        );
//        manager3.allocateWater(requests3);
//        manager3.printAllocationLog(); 
        
    	//testcase-FT:
//        WaterResourceManager manager1 = new WaterResourceManager(500); 
//        List<WaterRequest> requests1 = Arrays.asList(
//            new WaterRequest("Agriculture", 4.185580251239443E298),
//            new WaterRequest("Industry", 0),
//            new WaterRequest("Residential", 0)
//        );
//        manager1.allocateWater(requests1);
//        manager1.printAllocationLog(); 
//        
//        WaterResourceManager manager2 = new WaterResourceManager(500); 
//        List<WaterRequest> requests2 = Arrays.asList(
//            new WaterRequest("Agriculture", -1.7976931348623157E308),
//            new WaterRequest("Industry", 0),
//            new WaterRequest("Residential", 0)
//        );
//        manager2.allocateWater(requests2); 
//        manager2.printAllocationLog(); 
//        
//        WaterResourceManager manager3 = new WaterResourceManager(500); 
//        List<WaterRequest> requests3 = Arrays.asList(
//            new WaterRequest("Agriculture", 0),
//            new WaterRequest("Industry", 4.9E-324),
//            new WaterRequest("Residential", 1.559333923860884E298)
//        );
//        manager3.allocateWater(requests3);
//        manager3.printAllocationLog(); 
    	
    	//testcase-Z3:
//        WaterResourceManager manager1 = new WaterResourceManager(500); 
//        List<WaterRequest> requests1 = Arrays.asList(
//            new WaterRequest("Agriculture", 0),
//            new WaterRequest("Industry", 0),
//            new WaterRequest("Residential", 0)
//        );
//        manager1.allocateWater(requests1);
//        manager1.printAllocationLog(); 
//        
//        WaterResourceManager manager2 = new WaterResourceManager(500); 
//        List<WaterRequest> requests2 = Arrays.asList(
//            new WaterRequest("Agriculture", -1),
//            new WaterRequest("Industry", -1),
//            new WaterRequest("Residential", -1)
//        );
//        manager2.allocateWater(requests2); 
//        manager2.printAllocationLog(); 
//        
//        WaterResourceManager manager3 = new WaterResourceManager(500); 
//        List<WaterRequest> requests3 = Arrays.asList(
//            new WaterRequest("Agriculture", 501),
//            new WaterRequest("Industry", 501),
//            new WaterRequest("Residential", 501)
//        );
//        manager3.allocateWater(requests3);
//        manager3.printAllocationLog(); 
        
    	//testcase-UVT:
        WaterResourceManager manager1 = new WaterResourceManager(500); 
        List<WaterRequest> requests1 = Arrays.asList(
            new WaterRequest("Agriculture", 489),
            new WaterRequest("Industry", 479),
            new WaterRequest("Residential", 521)
        );
        manager1.allocateWater(requests1);
        manager1.printAllocationLog(); 
        
        WaterResourceManager manager2 = new WaterResourceManager(500); 
        List<WaterRequest> requests2 = Arrays.asList(
            new WaterRequest("Agriculture", -234),
            new WaterRequest("Industry", -24),
            new WaterRequest("Residential", 0)
        );
        manager2.allocateWater(requests2); 
        manager2.printAllocationLog(); 
        
        WaterResourceManager manager3 = new WaterResourceManager(500); 
        List<WaterRequest> requests3 = Arrays.asList(
            new WaterRequest("Agriculture", 327),
            new WaterRequest("Industry", 21),
            new WaterRequest("Residential", 94)
        );
        manager3.allocateWater(requests3);
        manager3.printAllocationLog(); 
    }
}
