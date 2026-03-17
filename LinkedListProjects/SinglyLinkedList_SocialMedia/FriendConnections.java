import java.util.Scanner;
import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

public class FriendConnections {
    private User head = null;
    private Scanner sc = new Scanner(System.in);

    // Add a new user
    public void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        User newUser = new User(id, name, age);

        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added successfully!");
    }

    // Find user by ID
    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by name or ID
    public void searchUser() {
        System.out.print("Search by 1) ID 2) Name: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter User ID: ");
            int id = sc.nextInt(); sc.nextLine();
            User u = findUserById(id);
            if (u != null) {
                System.out.println("Found: " + u.name + ", Age: " + u.age + ", Friends: " + u.friends);
            } else System.out.println("User not found.");
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            User temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(name)) {
                    System.out.println("Found: ID " + temp.userId + ", Age: " + temp.age + ", Friends: " + temp.friends);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) System.out.println("User not found.");
        }
    }

    // Add friend connection
    public void addFriend() {
        System.out.print("Enter User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter Friend's User ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();

        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            if (!u1.friends.contains(id2)) u1.friends.add(id2);
            if (!u2.friends.contains(id1)) u2.friends.add(id1);
            System.out.println("Friend connection added.");
        } else System.out.println("One or both users not found.");
    }

    // Remove friend connection
    public void removeFriend() {
        System.out.print("Enter User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter Friend's User ID to remove: ");
        int id2 = sc.nextInt();
        sc.nextLine();

        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(id2));
            u2.friends.remove(Integer.valueOf(id1));
            System.out.println("Friend connection removed.");
        } else System.out.println("One or both users not found.");
    }

    // Display friends of a user
    public void displayFriends() {
        System.out.print("Enter User ID to display friends: ");
        int id = sc.nextInt(); sc.nextLine();
        User u = findUserById(id);
        if (u != null) {
            if (u.friends.isEmpty()) System.out.println("No friends.");
            else System.out.println("Friends of " + u.name + ": " + u.friends);
        } else System.out.println("User not found.");
    }

    // Find mutual friends
    public void mutualFriends() {
        System.out.print("Enter first User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter second User ID: ");
        int id2 = sc.nextInt(); sc.nextLine();

        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            ArrayList<Integer> mutual = new ArrayList<>();
            for (int f : u1.friends) if (u2.friends.contains(f)) mutual.add(f);
            if (mutual.isEmpty()) System.out.println("No mutual friends.");
            else System.out.println("Mutual friends: " + mutual);
        } else System.out.println("One or both users not found.");
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        if (temp == null) { System.out.println("No users."); return; }
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Social Media Friend Connections ---");
            System.out.println("1. Add User");
            System.out.println("2. Search User");
            System.out.println("3. Add Friend Connection");
            System.out.println("4. Remove Friend Connection");
            System.out.println("5. Display Friends");
            System.out.println("6. Mutual Friends");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch(choice) {
                case 1 -> addUser();
                case 2 -> searchUser();
                case 3 -> addFriend();
                case 4 -> removeFriend();
                case 5 -> displayFriends();
                case 6 -> mutualFriends();
                case 7 -> countFriends();
                case 8 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new FriendConnections().menu();
    }
}
