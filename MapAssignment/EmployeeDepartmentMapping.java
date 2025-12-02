import java.util.*;
public class EmployeeDepartmentMapping{
 public static void main(String[]args){
  Map<Integer,String> map=new HashMap<>();
  map.put(101,"HR");map.put(102,"IT");map.put(103,"Finance");map.put(104,"IT");map.put(105,"HR");
  map.put(106,"Sales");
  map.put(102,"R&D");
  System.out.println(reverseLookup(map,"IT"));
  Map<String,Integer> counts=new HashMap<>();
  for(String d:map.values()) counts.put(d,counts.getOrDefault(d,0)+1);
  System.out.println(counts);
 }
 static List<Integer> reverseLookup(Map<Integer,String> map,String dept){
  List<Integer> list=new ArrayList<>();
  for(Map.Entry<Integer,String> e:map.entrySet()) if(e.getValue().equalsIgnoreCase(dept)) list.add(e.getKey());
  return list;
 }
}