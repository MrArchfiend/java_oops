import java.util.*;
public class ECommerceOrderSystem{
    public static class Order{ String id; String item; public Order(String id,String item){this.id=id;this.item=item;} public boolean equals(Object o){ if(!(o instanceof Order))return false; return id.equals(((Order)o).id);} public int hashCode(){return id.hashCode();} public String toString(){return id+":"+item;} }
    public static void main(String[]args){
        List<Order> all=new ArrayList<>();
        all.add(new Order("O1","A")); all.add(new Order("O2","B")); all.add(new Order("O1","A"));
        Set<Order> unique=new HashSet<>(all);
        Queue<Order> proc=new LinkedList<>(unique);
        Stack<Order> failed=new Stack<>();
        while(!proc.isEmpty()){
            Order o=proc.remove();
            if(o.id.equals("O2")) failed.push(o); else System.out.println("Processed "+o);
        }
        while(!failed.isEmpty()) System.out.println("Retry "+failed.pop());
    }
}