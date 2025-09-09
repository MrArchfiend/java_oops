import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] arr=new int[5];
        System.out.println("Enter the array");
        for(int i =0;i<arr.length;i++){
            arr[i]=input.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                if(arr[i]%2==0) System.out.println(arr[i]+" is even");
                else System.out.println(arr[i]+" is not even");
            } else if (arr[i]==0) {
                System.out.println("number is zero");
            }
            else System.out.println(arr[i]+" is negative");
        }
        if (arr[0] == arr[4]) System.out.println("First and last are equal");
        else if (arr[0] > arr[4]) System.out.println("First is greater than last");
        else System.out.println("First is less than last");
        input.close();
    }
}
