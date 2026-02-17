import java.util.*;

public class ScoreCard {

    static int[][] randomPCM(int n){
        int[][] pcm=new int[n][3];
        for(int i=0;i<n;i++)
            for(int j=0;j<3;j++)
                pcm[i][j]=10+(int)(Math.random()*90);
        return pcm;
    }

    static double[][] calc(int[][] pcm){
        double[][] r=new double[pcm.length][3];
        for(int i=0;i<pcm.length;i++){
            double total=pcm[i][0]+pcm[i][1]+pcm[i][2];
            double avg=Math.round((total/3)*100.0)/100.0;
            double per=Math.round((total/300*100)*100.0)/100.0;
            r[i][0]=total; r[i][1]=avg; r[i][2]=per;
        }
        return r;
    }

    static String[] grade(double[][] data){
        String[] g=new String[data.length];
        for(int i=0;i<data.length;i++){
            double p=data[i][2];
            if(p>=90) g[i]="A+";
            else if(p>=75) g[i]="A";
            else if(p>=60) g[i]="B";
            else if(p>=50) g[i]="C";
            else g[i]="F";
        }
        return g;
    }

    static void display(int[][] pcm,double[][] d,String[] g){
        System.out.println("P\tC\tM\tTotal\tAvg\tPer\tGrade");
        for(int i=0;i<pcm.length;i++){
            System.out.println(pcm[i][0]+"\t"+pcm[i][1]+"\t"+pcm[i][2]+"\t"+
                    d[i][0]+"\t"+d[i][1]+"\t"+d[i][2]+"\t"+g[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[][] pcm=randomPCM(n);
        double[][] data=calc(pcm);
        String[] grade=grade(data);

        display(pcm,data,grade);
    }
}

