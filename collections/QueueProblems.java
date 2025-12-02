import java.util.*;
public class QueueProblems{
    public static <T> Queue<T> reverseQueue(Queue<T> q){
        if(q.isEmpty()) return q;
        T v=q.remove();
        Queue<T> out=reverseQueue(q);
        out.add(v);
        return out;
    }
    public static List<String> generateBinary(int n){
        List<String> out=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        if(n<=0) return out;
        q.add("1");
        for(int i=0;i<n;i++){
            String s=q.remove();
            out.add(s);
            q.add(s+"0");
            q.add(s+"1");
        }
        return out;
    }
    public static class Patient{ String name; int severity; public Patient(String n,int s){name=n;severity=s;} public String toString(){return name+":"+severity;} }
    public static List<Patient> triage(List<Patient> list){
        PriorityQueue<Patient> pq=new PriorityQueue<>((a,b)->Integer.compare(b.severity,a.severity));
        pq.addAll(list);
        List<Patient> order=new ArrayList<>();
        while(!pq.isEmpty()) order.add(pq.remove());
        return order;
    }
    public static class StackUsingQueues<T>{
        private Queue<T> q1=new LinkedList<>(), q2=new LinkedList<>();
        public void push(T v){ q1.add(v); while(!q2.isEmpty()) q1.add(q2.remove()); Queue<T> tmp=q1; q1=q2; q2=tmp; }
        public T pop(){ return q2.isEmpty()?null:q2.remove(); }
        public T top(){ return q2.peek(); }
    }
    public static class CircularBuffer<T>{
        private Object[] data; private int start=0; private int size=0;
        public CircularBuffer(int capacity){ data=new Object[capacity]; }
        public void insert(T v){
            if(size<data.length){ data[(start+size)%data.length]=v; size++; }
            else{ data[start]=v; start=(start+1)%data.length; }
        }
        public List<T> snapshot(){ List<T> out=new ArrayList<>(); for(int i=0;i<size;i++) out.add((T)data[(start+i)%data.length]); return out; }
    }
    public static void main(String[]args){
        Queue<Integer> q=new LinkedList<>(Arrays.asList(10,20,30));
        System.out.println(reverseQueue(new LinkedList<>(q)));
        System.out.println(generateBinary(5));
        List<Patient> patients=Arrays.asList(new Patient("John",3),new Patient("Alice",5),new Patient("Bob",2));
        System.out.println(triage(patients));
        StackUsingQueues<Integer> s=new StackUsingQueues<>();
        s.push(1); s.push(2); s.push(3);
        System.out.println(s.pop());
        CircularBuffer<Integer> cb=new CircularBuffer<>(3);
        cb.insert(1);cb.insert(2);cb.insert(3);cb.insert(4);
        System.out.println(cb.snapshot());
    }
}