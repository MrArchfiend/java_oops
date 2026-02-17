import java.util.*;

public class QuickSortPrices {

    static int partition(int[] arr,int low,int high){

        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(arr[j] < pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] price=new int[n];

        for(int i=0;i<n;i++) price[i]=sc.nextInt();

        quickSort(price,0,n-1);

        for(int x:price) System.out.print(x+" ");
    }
}
