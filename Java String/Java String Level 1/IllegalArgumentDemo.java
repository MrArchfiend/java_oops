import java.util.Scanner;

public class IllegalArgumentDemo {
    static void generate(String s) {
        s.substring(5, 2);
    }

    static void handle(String s) {
        try {
            s.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try {
            generate(s);
        } catch (Exception e) {
        }
        handle(s);
    }
}
