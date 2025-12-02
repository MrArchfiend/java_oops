import java.util.*;
import java.util.Map.Entry;
public class ShoppingCartSummary{
 public static void main(String[]args){
  LinkedHashMap<String,Double> cart=new LinkedHashMap<>();
  cart.put("Shoes",2500.0);cart.put("Tshirt",800.0);cart.put("Jeans",2200.0);cart.put("Hat",400.0);
  for(Entry<String,Double> e:cart.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
  double total=0;
  for(double p:cart.values()) total+=p;
  if(total>5000) total=total*0.9;
  System.out.println("Total: "+total);
  cart.remove("Hat");
  System.out.println("After removal order:");
  for(Entry<String,Double> e:cart.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}