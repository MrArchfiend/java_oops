import java.util.*;
public class RideSharingDispatchSystem{
    public static class RideRequest{ String id; int priority; public RideRequest(String id,int p){this.id=id;this.priority=p;} public String toString(){return id+":"+priority;} }
    public static class Driver{ String id; public Driver(String id){this.id=id;} public String toString(){return id;} public boolean equals(Object o){ if(!(o instanceof Driver)) return false; return id.equals(((Driver)o).id);} public int hashCode(){return id.hashCode();} }
    public static void main(String[]args){
        Queue<RideRequest> pending=new LinkedList<>();
        pending.add(new RideRequest("R1",5)); pending.add(new RideRequest("R2",2));
        Set<Driver> drivers=new HashSet<>(); drivers.add(new Driver("D1")); drivers.add(new Driver("D2"));
        List<String> completed=new ArrayList<>();
        PriorityQueue<RideRequest> pq=new PriorityQueue<>((a,b)->Integer.compare(b.priority,a.priority));
        pq.addAll(Arrays.asList(new RideRequest("R3",9), new RideRequest("R4",1)));
        while(!pq.isEmpty()){
            RideRequest r=pq.remove();
            Driver d=drivers.iterator().next();
            completed.add(r.id+" by "+d.id);
        }
        System.out.println(completed);
    }
}