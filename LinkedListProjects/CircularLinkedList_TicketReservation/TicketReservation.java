import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private Scanner sc = new Scanner(System.in);

    // Add ticket at end
    public void addTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String customer = sc.nextLine();
        System.out.print("Enter Movie Name: ");
        String movie = sc.nextLine();
        System.out.print("Enter Seat Number: ");
        String seat = sc.nextLine();
        System.out.print("Enter Booking Time: ");
        String time = sc.nextLine();

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket added successfully!");
    }

    // Remove ticket by ID
    public void removeTicket() {
        System.out.print("Enter Ticket ID to remove: ");
        int id = sc.nextInt(); sc.nextLine();

        if (head == null) { System.out.println("No tickets to remove."); return; }

        // If head is the ticket to remove
        if (head.ticketId == id) {
            if (head == tail) { // Only one ticket
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Ticket removed successfully.");
            return;
        }

        Ticket curr = head.next;
        Ticket prev = head;
        boolean found = false;
        while (curr != head) {
            if (curr.ticketId == id) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (found) System.out.println("Ticket removed successfully.");
        else System.out.println("Ticket ID not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) { System.out.println("No tickets booked."); return; }
        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                               ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName +
                               ", Seat: " + temp.seatNumber +
                               ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer or Movie Name
    public void searchTicket() {
        System.out.print("Search by 1) Customer Name 2) Movie Name: ");
        int choice = sc.nextInt(); sc.nextLine();
        System.out.print("Enter search term: ");
        String term = sc.nextLine();

        if (head == null) { System.out.println("No tickets booked."); return; }

        Ticket temp = head;
        boolean found = false;
        do {
            if ((choice == 1 && temp.customerName.equalsIgnoreCase(term)) ||
                (choice == 2 && temp.movieName.equalsIgnoreCase(term))) {
                System.out.println("Ticket ID: " + temp.ticketId +
                                   ", Customer: " + temp.customerName +
                                   ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber +
                                   ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No matching tickets found.");
    }

    // Count total tickets
    public void countTickets() {
        if (head == null) { System.out.println("Total tickets booked: 0"); return; }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total tickets booked: " + count);
    }

    // Menu for console interaction
    public void menu() {
        while (true) {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch(choice) {
                case 1 -> addTicket();
                case 2 -> removeTicket();
                case 3 -> displayTickets();
                case 4 -> searchTicket();
                case 5 -> countTickets();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new TicketReservationSystem().menu();
    }
}
