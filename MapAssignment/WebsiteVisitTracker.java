import java.util.*;
public class WebsiteVisitTracker{
 public static void main(String[]args){
  Map<String,Integer> visits=new HashMap<>();
  String[] seq={"home","about","products","home","products","contact","home","products","about"};
  for(String p:seq) visits.put(p,visits.getOrDefault(p,0)+1);
  List<Map.Entry<String,Integer>> list=new ArrayList<>(visits.entrySet());
  list.sort((a,b)->b.getValue()-a.getValue());
  for(Map.Entry<String,Integer> e:list) System.out.println(e.getKey()+" -> "+e.getValue());
  System.out.println("Top: "+list.get(0).getKey());
 }
}