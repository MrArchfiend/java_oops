
public class VotingCheck {

    static int[] randomAge(int n){
        int[] age=new int[n];
        for(int i=0;i<n;i++)
            age[i]=(int)(Math.random()*90);
        return age;
    }

    static String[][] check(int[] age){
        String[][] res=new String[age.length][2];
        for(int i=0;i<age.length;i++){
            res[i][0]=String.valueOf(age[i]);
            res[i][1]=(age[i]>=18)?"true":"false";
        }
        return res;
    }

    static void display(String[][] r){
        System.out.println("Age\tCanVote");
        for(int i=0;i<r.length;i++)
            System.out.println(r[i][0]+"\t"+r[i][1]);
    }

    public static void main(String[] args){
        display(check(randomAge(10)));
    }
}

