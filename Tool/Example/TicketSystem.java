
import java.util.Scanner;
import java.util.Locale;

 public class TicketSystem {

    private static final double MIN_PRICE = 1.0;

    public enum TicketType {
        ADULT,        // 18 < age < 60, full price
        CHILD,        // 0 <= age <= 12, 50%
        TEEN,         // 12 < age <= 18, 75%
        SENIOR_60_69, // 60 <= age < 70, 75%
        SENIOR_70_79, // 70 <= age < 80, 50%
        FREE          // age >= 80, free
    }

    public static class TicketResult {
        public final double finalPrice;
        public final TicketType ticketType;
        public TicketResult(double finalPrice, TicketType ticketType) {
            this.finalPrice = finalPrice;
            this.ticketType = ticketType;
        }
        @Override
        public String toString() {
            return String.format("final_price=%.2f, ticket_type=%s", finalPrice, ticketType);
        }
    }

    public static TicketResult buyTicket(double age, double normalPrice) {
        if (!(normalPrice >= MIN_PRICE && age >= 0)) {
            throw new IllegalArgumentException("The age or normal price is not appropriate.");
        }
        if (age >= 80) {
            return new TicketResult(0.0, TicketType.FREE);
        } else if (age >= 70 && age < 80) {
            return new TicketResult(normalPrice * 0.5, TicketType.SENIOR_70_79);
        } else if (age >= 60 && age < 70) {
            return new TicketResult(normalPrice * 0.75, TicketType.SENIOR_60_69);
        } else if (age > 18 && age < 60) {
            return new TicketResult(normalPrice, TicketType.ADULT);
        } else if (age > 12 && age <= 18) {
            return new TicketResult(normalPrice * 0.75, TicketType.TEEN);
        } else { // 0 <= age <= 12
            return new TicketResult(normalPrice * 0.5, TicketType.CHILD);
        }
    }

    public static void displayTicketInfo(Double finalPrice, TicketType ticketType) {
        if (finalPrice != null) {
            System.out.printf(Locale.US, "final_price: %.2f%n", finalPrice);
        } else if (ticketType != null) {
            System.out.println("ticket_type: " + ticketType);
        }
    }

    public static void displayMessage(String warning, String errorMsg) {
        if (warning != null) {
            System.out.println("Warning: " + warning);
        } else if (errorMsg != null) {
            System.out.println("Error: " + errorMsg);
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
			in.useLocale(Locale.US);
			try {
			    System.out.print("age (int) : ");
			    int age = in.nextInt();
			    System.out.print("normal_price (real, e.g., 1200.0) : ");
			    double normal = in.nextDouble();

			    if (!(age >= 0 && normal >= MIN_PRICE)) {
			        displayMessage(null, "The age or normal price is not appropriate.");
			        return;
			    }

			    TicketResult res = buyTicket(age, normal);
			    displayTicketInfo(res.finalPrice, null);
			    displayTicketInfo(null, res.ticketType);
			} catch (Exception ex) {
			    displayMessage(null, ex.getMessage() != null ? ex.getMessage() : "Unexpected error.");
			}
		}
    }
}
