import java.util.*;
public class AttendanceTracker{
 public static void main(String[]args){
  List<String> students=Arrays.asList("Alice","Bob","Carol","Dave","Eve");
  Map<String,Integer> days=new HashMap<>();
  for(String s:students) days.put(s,0);
  List<List<String>> month=new ArrayList<>();
  Random r=new Random(1);
  for(int d=0;d<15;d++){
   List<String> present=new ArrayList<>();
   for(String s:students) if(r.nextBoolean()) present.add(s);
   month.add(present);
  }
  for(List<String> present:month) for(String s:present) days.put(s,days.get(s)+1);
  System.out.println("Under attending:");
  for(Map.Entry<String,Integer> e:days.entrySet()) if(e.getValue()<10) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}