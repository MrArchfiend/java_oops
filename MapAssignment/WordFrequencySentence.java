import java.util.*;
public class WordFrequencySentence{
 public static void main(String[]args){
  String sentence="Java is fun and Java is powerful";
  String[] parts=sentence.replaceAll("[^a-zA-Z0-9\\s]"," ").toLowerCase().split("\\s+");
  Map<String,Integer> count=new HashMap<>();
  for(String w:parts) if(!w.isEmpty()) count.put(w,count.getOrDefault(w,0)+1);
  for(Map.Entry<String,Integer> e:count.entrySet()) System.out.println(e.getKey()+" : "+e.getValue());
 }
}