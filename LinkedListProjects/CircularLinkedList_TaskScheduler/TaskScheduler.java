import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    private Task head = null;
    private Scanner sc = new Scanner(System.in);

    public void addTask() {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Priority: ");
        int priority = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = sc.nextLine();

        Task newTask = new Task(id, name, priority, dueDate);

        System.out.print("Add at 1) Beginning 2) End 3) Position: ");
        int choice = sc.nextInt(); sc.nextLine();

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else if (choice == 1) {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        } else if (choice == 2) {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        } else {
            System.out.print("Enter position (starting from 1): ");
            int pos = sc.nextInt(); sc.nextLine();
            if (pos == 1) {
                Task temp = head;
                while (temp.next != head) temp = temp.next;
                newTask.next = head;
                temp.next = newTask;
                head = newTask;
            } else {
                Task temp = head;
                for (int i = 1; i < pos - 1 && temp.next != head; i++) temp = temp.next;
                newTask.next = temp.next;
                temp.next = newTask;
            }
        }
        System.out.println("Task added successfully!");
    }

    public void removeTask() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Enter Task ID to remove: ");
        int id = sc.nextInt(); sc.nextLine();
        Task temp = head, prev = null;
        do {
            if (temp.id == id) break;
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (temp.id != id) {
            System.out.println("Task not found.");
            return;
        }
        if (temp == head) {
            Task last = head;
            while (last.next != head) last = last.next;
            if (head.next == head) head = null;
            else {
                head = head.next;
                last.next = head;
            }
        } else {
            prev.next = temp.next;
        }
        System.out.println("Task removed successfully!");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: ID=" + head.id + " Name=" + head.name + " Priority=" + head.priority + " DueDate=" + head.dueDate);
        head = head.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        System.out.println("\nAll Tasks:");
        do {
            System.out.println("ID=" + temp.id + " Name=" + temp.name + " Priority=" + temp.priority + " DueDate=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.print("Enter Priority to search: ");
        int priority = sc.nextInt(); sc.nextLine();
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("ID=" + temp.id + " Name=" + temp.name + " DueDate=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with this priority.");
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Current Task & Move Next");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Search Task by Priority");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> removeTask();
                case 3 -> viewCurrentTask();
                case 4 -> displayAllTasks();
                case 5 -> searchByPriority();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new TaskScheduler().menu();
    }
}
