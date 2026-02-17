import java.util.Scanner;

public class PalindromeCheck {

    static boolean logic1(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean logic2(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return logic2(s, start + 1, end - 1);
    }

    static char[] reverse(String s) {
        char[] rev = new char[s.length()];
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            rev[k++] = s.charAt(i);
        return rev;
    }

    static boolean logic3(String s) {
        char[] original = s.toCharArray();
        char[] rev = reverse(s);

        for (int i = 0; i < original.length; i++)
            if (original[i] != rev[i]) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        System.out.println(logic1(text));
        System.out.println(logic2(text, 0, text.length() - 1));
        System.out.println(logic3(text));
    }
}
