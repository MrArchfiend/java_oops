import java.util.*;
public class CourseRegistrationSystem{
 public static void main(String[]args){
  Map<String,Integer> courses=new HashMap<>();
  courses.put("CS101",45);courses.put("EE201",52);courses.put("MA110",4);courses.put("PH300",60);courses.put("CS201",12);
  addStudent(courses,"CS101");
  dropStudent(courses,"MA110");
  System.out.println("Near full:");
  for(Map.Entry<String,Integer> e:courses.entrySet()) if(e.getValue()>=50) System.out.println(e.getKey()+" -> "+e.getValue());
  System.out.println("Under subscribed:");
  for(Map.Entry<String,Integer> e:courses.entrySet()) if(e.getValue()<5) System.out.println(e.getKey()+" -> "+e.getValue());
 }
 static void addStudent(Map<String,Integer> courses,String code){ courses.put(code,courses.getOrDefault(code,0)+1); }
 static void dropStudent(Map<String,Integer> courses,String code){ courses.put(code,Math.max(0,courses.getOrDefault(code,0)-1)); }
}