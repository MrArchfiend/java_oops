import java.util.Scanner;

public class CharFrequencyNested {

    static String[] frequency(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 0 && chars[i] != '0') count++;

        String[] result = new String[count];
        int k = 0;

        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 0 && chars[i] != '0')
                result[k++] = chars[i] + " " + freq[i];

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] result = frequency(text);
        for (String r : result) System.out.println(r);
    }
}
