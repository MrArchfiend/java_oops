import java.util.*;
public class StudentGradeTracker{
 public static void main(String[]args){
  Map<String,Double> grades=new HashMap<>();
  grades.put("Alice",85.0);
  grades.put("Bob",72.5);
  grades.put("Charlie",90.0);
  grades.put("Diana",66.0);
  grades.put("Ethan",78.5);
  grades.put("Frank",59.0);
  grades.put("Grace",88.0);
  grades.put("Hannah",91.5);
  grades.put("Ibrahim",73.0);
  grades.put("Jaya",80.0);
  grades.put("Charlie",95.0);
  grades.remove("Frank");
  TreeMap<String,Double> sorted=new TreeMap<>(grades);
  for(Map.Entry<String,Double> e:sorted.entrySet()) System.out.println(e.getKey()+" : "+e.getValue());
 }
}