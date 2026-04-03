import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditorUndoRedo {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private final int MAX_HISTORY = 10; // limit undo/redo history
    private int size = 0;

    private Scanner sc = new Scanner(System.in);

    // Add a new state
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If current is not tail, remove all redo states
        if (current != tail) {
            TextState temp = current.next;
            while (temp != null) {
                TextState next = temp.next;
                temp.prev = null;
                temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        // Append new state
        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            size++;
        }

        // Enforce max history
        while (size > MAX_HISTORY) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            size--;
        }

        System.out.println("State added: \"" + content + "\"");
    }

    // Undo
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed. Current state: \"" + current.content + "\"");
        } else {
            System.out.println("Cannot undo further.");
        }
    }

    // Redo
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed. Current state: \"" + current.content + "\"");
        } else {
            System.out.println("Cannot redo further.");
        }
    }

    // Display current state
    public void displayCurrent() {
        if (current != null) System.out.println("Current text: \"" + current.content + "\"");
        else System.out.println("No text available.");
    }

    // Menu for console interaction
    public void menu() {
        while (true) {
            System.out.println("\n--- Text Editor Undo/Redo ---");
            System.out.println("1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1 -> {
                    System.out.print("Enter text content: ");
                    String text = sc.nextLine();
                    addState(text);
                }
                case 2 -> undo();
                case 3 -> redo();
                case 4 -> displayCurrent();
                case 5 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        new TextEditorUndoRedo().menu();
    }
}
