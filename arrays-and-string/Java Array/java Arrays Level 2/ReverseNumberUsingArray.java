import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        long temp = Math.abs(number);
        int count = 0;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        if (count == 0) {
            count = 1;
        }

        int[] digits = new int[count];
        temp = Math.abs(number);

        for (int i = 0; i < count; i++) {
            digits[i] = (int)(temp % 10);
            temp = temp / 10;
        }

        int[] reverse = new int[count];

        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed digits: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i] + " ");
        }

        sc.close();
    }
}
