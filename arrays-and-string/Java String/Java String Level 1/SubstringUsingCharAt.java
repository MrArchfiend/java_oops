import java.util.Scanner;

public class SubstringUsingCharAt {
    static String customSubstring(String s, int start, int end) {
        String r = "";
        for (int i = start; i < end; i++) {
            r += s.charAt(i);
        }
        return r;
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String s1 = customSubstring(text, start, end);
        String s2 = text.substring(start, end);

        System.out.println(compare(s1, s2));
    }
}
