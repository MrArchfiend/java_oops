import java.util.Scanner;

public class UniqueCharacters {

    static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    static char[] uniqueChars(String s) {
        int len = getLength(s);
        char[] temp = new char[len];
        int k = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[k++] = c;
            }
        }

        char[] result = new char[k];
        for (int i = 0; i < k; i++) result[i] = temp[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        char[] result = uniqueChars(text);
        for (char c : result) System.out.print(c + " ");
    }
}
