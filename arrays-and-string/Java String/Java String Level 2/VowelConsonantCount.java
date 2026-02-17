import java.util.*;

public class VowelConsonantCount {

    static String type(char c){
        if(c>='A'&&c<='Z') c=(char)(c+32);
        if(c>='a'&&c<='z'){
            if("aeiou".indexOf(c)>=0) return "Vowel";
            return "Consonant";
        }
        return "Not";
    }

    static int[] count(String s){
        int v=0,c=0;
        for(int i=0;i<s.length();i++){
            String t=type(s.charAt(i));
            if(t.equals("Vowel")) v++;
            else if(t.equals("Consonant")) c++;
        }
        return new int[]{v,c};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        int[] r=count(text);
        System.out.println("Vowels="+r[0]);
        System.out.println("Consonants="+r[1]);
    }
}
