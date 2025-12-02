import java.util.*;
public class FeedbackAnalysis{
    public static void main(String[]args){
        List<String> feedbacks=new ArrayList<>(Arrays.asList("good","bad","good","ok"));
        Set<String> unique=new HashSet<>(feedbacks);
        Queue<String> q=new LinkedList<>(unique);
        Stack<String> recent=new Stack<>();
        while(!q.isEmpty()){ String f=q.remove(); recent.push(f); System.out.println("Process "+f); }
        System.out.println("Recent "+recent);
    }
}