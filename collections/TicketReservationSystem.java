import java.util.*;
public class TicketReservationSystem{
    public static class Booking{ String id; boolean vip; public Booking(String id,boolean vip){this.id=id;this.vip=vip;} public String toString(){return id+"|VIP:"+vip;} }
    public static void main(String[]args){
        List<Booking> all=new ArrayList<>();
        Set<String> users=new HashSet<>();
        Queue<Booking> queue=new LinkedList<>();
        PriorityQueue<Booking> pq=new PriorityQueue<>((a,b)->Boolean.compare(b.vip,a.vip));
        all.add(new Booking("B1",false)); all.add(new Booking("B2",true));
        users.add("U1"); users.add("U1");
        for(Booking b:all) { queue.add(b); if(b.vip) pq.add(b); }
        while(!pq.isEmpty()) System.out.println("VIP confirm "+pq.remove());
        while(!queue.isEmpty()) System.out.println("Confirm "+queue.remove());
    }
}