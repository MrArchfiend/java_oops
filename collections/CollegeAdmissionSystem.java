import java.util.*;
public class CollegeAdmissionSystem{
    public static class Student{ String id; int marks; public Student(String id,int marks){this.id=id;this.marks=marks;} public String toString(){return id+":"+marks;} public boolean equals(Object o){ if(!(o instanceof Student)) return false; return id.equals(((Student)o).id);} public int hashCode(){return id.hashCode();} }
    public static void main(String[]args){
        List<Student> applicants=new ArrayList<>();
        applicants.add(new Student("S1",85)); applicants.add(new Student("S2",92));
        Set<Student> shortlisted=new HashSet<>();
        for(Student s:applicants) if(s.marks>80) shortlisted.add(s);
        Queue<Student> interviews=new LinkedList<>(shortlisted);
        TreeSet<Student> merit=new TreeSet<>((a,b)->{
            int r=Integer.compare(b.marks,a.marks); if(r!=0) return r; return a.id.compareTo(b.id);
        });
        while(!interviews.isEmpty()) merit.add(interviews.remove());
        System.out.println(merit);
    }
}