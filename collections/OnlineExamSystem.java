import java.util.*;
public class OnlineExamSystem{
    public static class Question{ String id,text; public Question(String id,String t){id=id;text=t;} public String toString(){return id+":"+text;} }
    public static class Student{ String id; public Student(String id){this.id=id;} public String toString(){return id;} }
    public static void main(String[]args){
        List<Question> questions=new ArrayList<>();
        for(int i=1;i<=5;i++) questions.add(new Question(""+i,"Q"+i));
        Collections.shuffle(questions);
        Set<String> students=new HashSet<>();
        students.add("S1"); students.add("S2"); students.add("S1");
        Queue<Student> queue=new LinkedList<>();
        queue.add(new Student("S1")); queue.add(new Student("S2"));
        Stack<Question> nav=new Stack<>();
        for(Question q:questions) nav.push(q);
        while(!queue.isEmpty()) System.out.println("Serve "+queue.remove());
    }
}