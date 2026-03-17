import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieManagement {
    private Movie head = null, tail = null;
    private Scanner sc = new Scanner(System.in);

    public void addMovie() {
        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        System.out.print("Enter Year of Release: ");
        int year = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble(); sc.nextLine();
        Movie newMovie = new Movie(title, director, year, rating);

        System.out.print("Add at 1) Beginning 2) End 3) Position: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            newMovie.next = head;
            if (head != null) head.prev = newMovie;
            head = newMovie;
            if (tail == null) tail = newMovie;
        } else if (choice == 2) {
            if (tail == null) {
                head = tail = newMovie;
            } else {
                tail.next = newMovie;
                newMovie.prev = tail;
                tail = newMovie;
            }
        } else {
            System.out.print("Enter position (starting from 1): ");
            int pos = sc.nextInt(); sc.nextLine();
            if (pos == 1) {
                newMovie.next = head;
                if (head != null) head.prev = newMovie;
                head = newMovie;
                if (tail == null) tail = newMovie;
            } else {
                Movie temp = head;
                for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
                if (temp != null) {
                    newMovie.next = temp.next;
                    if (temp.next != null) temp.next.prev = newMovie;
                    temp.next = newMovie;
                    newMovie.prev = temp;
                    if (newMovie.next == null) tail = newMovie;
                } else {
                    System.out.println("Position out of bounds. Adding at end.");
                    tail.next = newMovie;
                    newMovie.prev = tail;
                    tail = newMovie;
                }
            }
        }
        System.out.println("Movie added successfully!");
    }

    public void removeMovie() {
        System.out.print("Enter Movie Title to remove: ");
        String title = sc.nextLine();
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        System.out.println("Movie removed successfully!");
    }

    public void searchMovie() {
        System.out.print("Search by 1) Director 2) Rating: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter Director Name: ");
            String director = sc.nextLine();
            Movie temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.director.equalsIgnoreCase(director)) {
                    System.out.println(temp.title + " (" + temp.year + ") Rating: " + temp.rating);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) System.out.println("No movies found for this director.");
        } else if (choice == 2) {
            System.out.print("Enter Rating: ");
            double rating = sc.nextDouble(); sc.nextLine();
            Movie temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.rating == rating) {
                    System.out.println(temp.title + " (" + temp.year + ") Director: " + temp.director);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) System.out.println("No movies found with this rating.");
        }
    }

    public void updateRating() {
        System.out.print("Enter Movie Title to update rating: ");
        String title = sc.nextLine();
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        System.out.print("Enter new Rating: ");
        temp.rating = sc.nextDouble(); sc.nextLine();
        System.out.println("Rating updated successfully!");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = head;
        System.out.println("\nMovies in Forward Order:");
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") Director: " + temp.director + " Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = tail;
        System.out.println("\nMovies in Reverse Order:");
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") Director: " + temp.director + " Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Movie Management ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Search Movie");
            System.out.println("4. Update Rating");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> addMovie();
                case 2 -> removeMovie();
                case 3 -> searchMovie();
                case 4 -> updateRating();
                case 5 -> displayForward();
                case 6 -> displayBackward();
                case 7 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new MovieManagement().menu();
    }
}
