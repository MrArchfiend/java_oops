import java.util.*;
public class MaxValueKeyFinder{
 public static String findMaxKey(Map<String,Integer> map){
  return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
 }
 public static void main(String[]args){
  Map<String,Integer> m=new HashMap<>();
  m.put("A",10);m.put("B",20);m.put("C",15);
  System.out.println(findMaxKey(m));
 }
}