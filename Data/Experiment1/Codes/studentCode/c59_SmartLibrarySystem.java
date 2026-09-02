package code;

import java.util.*;

class Book {
    private String title;
    private int totalCopies;
    private int availableCopies;
    private Queue<String> waitlist;
    private List<String> log;

    public Book(String title, int totalCopies) {
        this.title = title;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.waitlist = new LinkedList<>();
        this.log = new ArrayList<>();
    }

    public void borrowBook(String user) {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.printf("%s borrowed '%s' | Available Copies: %d/%d%n", user, title, availableCopies, totalCopies);
            log.add(String.format("%s borrowed | Remaining: %d/%d", user, availableCopies, totalCopies));
        } else {
            waitlist.add(user);
            System.out.printf("No copies available. %s added to the waiting list for '%s'.%n", user, title);
            log.add(String.format("%s added to waitlist | No copies available", user));
        }
    }

    public void returnBook(String user) {
        if (!waitlist.isEmpty()) {
            String nextUser = waitlist.poll();
            System.out.printf("%s returned '%s'. %s can now borrow it.%n", user, title, nextUser);
            log.add(String.format("%s returned | Assigned to %s", user, nextUser));
        } else {
            availableCopies = Math.min(totalCopies, availableCopies + 1);
            System.out.printf("%s returned '%s' | Available Copies: %d/%d%n", user, title, availableCopies, totalCopies);
            log.add(String.format("%s returned | Available: %d/%d", user, availableCopies, totalCopies));
        }
    }

    public void printLog() {
        System.out.printf("\n'%s' Loan Log:%n", title);
        for (String logEntry : log) {
            System.out.println(logEntry);
        }
    }
}

public class c59_SmartLibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Machine Learning Basics", 2);

        // testcase-VT:
//        book1.borrowBook("Alice"); 
//        book1.borrowBook("Bob");   
//        book1.borrowBook("Charlie");
//        book1.returnBook("Alice");  
//        book1.returnBook("Bob");    
//        book1.printLog(); 
        
        // testcase-FT:
//        book1.borrowBook(""); 
//        book1.borrowBook("o");   
//        book1.borrowBook("A");
//        book1.borrowBook("??");  
//        book1.borrowBook("G4u");    
//        book1.printLog(); 
        
        // testcase-Z3:
//        book1.borrowBook("Alice"); 
//        book1.borrowBook("Bob");   
//        book1.borrowBook("Charlie");
//        book1.returnBook("Alice");  
//        book1.returnBook("Bob");    
//        book1.printLog(); 
        
        // testcase-UVT:
        book1.borrowBook("Alice"); 
        book1.borrowBook("Bob");   
        book1.borrowBook("Charlie");
        book1.returnBook("Alice");  
        book1.returnBook("Bob");    
        book1.printLog(); 
    }
}

