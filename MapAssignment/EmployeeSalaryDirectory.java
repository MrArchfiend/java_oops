import java.util.*;
public class EmployeeSalaryDirectory{
 public static void main(String[]args){
  Map<String,Double> emp=new HashMap<>();
  emp.put("Alice",50000.0);emp.put("Bob",75000.0);emp.put("Carol",60000.0);
  emp.put("Dave",90000.0);emp.put("Eve",45000.0);emp.put("Frank",90000.0);
  raise(emp,"Bob",10.0);
  raise(emp,"Zed",5.0);
  double sum=0;
  for(double v:emp.values()) sum+=v;
  System.out.println("Average: "+sum/emp.size());
  double max=emp.values().stream().mapToDouble(Double::doubleValue).max().orElse(0);
  for(Map.Entry<String,Double> e:emp.entrySet()) if(e.getValue()==max) System.out.println("Top: "+e.getKey());
 }
 static void raise(Map<String,Double> emp,String name,double pct){
  if(!emp.containsKey(name)){ System.out.println("Employee not found"); return; }
  emp.put(name,emp.get(name)*(1.0+pct/100.0));
 }
}