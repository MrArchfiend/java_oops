import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter Physics marks of student " + (i + 1) + ": ");
            double p = sc.nextDouble();

            System.out.print("Enter Chemistry marks of student " + (i + 1) + ": ");
            double c = sc.nextDouble();

            System.out.print("Enter Maths marks of student " + (i + 1) + ": ");
            double m = sc.nextDouble();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Enter positive values again.");
                i--;
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        for (int i = 0; i < n; i++) {

            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = "A+";
            } else if (percentage[i] >= 75) {
                grade[i] = "A";
            } else if (percentage[i] >= 60) {
                grade[i] = "B";
            } else if (percentage[i] >= 50) {
                grade[i] = "C";
            } else {
                grade[i] = "F";
            }
        }

        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");

        for (int i = 0; i < n; i++) {
            System.out.println(
                marks[i][0] + "\t" +
                marks[i][1] + "\t\t" +
                marks[i][2] + "\t" +
                percentage[i] + "\t\t" +
                grade[i]
            );
        }

        sc.close();
    }
}
