package code;

import java.util.*;

class Student16 {
    private String name;

    public Student16(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private int capacity;
    private Set<String> enrolledStudents;
    private Queue<String> waitingList;
    private List<String> enrollmentLog;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new HashSet<>();
        this.waitingList = new LinkedList<>();
        this.enrollmentLog = new ArrayList<>();
    }

    public void enrollStudent(String studentName) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentName);
            enrollmentLog.add(String.format("Enrolled: %s in %s", studentName, courseName));
            System.out.printf("Enrollment successful! %s registered for %s.%n", studentName, courseName);
        } else {
            waitingList.add(studentName);
            enrollmentLog.add(String.format("Waiting list: %s added to %s", studentName, courseName));
            System.out.printf("Course full! %s added to the waiting list for %s.%n", studentName, courseName);
        }
    }

    public void dropStudent(String studentName) {
        if (enrolledStudents.contains(studentName)) {
            enrolledStudents.remove(studentName);
            enrollmentLog.add(String.format("Dropped: %s from %s", studentName, courseName));
            System.out.printf("Student %s dropped from %s.%n", studentName, courseName);

            if (!waitingList.isEmpty()) {
                String nextStudent = waitingList.poll();
                enrolledStudents.add(nextStudent);
                enrollmentLog.add(String.format("Moved from waiting list: %s enrolled in %s", nextStudent, courseName));
                System.out.printf("Next in line: %s is now enrolled in %s.%n", nextStudent, courseName);
            }
        } else {
            System.out.printf("Student %s is not enrolled in %s.%n", studentName, courseName);
        }
    }

    public void printEnrollmentLog() {
        System.out.println("\nEnrollment Log for " + courseName + ":");
        for (String log : enrollmentLog) {
            System.out.println(log);
        }
    }
}

public class c16_OnlineCourseSystem {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Programming", 2);

        // testcase-VT:
//        javaCourse.enrollStudent("Alice"); 
//        javaCourse.enrollStudent("Bob");   
//        javaCourse.enrollStudent("Charlie");
//        javaCourse.enrollStudent("David");   
//        javaCourse.dropStudent("Bob"); 
//        javaCourse.dropStudent("Eve"); 
//        javaCourse.dropStudent("Alice");
//        javaCourse.dropStudent("David");
        
        // testcase-FT:
//        javaCourse.enrollStudent("??"); 
//        javaCourse.enrollStudent("safh2");   
//        javaCourse.enrollStudent("");
//        javaCourse.enrollStudent("e33-d");   
//        javaCourse.dropStudent("??w?"); 
//        javaCourse.enrollStudent("jio");   
//        javaCourse.enrollStudent("  ");
//        javaCourse.enrollStudent("u4D-d"); 

        // testcase-Z3:
//        javaCourse.enrollStudent("Charlie"); 
//        javaCourse.enrollStudent("Bob");   
//        javaCourse.enrollStudent("");
//        javaCourse.enrollStudent("e33-d");   
//        javaCourse.dropStudent("??w?"); 
//        javaCourse.enrollStudent("jio");   
//        javaCourse.enrollStudent("  ");
//        javaCourse.enrollStudent("u4D-d"); 
        
        // testcase-UVT:
        javaCourse.enrollStudent("Charlie"); 
        javaCourse.enrollStudent("safh2");   
        javaCourse.enrollStudent("");
        javaCourse.enrollStudent("e33-d");   
        javaCourse.dropStudent("Bob"); 
        javaCourse.dropStudent("Charlie");   
        javaCourse.enrollStudent("David");
        javaCourse.enrollStudent("David"); 
        javaCourse.printEnrollmentLog(); 
    }
}

