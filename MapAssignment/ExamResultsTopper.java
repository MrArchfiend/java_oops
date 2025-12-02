import java.util.*;
public class ExamResultsTopper{
 public static void main(String[]args){
  Map<String,Map<String,Integer>> data=new HashMap<>();
  Map<String,Integer> math=new HashMap<>();math.put("Alice",95);math.put("Bob",78);math.put("Carol",88);
  Map<String,Integer> phys=new HashMap<>();phys.put("Alice",85);phys.put("Bob",92);phys.put("Carol",90);
  Map<String,Integer> cs=new HashMap<>();cs.put("Alice",99);cs.put("Bob",81);cs.put("Carol",91);
  data.put("Math",math);data.put("Physics",phys);data.put("CS",cs);
  for(Map.Entry<String,Map<String,Integer>> e:data.entrySet()){
   String subject=e.getKey();
   Map<String,Integer> marks=e.getValue();
   String top=marks.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
   double avg=marks.values().stream().mapToInt(Integer::intValue).average().orElse(0);
   boolean above90=marks.values().stream().anyMatch(v->v>90);
   System.out.println(subject+" Topper: "+top+" Avg: "+avg+" AnyAbove90: "+above90);
  }
 }
}