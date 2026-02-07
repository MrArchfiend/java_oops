import java.util.Scanner;

public class CharFrequencyUnique {

    static char[] uniqueChars(String s) {
        char[] temp = new char[s.length()];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean found = false;

            for (int j = 0; j < i; j++)
                if (s.charAt(j) == c) found = true;

            if (!found) temp[k++] = c;
        }

        char[] result = new char[k];
        for (int i = 0; i < k; i++) result[i] = temp[i];
        return result;
    }

    static String[][] frequency(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;

        char[] unique = uniqueChars(s);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[][] result = frequency(text);
        for (String[] r : result)
            System.out.println(r[0] + " " + r[1]);
    }
}
