import java.util.*;

public class InsertionSortEmployee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] id = new int[n];

        for(int i=0;i<n;i++) id[i]=sc.nextInt();

        for(int i=1;i<n;i++){
            int key=id[i];
            int j=i-1;

            while(j>=0 && id[j] > key){
                id[j+1]=id[j];
                j--;
            }
            id[j+1]=key;
        }

        for(int x:id) System.out.print(x+" ");
    }
}
