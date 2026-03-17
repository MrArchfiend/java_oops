import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private Item head = null;
    private Scanner sc = new Scanner(System.in);

    // Add item at beginning, end, or position
    public void addItem() {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        Item newItem = new Item(name, id, quantity, price);

        System.out.print("Add at 1) Beginning 2) End 3) Position: ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice == 1) {
            newItem.next = head;
            head = newItem;
        } else if (choice == 2) {
            if (head == null) head = newItem;
            else {
                Item temp = head;
                while (temp.next != null) temp = temp.next;
                temp.next = newItem;
            }
        } else {
            System.out.print("Enter position (starting from 1): ");
            int pos = sc.nextInt(); sc.nextLine();
            if (pos == 1) {
                newItem.next = head;
                head = newItem;
            } else {
                Item temp = head;
                for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
                if (temp != null) {
                    newItem.next = temp.next;
                    temp.next = newItem;
                } else {
                    System.out.println("Position out of bounds. Adding at end.");
                    temp = head;
                    while (temp.next != null) temp = temp.next;
                    temp.next = newItem;
                }
            }
        }
        System.out.println("Item added successfully!");
    }

    public void removeItem() {
        System.out.print("Enter Item ID to remove: ");
        int id = sc.nextInt();
        if (head == null) { System.out.println("Inventory is empty."); return; }
        if (head.id == id) { head = head.next; System.out.println("Item removed."); return; }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        } else System.out.println("Item not found.");
    }

    public void updateQuantity() {
        System.out.print("Enter Item ID to update quantity: ");
        int id = sc.nextInt();
        Item temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp != null) {
            System.out.print("Enter new Quantity: ");
            temp.quantity = sc.nextInt();
            System.out.println("Quantity updated.");
        } else System.out.println("Item not found.");
    }

    public void searchItem() {
        System.out.print("Search by 1) ID 2) Name: ");
        int choice = sc.nextInt(); sc.nextLine();
        boolean found = false;
        if (choice == 1) {
            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();
            Item temp = head;
            while (temp != null) {
                if (temp.id == id) {
                    System.out.println("Found: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                    found = true;
                    break;
                }
                temp = temp.next;
            }
        } else {
            System.out.print("Enter Item Name: ");
            String name = sc.nextLine();
            Item temp = head;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(name)) {
                    System.out.println("Found: ID " + temp.id + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                    found = true;
                }
                temp = temp.next;
            }
        }
        if (!found) System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Merge sort by name or price
    private Item mergeSort(Item node, String type, boolean ascending) {
        if (node == null || node.next == null) return node;
        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(node, type, ascending);
        Item right = mergeSort(nextOfMiddle, type, ascending);

        return sortedMerge(left, right, type, ascending);
    }

    private Item sortedMerge(Item a, Item b, String type, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition = false;
        if (type.equalsIgnoreCase("name")) {
            condition = ascending ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) >= 0;
        } else if (type.equalsIgnoreCase("price")) {
            condition = ascending ? a.price <= b.price : a.price >= b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, type, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, type, ascending);
            return b;
        }
    }

    private Item getMiddle(Item node) {
        if (node == null) return node;
        Item slow = node, fast = node.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) { slow = slow.next; fast = fast.next; }
        }
        return slow;
    }

    public void sortInventory() {
        System.out.print("Sort by 1) Name 2) Price: ");
        int choice = sc.nextInt(); sc.nextLine();
        System.out.print("Order 1) Ascending 2) Descending: ");
        boolean ascending = sc.nextInt() == 1; sc.nextLine();

        String type = (choice == 1) ? "name" : "price";
        head = mergeSort(head, type, ascending);
        System.out.println("Inventory sorted by " + type + (ascending ? " ascending." : " descending."));
    }

    public void displayAll() {
        if (head == null) { System.out.println("Inventory empty."); return; }
        Item temp = head;
        System.out.println("\nInventory:");
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Calculate Total Value");
            System.out.println("6. Sort Inventory");
            System.out.println("7. Display All Items");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> updateQuantity();
                case 4 -> searchItem();
                case 5 -> calculateTotalValue();
                case 6 -> sortInventory();
                case 7 -> displayAll();
                case 8 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new InventoryManagement().menu();
    }
}
