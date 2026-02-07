import java.util.Scanner;

public class ToLowerCaseCustom {
    static String convert(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') r += (char)(c + 32);
            else r += c;
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
        String text = sc.nextLine();

        String s1 = convert(text);
        String s2 = text.toLowerCase();

        System.out.println(compare(s1, s2));
    }
}
