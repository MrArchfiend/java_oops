import java.util.*;
public class VotingCount{
 public static void main(String[]args){
  Map<String,Integer> votes=new HashMap<>();
  String[] ballot={"Alice","Bob","Charlie","Alice","Bob","Alice","Charlie","Bob","Bob","Alice"};
  for(String name:ballot) votes.put(name,votes.getOrDefault(name,0)+1);
  System.out.println("Totals: "+votes);
  String winner=votes.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
  System.out.println("Winner: "+winner);
 }
}