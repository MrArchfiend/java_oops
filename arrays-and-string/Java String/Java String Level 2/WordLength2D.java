import java.util.*;

public class WordLength2D {

    static int length(String s) {
        int c = 0;
        try { while(true){ s.charAt(c++); } }
        catch(Exception e){ return c; }
    }

    static String[] splitText(String text) {
        int len = length(text);
        int count = 1;
        for(int i=0;i<len;i++) if(text.charAt(i)==' ') count++;

        String[] words = new String[count];
        int start=0,idx=0;

        for(int i=0;i<=len;i++){
            if(i==len || text.charAt(i)==' '){
                String w="";
                for(int j=start;j<i;j++) w+=text.charAt(j);
                words[idx++]=w;
                start=i+1;
            }
        }
        return words;
    }

    static String[][] make2D(String[] words){
        String[][] arr=new String[words.length][2];
        for(int i=0;i<words.length;i++){
            arr[i][0]=words[i];
            arr[i][1]=String.valueOf(length(words[i]));
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();

        String[][] data=make2D(splitText(text));

        System.out.println("Word\tLength");
        for(int i=0;i<data.length;i++){
            System.out.println(data[i][0]+"\t"+Integer.parseInt(data[i][1]));
        }
    }
}
