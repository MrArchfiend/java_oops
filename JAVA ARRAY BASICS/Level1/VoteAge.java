import java.util.Scanner;

public class VoteAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr= new int[10];
        System.out.println("Enter the Age");
        for(int i=0;i<arr.length;i++){
            arr[i]=input.nextInt();
            if(arr[i]<0){
                System.out.println("Invalid age");
            } else if (arr[i] >= 18) {
                System.out.println("Student with age "+arr[i]+" vote");
            }
            else{
                System.out.println("Student with age "+arr[i]+" cannot vote");
            }
        }

        input.close();

    }
}
