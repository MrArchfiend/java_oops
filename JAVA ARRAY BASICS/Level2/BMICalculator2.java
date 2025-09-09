import java.util.Scanner;

public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of persons
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();

        // Create 2D array: [][0] = height, [][1] = weight, [][2] = BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input loop for height and weight
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            // Input height
            double height;
            do {
                System.out.print("Enter height in meters (e.g., 1.75): ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be positive. Please try again.");
                }
            } while (height <= 0);
            personData[i][0] = height;

            // Input weight
            double weight;
            do {
                System.out.print("Enter weight in kilograms (e.g., 70): ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be positive. Please try again.");
                }
            } while (weight <= 0);
            personData[i][1] = weight;

            // Calculate BMI
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            // Determine weight status based on fixed BMI ranges
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Output
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
