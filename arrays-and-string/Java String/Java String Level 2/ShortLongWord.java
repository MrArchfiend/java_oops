import java.util.*;

public class ShortLongWord {

    static int len(String s){
        int c=0;
        try{while(true){s.charAt(c++);}}
        catch(Exception e){return c;}
    }

    static String[] split(String t){
        int L=len(t),count=1;
        for(int i=0;i<L;i++) if(t.charAt(i)==' ') count++;
        String[] w=new String[count];
        int s=0,k=0;
        for(int i=0;i<=L;i++){
            if(i==L||t.charAt(i)==' '){
                String x="";
                for(int j=s;j<i;j++) x+=t.charAt(j);
                w[k++]=x;
                s=i+1;
            }
        }
        return w;
    }

    static int[] find(String[] w){
        int min=0,max=0;
        for(int i=1;i<w.length;i++){
            if(len(w[i])<len(w[min])) min=i;
            if(len(w[i])>len(w[max])) max=i;
        }
        return new int[]{min,max};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[] words=split(text);
        int[] r=find(words);

        System.out.println("Shortest = "+words[r[0]]);
        System.out.println("Longest = "+words[r[1]]);
    }
}
