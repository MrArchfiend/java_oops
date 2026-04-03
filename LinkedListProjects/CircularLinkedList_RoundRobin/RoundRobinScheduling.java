import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduling {
    private Process head = null;
    private Process tail = null;
    private Scanner sc = new Scanner(System.in);

    // Add process at the end of circular list
    public void addProcess() {
        System.out.print("Enter Process ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Burst Time: ");
        int burst = sc.nextInt();
        System.out.print("Enter Priority: ");
        int priority = sc.nextInt();
        sc.nextLine();
        Process newProc = new Process(pid, burst, priority);

        if (head == null) {
            head = tail = newProc;
            tail.next = head;
        } else {
            tail.next = newProc;
            newProc.next = head;
            tail = newProc;
        }
        System.out.println("Process added successfully!");
    }

    // Remove process by PID
    public void removeProcess(int pid) {
        if (head == null) return;
        if (head.pid == pid && head == tail) { head = tail = null; return; }

        Process curr = head, prev = tail;
        do {
            if (curr.pid == pid) {
                prev.next = curr.next;
                if (curr == head) head = curr.next;
                if (curr == tail) tail = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display circular list
    public void displayProcesses() {
        if (head == null) { System.out.println("No processes."); return; }
        Process temp = head;
        System.out.println("\nProcesses in queue:");
        do {
            System.out.println("PID: " + temp.pid + ", Burst: " + temp.burstTime + ", Priority: " + temp.priority + ", Remaining: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Round-robin scheduling
    public void simulateScheduling() {
        if (head == null) { System.out.println("No processes to schedule."); return; }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        Process curr = head;
        int totalWaiting = 0, totalTurnaround = 0;
        int n = 0;
        Process temp = head;
        do { n++; temp = temp.next; } while (temp != head);

        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] pidList = new int[n];
        int[] remaining = new int[n];

        // Initialize arrays
        int idx = 0;
        temp = head;
        do {
            pidList[idx] = temp.pid;
            remaining[idx] = temp.burstTime;
            waitingTime[idx] = 0;
            idx++;
            temp = temp.next;
        } while (temp != head);

        boolean done;
        int time = 0;
        do {
            done = true;
            for (int i = 0; i < n; i++) {
                if (remaining[i] > 0) {
                    done = false;
                    int exec = Math.min(quantum, remaining[i]);
                    System.out.println("Process " + pidList[i] + " executes for " + exec + " units.");
                    time += exec;
                    remaining[i] -= exec;
                    for (int j = 0; j < n; j++) {
                        if (j != i && remaining[j] > 0) waitingTime[j] += exec;
                    }
                    displayProcesses();
                }
            }
        } while (!done);

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = waitingTime[i] + pidList[i]; // simplified for demonstration
            totalWaiting += waitingTime[i];
            totalTurnaround += turnaroundTime[i];
        }

        System.out.println("\nAverage Waiting Time: " + (double)totalWaiting/n);
        System.out.println("Average Turnaround Time: " + (double)totalTurnaround/n);
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Round Robin Scheduling ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch(choice) {
                case 1 -> addProcess();
                case 2 -> displayProcesses();
                case 3 -> simulateScheduling();
                case 4 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new RoundRobinScheduling().menu();
    }
}
