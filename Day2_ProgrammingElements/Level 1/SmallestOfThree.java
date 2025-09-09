import java.util.Scanner;
class SmallestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if (a < b && a < c) {
            System.out.println("The first number is the smallest.");
        } else {
            System.out.println("The first number is not the smallest.");
        }
        input.close();
    }
}