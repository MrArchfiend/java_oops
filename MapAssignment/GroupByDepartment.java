import java.util.*;
public class GroupByDepartment{
 public static class Employee{
  private final String name;
  private final String department;
  public Employee(String name,String department){this.name=name;this.department=department;}
  public String getName(){return name;}
  public String getDepartment(){return department;}
  public String toString(){return name;}
 }
 public static Map<String,List<Employee>> groupByDept(List<Employee> list){
  Map<String,List<Employee>> map=new HashMap<>();
  for(Employee e:list) map.computeIfAbsent(e.getDepartment(),k->new ArrayList<>()).add(e);
  return map;
 }
 public static void main(String[]args){
  List<Employee> emps=Arrays.asList(new Employee("Alice","HR"),new Employee("Bob","IT"),new Employee("Carol","HR"));
  System.out.println(groupByDept(emps));
 }
}