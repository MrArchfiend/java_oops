import java.util.*;
public class CourierRoutingSystem{
    public static class Parcel{ String id; int priority; public Parcel(String id,int p){this.id=id;this.priority=p;} public String toString(){return id+":"+priority;} public boolean equals(Object o){ if(!(o instanceof Parcel)) return false; return id.equals(((Parcel)o).id);} public int hashCode(){return id.hashCode();} }
    public static void main(String[]args){
        PriorityQueue<Parcel> pq=new PriorityQueue<>((a,b)->Integer.compare(b.priority,a.priority));
        Set<String> assigned=new HashSet<>();
        List<Parcel> completed=new ArrayList<>();
        Queue<Parcel> normal=new LinkedList<>();
        Parcel p1=new Parcel("C1",5);
        pq.add(p1); normal.add(new Parcel("C2",1));
        Parcel top=pq.remove();
        if(assigned.add(top.id)) completed.add(top);
        System.out.println(completed);
    }
}