import java.util.*;
public class InventoryRestockSystem{
    public static class Product{ String name; double price; int stock; public Product(String n,double p,int s){name=n;price=p;stock=s;} public String toString(){return name+":"+stock;} }
    public static void main(String[]args){
        Set<String> productNames=new HashSet<>();
        List<Product> products=new ArrayList<>();
        Queue<Product> restock=new LinkedList<>();
        Stack<Product> recent=new Stack<>();
        products.add(new Product("Milk",20,5)); products.add(new Product("Bread",10,0));
        for(Product p:products) productNames.add(p.name);
        for(Product p:products) if(p.stock<5) restock.add(p);
        while(!restock.isEmpty()){ Product p=restock.remove(); p.stock+=20; recent.push(p); }
        Product undone=recent.pop();
        System.out.println(undone);
    }
}