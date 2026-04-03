import java.util.Scanner;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book next, prev;

    public Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
    }
}

public class LibraryManagement {
    private Book head = null, tail = null;
    private Scanner sc = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Is Available? (true/false): ");
        boolean available = sc.nextBoolean(); sc.nextLine();
        Book newBook = new Book(title, author, genre, id, available);

        System.out.print("Add at 1) Beginning 2) End 3) Position: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 1) {
            newBook.next = head;
            if (head != null) head.prev = newBook;
            head = newBook;
            if (tail == null) tail = newBook;
        } else if (choice == 2) {
            if (tail == null) { head = tail = newBook; }
            else { tail.next = newBook; newBook.prev = tail; tail = newBook; }
        } else {
            System.out.print("Enter position (starting 1): ");
            int pos = sc.nextInt(); sc.nextLine();
            if (pos == 1) {
                newBook.next = head;
                if (head != null) head.prev = newBook;
                head = newBook;
                if (tail == null) tail = newBook;
            } else {
                Book temp = head;
                for (int i = 1; i < pos-1 && temp != null; i++) temp = temp.next;
                if (temp != null) {
                    newBook.next = temp.next;
                    if (temp.next != null) temp.next.prev = newBook;
                    temp.next = newBook;
                    newBook.prev = temp;
                    if (newBook.next == null) tail = newBook;
                } else {
                    tail.next = newBook;
                    newBook.prev = tail;
                    tail = newBook;
                }
            }
        }
        System.out.println("Book added successfully!");
    }

    public void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt(); sc.nextLine();
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) { System.out.println("Book not found."); return; }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        System.out.println("Book removed successfully!");
    }

    public void searchBook() {
        System.out.print("Search by 1) Title 2) Author: ");
        int choice = sc.nextInt(); sc.nextLine();
        boolean found = false;
        if (choice == 1) {
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            Book temp = head;
            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    System.out.println("Found: ID=" + temp.id + ", Author=" + temp.author + ", Genre=" + temp.genre + ", Available=" + temp.available);
                    found = true;
                }
                temp = temp.next;
            }
        } else {
            System.out.print("Enter Author: ");
            String author = sc.nextLine();
            Book temp = head;
            while (temp != null) {
                if (temp.author.equalsIgnoreCase(author)) {
                    System.out.println("Found: ID=" + temp.id + ", Title=" + temp.title + ", Genre=" + temp.genre + ", Available=" + temp.available);
                    found = true;
                }
                temp = temp.next;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    public void updateAvailability() {
        System.out.print("Enter Book ID to update availability: ");
        int id = sc.nextInt(); sc.nextLine();
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp != null) {
            System.out.print("Is Available? (true/false): ");
            temp.available = sc.nextBoolean(); sc.nextLine();
            System.out.println("Availability updated.");
        } else System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) { System.out.println("Library empty."); return; }
        System.out.println("\nBooks (Forward):");
        Book temp = head;
        while (temp != null) {
            System.out.println("ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author + ", Genre=" + temp.genre + ", Available=" + temp.available);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("Library empty."); return; }
        System.out.println("\nBooks (Reverse):");
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author + ", Genre=" + temp.genre + ", Available=" + temp.available);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) { count++; temp = temp.next; }
        System.out.println("Total number of books: " + count);
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Update Availability");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
            System.out.println("7. Count Books");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBook();
                case 4 -> updateAvailability();
                case 5 -> displayForward();
                case 6 -> displayBackward();
                case 7 -> countBooks();
                case 8 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new LibraryManagement().menu();
    }
}
