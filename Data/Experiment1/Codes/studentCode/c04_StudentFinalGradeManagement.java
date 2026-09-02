package code;

public class c04_StudentFinalGradeManagement {

    public static boolean recordFinalGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            System.out.printf("Final grade recorded successfully! Grade: %d%n", grade);
            return true;
        } else {
            System.out.println("Grade recording failed! Invalid grade.");
            return false;
        }
    }

    public static void main(String[] args) {
        // testcase-VT:
        recordFinalGrade(72); // grade >= 0 && grade <= 100
        recordFinalGrade(-2); // grade <  0   
        recordFinalGrade(223); // grade > 100
        
        // testcase-FT:
//        recordFinalGrade(4156828); 
//        recordFinalGrade(2); 
//        recordFinalGrade(126); 
    	
        // testcase-Z3:
//      recordFinalGrade(4); 
//      recordFinalGrade(-1);
//      recordFinalGrade(101);
      
      // testcase-UVT:
//      recordFinalGrade(41); 
//      recordFinalGrade(-2); 
//      recordFinalGrade(126); 
    }
    
}

