import java.util.Scanner;

public class NumberFormatDemo {
    static void generate(String s) {
        Integer.parseInt(s);
    }

    static void handle(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
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
