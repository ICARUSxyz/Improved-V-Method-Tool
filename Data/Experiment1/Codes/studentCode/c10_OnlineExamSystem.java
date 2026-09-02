package code;
import java.util.*;

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

class ExamSystem {
    private List<Student> students;
    private List<String> rankingHistory;

    public ExamSystem() {
        this.students = new ArrayList<>();
        this.rankingHistory = new ArrayList<>();
    }

    public boolean recordScore(String name, double score) {
        if (score >= 0 && score <= 100) {
            students.add(new Student(name, score));
            rankingHistory.add(String.format("Recorded: %s - %.1f", name, score));
            System.out.printf("Score recorded: %s - %.1f%n", name, score);
            return true;
        } else {
            System.out.println("Invalid score! Must be between 0 and 100.");
            return false;
        }
    }

    public void rankStudents() {
        students.sort((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()));
        System.out.println("\nExam Rankings:");
        for (int i = 0; i < students.size(); i++) {
            String distinction = (students.get(i).getScore() > 90) ? " (Distinction)" : "";
            System.out.printf("%d. %s - %.1f%s%n", i + 1, students.get(i).getName(), students.get(i).getScore(), distinction);
            rankingHistory.add(String.format("Ranked: %d. %s - %.1f%s", i + 1, students.get(i).getName(), students.get(i).getScore(), distinction));
        }
    }

    public void printRankingHistory() {
        System.out.println("\nRanking History:");
        for (String log : rankingHistory) {
            System.out.println(log);
        }
    }
}

public class c10_OnlineExamSystem {
    public static void main(String[] args) {
        ExamSystem exam = new ExamSystem();

        // testcase-VT:
//        exam.recordScore("Alice", -1.53);   // score < 0
//        exam.recordScore("Bob", 2.78);     // score >= 0 && score <= 90
//        exam.recordScore("Charlie", 92.64); // score > 90 && score <= 100
//        exam.recordScore("David", 104.22);     // score > 100

        // testcase-FT:
//        exam.recordScore("Alice", 7.022238808055921E305);   
//        exam.recordScore("Bob", 1.7976931348623157E308);   
//        exam.recordScore("Charlie", 0.0); 
//        exam.recordScore("David", -2.2250738585072014E-308);  

        // testcase-Z3:
//        exam.recordScore("Alice", 90);   // score < 0
//        exam.recordScore("Bob", 79);     // score >= 0 && score <= 90
//        exam.recordScore("Charlie", 101); // score > 90 && score <= 100
//        exam.recordScore("David", 79);     // score > 100
        
        // testcase-UVT:
      exam.recordScore("Alice", 90);   // score < 0
      exam.recordScore("Bob", 79);     // score >= 0 && score <= 90
      exam.recordScore("Charlie", 101); // score > 90 && score <= 100
      exam.recordScore("David", -7);     // score > 100
        
        exam.rankStudents();

        exam.printRankingHistory();
    }
}
