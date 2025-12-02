import java.util.*;
public class CountryCapitalLookup{
 public static void main(String[]args){
  Map<String,String> map=new HashMap<>();
  map.put("India","New Delhi");map.put("USA","Washington D.C.");map.put("Japan","Tokyo");map.put("France","Paris");
  map.put("Germany","Berlin");map.put("Brazil","Brasilia");map.put("Canada","Ottawa");map.put("Australia","Canberra");
  System.out.println(map.getOrDefault("Japan","Unknown country"));
  TreeMap<String,String> sorted=new TreeMap<>(map);
  for(Map.Entry<String,String> e:sorted.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}