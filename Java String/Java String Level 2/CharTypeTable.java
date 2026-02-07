import java.util.*;

public class CharTypeTable {

    static String type(char c){
        if(c>='A'&&c<='Z') c=(char)(c+32);
        if(c>='a'&&c<='z'){
            if("aeiou".indexOf(c)>=0) return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] analyze(String s){
        String[][] arr=new String[s.length()][2];
        for(int i=0;i<s.length();i++){
            arr[i][0]=String.valueOf(s.charAt(i));
            arr[i][1]=type(s.charAt(i));
        }
        return arr;
    }

    static void display(String[][] a){
        System.out.println("Char\tType");
        for(int i=0;i<a.length;i++)
            System.out.println(a[i][0]+"\t"+a[i][1]);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        display(analyze(sc.nextLine()));
    }
}
