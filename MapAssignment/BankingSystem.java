import java.util.*;
public class BankingSystem{
 public static void main(String[]args){
  Map<String,Double> bank=new HashMap<>();
  bank.put("ACC1",1000.0);bank.put("ACC2",50000.0);bank.put("ACC3",7500.0);bank.put("ACC4",120000.0);bank.put("ACC5",300.0);
  deposit(bank,"ACC1",500);
  withdraw(bank,"ACC5",100);
  withdraw(bank,"ACC5",300);
  List<Map.Entry<String,Double>> list=new ArrayList<>(bank.entrySet());
  list.sort((a,b)->Double.compare(b.getValue(),a.getValue()));
  for(Map.Entry<String,Double> e:list) System.out.println(e.getKey()+" -> "+e.getValue());
  for(int i=0;i<Math.min(3,list.size());i++) System.out.println("Top"+(i+1)+": "+list.get(i).getKey());
 }
 static void deposit(Map<String,Double> bank,String acc,double amt){ bank.put(acc,bank.getOrDefault(acc,0.0)+amt); }
 static void withdraw(Map<String,Double> bank,String acc,double amt){
  double bal=bank.getOrDefault(acc,0.0);
  if(amt>bal){ System.out.println("Insufficient funds for "+acc); return; }
  bank.put(acc,bal-amt);
 }
}