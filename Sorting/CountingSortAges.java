import java.util.*;

public class CountingSortAges {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] age=new int[n];

        for(int i=0;i<n;i++) age[i]=sc.nextInt();

        int max=18;
        int[] count=new int[max+1];

        for(int i=0;i<n;i++){
            count[age[i]]++;
        }

        for(int i=1;i<=max;i++){
            count[i]+=count[i-1];
        }

        int[] output=new int[n];

        for(int i=n-1;i>=0;i--){
            output[count[age[i]]-1]=age[i];
            count[age[i]]--;
        }

        for(int x:output) System.out.print(x+" ");
    }
}
