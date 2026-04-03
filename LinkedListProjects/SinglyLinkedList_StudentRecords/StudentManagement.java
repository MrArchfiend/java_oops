import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentManagement {
    private Student head = null;

    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        Student newStudent = new Student(roll, name, age, grade);

        System.out.print("Add at 1) Beginning 2) End 3) Position: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            newStudent.next = head;
            head = newStudent;
        } else if (choice == 2) {
            if (head == null) {
                head = newStudent;
            } else {
                Student temp = head;
                while (temp.next != null) temp = temp.next;
                temp.next = newStudent;
            }
        } else {
            System.out.print("Enter position (starting from 1): ");
            int pos = sc.nextInt();
            if (pos == 1) {
                newStudent.next = head;
                head = newStudent;
            } else {
                Student temp = head;
                for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
                if (temp != null) {
                    newStudent.next = temp.next;
                    temp.next = newStudent;
                } else {
                    System.out.println("Position out of bounds. Adding at end.");
                    temp = head;
                    while (temp.next != null) temp = temp.next;
                    temp.next = newStudent;
                }
            }
        }
        System.out.println("Student added successfully!");
    }

    public void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student deleted successfully!");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) temp = temp.next;
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade() {
        System.out.print("Enter Roll Number to update grade: ");
        int roll = sc.nextInt(); sc.nextLine();
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.print("Enter new Grade: ");
                temp.grade = sc.nextLine();
                System.out.println("Grade updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        Student temp = head;
        System.out.println("\nAll Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> deleteStudent();
                case 3 -> searchStudent();
                case 4 -> updateGrade();
                case 5 -> displayAll();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new StudentManagement().menu();
    }
}
