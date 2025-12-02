import java.util.*;
public class InventoryManagement{
 public static void main(String[]args){
  Map<String,Integer> stock=new HashMap<>();
  stock.put("apple",50);stock.put("banana",30);stock.put("milk",10);stock.put("bread",0);
  buy(stock,"apple",5);
  buy(stock,"milk",12);
  restock(stock,"milk",20);
  System.out.println(query(stock,"bread"));
  System.out.println("Out of stock:");
  for(Map.Entry<String,Integer> e:stock.entrySet()) if(e.getValue()==0) System.out.println(e.getKey());
 }
 static void buy(Map<String,Integer> stock,String product,int qty){
  int cur=stock.getOrDefault(product,0);
  cur-=qty;
  if(cur<=0) stock.put(product,0); else stock.put(product,cur);
 }
 static void restock(Map<String,Integer> stock,String product,int qty){
  stock.put(product,stock.getOrDefault(product,0)+qty);
 }
 static String query(Map<String,Integer> stock,String product){
  if(!stock.containsKey(product)) return "not stocked";
  return String.valueOf(stock.get(product));
 }
}