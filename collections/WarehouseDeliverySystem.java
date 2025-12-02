import java.util.*;
public class WarehouseDeliverySystem{
    public static class Package{ String id; public Package(String id){this.id=id;} public String toString(){return id;} public boolean equals(Object o){ if(!(o instanceof Package)) return false; return id.equals(((Package)o).id);} public int hashCode(){return id.hashCode();} }
    public static void main(String[]args){
        Queue<Package> pending=new LinkedList<>();
        Set<String> ids=new HashSet<>();
        List<Package> delivered=new ArrayList<>();
        Stack<Package> returned=new Stack<>();
        pending.add(new Package("P1")); pending.add(new Package("P2"));
        while(!pending.isEmpty()){
            Package p=pending.remove();
            if(ids.add(p.id)){ delivered.add(p); } else System.out.println("Duplicate "+p);
        }
        returned.push(new Package("P3"));
        System.out.println(delivered);
    }
}