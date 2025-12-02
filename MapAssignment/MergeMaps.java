import java.util.*;
public class MergeMaps{
 public static <K> Map<K,Integer> mergeSum(Map<K,Integer> a, Map<K,Integer> b){
  Map<K,Integer> out=new HashMap<>(a);
  for(Map.Entry<K,Integer> e:b.entrySet()) out.put(e.getKey(), out.getOrDefault(e.getKey(),0)+e.getValue());
  return out;
 }
 public static void main(String[]args){
  Map<String,Integer> m1=new HashMap<>();m1.put("A",1);m1.put("B",2);
  Map<String,Integer> m2=new HashMap<>();m2.put("B",3);m2.put("C",4);
  System.out.println(mergeSum(m1,m2));
 }
}