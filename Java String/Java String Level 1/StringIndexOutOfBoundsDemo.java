import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    static void generate(String s) {
        s.charAt(s.length());
    }

    static void handle(String s) {
        try {
            s.charAt(s.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled");
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
