package code;
import java.util.*;

class Patient {
    private String name;
    private int severityScore;
    private long arrivalTime; 

    public Patient(String name, int severityScore) {
        this.name = name;
        this.severityScore = severityScore;
        this.arrivalTime = System.currentTimeMillis(); 
    }

    public String getName() {
        return name;
    }

    public int getSeverityScore() {
        return severityScore;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

class Hospital {
    private PriorityQueue<Patient> patientQueue;
    private List<String> treatmentLog;

    public Hospital() {
        this.treatmentLog = new ArrayList<>();
        this.patientQueue = new PriorityQueue<>((p1, p2) -> {
            if (p2.getSeverityScore() != p1.getSeverityScore()) {
                return Integer.compare(p2.getSeverityScore(), p1.getSeverityScore()); 
            } else {
                return Long.compare(p1.getArrivalTime(), p2.getArrivalTime()); 
            }
        });
    }

    public boolean admitPatient(String name, int severityScore) {
        if (severityScore >= 0 && severityScore <= 100) {
            Patient newPatient = new Patient(name, severityScore);
            patientQueue.add(newPatient);
            treatmentLog.add(String.format("Admitted: %s - Severity %d", name, severityScore));
            System.out.printf("Patient admitted: %s - Severity: %d%n", name, severityScore);
            return true;
        } else {
            System.out.println("Invalid severity score! Must be between 0 and 100.");
            return false;
        }
    }

    public void treatNextPatient() {
        if (!patientQueue.isEmpty()) {
            Patient next = patientQueue.poll();
            System.out.printf("Treating patient: %s - Severity: %d%n", next.getName(), next.getSeverityScore());
            treatmentLog.add(String.format("Treated: %s - Severity %d", next.getName(), next.getSeverityScore()));
        } else {
            System.out.println("No patients waiting for treatment.");
        }
    }

    public void printTreatmentLog() {
        System.out.println("\nTreatment History:");
        for (String log : treatmentLog) {
            System.out.println(log);
        }
    }
}

public class c11_MedicalDiagnosisSystem {
    public static void main(String[] args) throws InterruptedException {
        Hospital hospital = new Hospital();

        // testcase-VT:
//        hospital.admitPatient("Alice", 2);   
//        Thread.sleep(10); 
//        hospital.admitPatient("Bob", 93);    
//        Thread.sleep(10);
//        hospital.admitPatient("Charlie", -4); 
//        Thread.sleep(10);
//        hospital.admitPatient("David", 93);   
//        Thread.sleep(10);
//        hospital.admitPatient("Eve", 101);    
//        Thread.sleep(10);
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 

        // testcase-FT:
//        hospital.admitPatient("￥e-S", 1701211753);   
//        Thread.sleep(10); 
//        hospital.admitPatient("ezAo岣", 0);    
//        Thread.sleep(10);
//        hospital.admitPatient("???@", 0); 
//        Thread.sleep(10);
//        hospital.admitPatient("", 0);   
//        Thread.sleep(10);
//        hospital.admitPatient(" ??", 1701211699);    
//        Thread.sleep(10);
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 

        // testcase-Z3:
//        hospital.admitPatient("Alice", 4);   
//        Thread.sleep(10); 
//        hospital.admitPatient("Bob", -1);    
//        Thread.sleep(10);
//        hospital.admitPatient("Charlie", -1); 
//        Thread.sleep(10);
//        hospital.admitPatient("David", 101);   
//        Thread.sleep(10);
//        hospital.admitPatient("Eve", 101);    
//        Thread.sleep(10);
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
//        hospital.treatNextPatient(); 
        
        // testcase-UVT:
        hospital.admitPatient("Alice", 2);   
        Thread.sleep(10); 
        hospital.admitPatient("Bob", 93);    
        Thread.sleep(10);
        hospital.admitPatient("Charlie", -4); 
        Thread.sleep(10);
        hospital.admitPatient("David", 90);   
        Thread.sleep(10);
        hospital.admitPatient("Eve", 101);    
        Thread.sleep(10);
        hospital.treatNextPatient(); 
        hospital.treatNextPatient(); 
        hospital.treatNextPatient(); 
        hospital.treatNextPatient(); 
        hospital.treatNextPatient(); 
        
        hospital.printTreatmentLog();
    }
}
