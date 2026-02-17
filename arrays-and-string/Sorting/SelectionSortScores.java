import java.util.*;

public class SelectionSortScores {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] score=new int[n];

        for(int i=0;i<n;i++) score[i]=sc.nextInt();

        for(int i=0;i<n-1;i++){
            int min=i;

            for(int j=i+1;j<n;j++){
                if(score[j] < score[min]) min=j;
            }

            int temp=score[min];
            score[min]=score[i];
            score[i]=temp;
        }

        for(int x:score) System.out.print(x+" ");
    }
}
