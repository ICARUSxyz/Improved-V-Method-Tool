package code;
import java.util.*;

class Flight {
    private String flightNumber;
    private int economySeats;
    private int businessSeats;
    private Queue<String> waitingList;
    private List<String> bookingHistory;

    public Flight(String flightNumber, int economySeats, int businessSeats) {
        this.flightNumber = flightNumber;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.waitingList = new LinkedList<>();
        this.bookingHistory = new ArrayList<>();
    }

    public boolean bookSeat(String passenger, boolean isBusinessClass) {
        if (isBusinessClass) {
            if (businessSeats > 0) {
                businessSeats--;
                bookingHistory.add(String.format("Booking: %s in Business Class, Remaining: %d", passenger, businessSeats));
                System.out.printf("Booking successful! %s assigned to Business Class. Remaining: %d%n", passenger, businessSeats);
                return true;
            }
        } else {
            if (economySeats > 0) {
                economySeats--;
                bookingHistory.add(String.format("Booking: %s in Economy Class, Remaining: %d", passenger, economySeats));
                System.out.printf("Booking successful! %s assigned to Economy Class. Remaining: %d%n", passenger, economySeats);
                return true;
            }
        }

        waitingList.add(passenger);
        System.out.printf("Flight full! %s added to the waiting list.%n", passenger);
        return false;
    }

    public boolean cancelBooking(String passenger, boolean isBusinessClass) {
        if (isBusinessClass) {
            businessSeats++;
        } else {
            economySeats++;
        }

        bookingHistory.add(String.format("Cancellation: %s, Seat released", passenger));
        System.out.printf("Booking canceled: %s. Seat is now available.%n", passenger);

        if (!waitingList.isEmpty()) {
            String nextPassenger = waitingList.poll();
            bookSeat(nextPassenger, isBusinessClass);
            System.out.printf("Notifying waiting list passenger: %s%n", nextPassenger);
        }
        return true;
    }

    public void printBookingHistory() {
        System.out.println("Booking History for Flight " + flightNumber + ":");
        for (String log : bookingHistory) {
            System.out.println(log);
        }
    }
}

public class c08_FlightBookingSystem {
    public static void main(String[] args) {
        
        // testcase-VT:
//    	Flight flight = new Flight("HU789", 2, 1);
//        flight.bookSeat("Alice", false); 
//        flight.bookSeat("Bob", false);   
//        flight.bookSeat("Charlie", false); 
//        flight.bookSeat("David", true);  
//        flight.bookSeat("Eve", true);    
//        flight.cancelBooking("Bob", false); 
//        flight.cancelBooking("David", true); 
//        flight.cancelBooking("Alice", true);
//        flight.printBookingHistory();
        
     // testcase-FT:
//    	Flight flight1 = new Flight("HU123", 2, 2);
//        flight1.bookSeat("z?p", false); 
//        flight1.bookSeat("z?", false);   
//        flight1.bookSeat("UU", false); 
//        flight1.bookSeat("???-w", true);  
//    	Flight flight2 = new Flight("HU123", 2, 0);
//        flight2.bookSeat("???-s", true); 
//        flight2.bookSeat("sad?", true);   
//        flight2.bookSeat("sADD", false); 
//        flight2.bookSeat("?ad---s", true); 
        
     // testcase-Z3:
//    	Flight flight = new Flight("HU789", 2, -1);
//        flight.bookSeat("Alice", false); 
//        flight.bookSeat("Bob", false);   
//        flight.bookSeat("Charlie", false); 
//        flight.bookSeat("David", true);  
//        flight.bookSeat("Eve", true);    
//        Flight flight2 = new Flight("HU123", 2, 0);
//        flight.bookSeat("David", true);  
//        flight.bookSeat("Eve", true);  
//        flight.bookSeat("David", true);  
//        flight.printBookingHistory();
        
     // testcase-UVT:
    	Flight flight = new Flight("HU789", 2, -1);
        flight.bookSeat("Alice", false); 
        flight.bookSeat("Bob", false);   
        flight.bookSeat("Charlie", false); 
        flight.bookSeat("David", true);  
        flight.bookSeat("Eve", true);    
        Flight flight2 = new Flight("HU123", 2, 0);
        flight2.bookSeat("David", true);  
        flight2.bookSeat("Eve", true);  
        flight.cancelBooking("David", true); 
        flight.printBookingHistory();
    }
}
