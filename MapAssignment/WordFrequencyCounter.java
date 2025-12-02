import java.util.*;
public class WordFrequencyCounter{
 public static Map<String,Integer> countWords(String text){
  text=text.replaceAll("[^a-zA-Z0-9\s]"," ").toLowerCase();
  String[] parts=text.split("\\s+");
  Map<String,Integer> freq=new HashMap<>();
  for(String w:parts) if(!w.isEmpty()) freq.put(w,freq.getOrDefault(w,0)+1);
  return freq;
 }
 public static void main(String[]args){
  String input="Hello world, hello Java!";
  Map<String,Integer> result=countWords(input);
  System.out.println(result);
 }
}