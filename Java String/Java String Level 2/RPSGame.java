import java.util.*;

public class RPSGame {

    static String comp(){
        int r=(int)(Math.random()*3);
        if(r==0) return "rock";
        if(r==1) return "paper";
        return "scissors";
    }

    static int winner(String u,String c){
        if(u.equals(c)) return 0;
        if((u.equals("rock")&&c.equals("scissors"))||
           (u.equals("paper")&&c.equals("rock"))||
           (u.equals("scissors")&&c.equals("paper"))) return 1;
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int userWin=0,compWin=0;

        System.out.println("User\tComputer\tResult");

        for(int i=0;i<n;i++){
            String u=sc.next();
            String c=comp();
            int w=winner(u,c);

            String res="Draw";
            if(w==1){userWin++;res="User";}
            else if(w==-1){compWin++;res="Computer";}

            System.out.println(u+"\t"+c+"\t"+res);
        }

        System.out.println("\nUser Win %="+(userWin*100.0/n));
        System.out.println("Computer Win %="+(compWin*100.0/n));
    }
}
