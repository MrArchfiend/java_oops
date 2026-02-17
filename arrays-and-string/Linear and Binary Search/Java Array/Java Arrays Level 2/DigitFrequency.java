import java.util.Scanner;

public class DigitFrequency {
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

        int[] frequency = new int[10];

        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\nDigit Frequency:");

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " = " + frequency[i]);
            }
        }

        sc.close();
    }
}

