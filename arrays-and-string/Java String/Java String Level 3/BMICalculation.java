import java.util.Scanner;

public class BMICalculation {

    static String[][] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4)
            status = "Underweight";
        else if (bmi <= 24.9)
            status = "Normal";
        else if (bmi <= 39.9)
            status = "Overweight";
        else
            status = "Obese";

        return new String[][]{
                {String.format("%.2f", bmi), status}
        };
    }

    static String[][] process(double[][] data) {
        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[][] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0][0];
            result[i][3] = bmiData[0][1];
        }
        return result;
    }

    static void display(String[][] data) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println(
                    data[i][0] + "\t\t" +
                    data[i][1] + "\t\t" +
                    data[i][2] + "\t" +
                    data[i][3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] input = new double[10][2];

        for (int i = 0; i < 10; i++) {
            input[i][0] = sc.nextDouble();
            input[i][1] = sc.nextDouble();
        }

        String[][] result = process(input);
        display(result);
    }
}
