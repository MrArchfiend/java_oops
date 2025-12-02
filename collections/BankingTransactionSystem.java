import java.util.*;
public class BankingTransactionSystem{
    public static class Transaction{ String id; String acc; double amt; public Transaction(String id,String acc,double amt){this.id=id;this.acc=acc;this.amt=amt;} public String toString(){return id+":"+acc+":"+amt;} }
    public static void main(String[]args){
        List<Transaction> all=new ArrayList<>();
        all.add(new Transaction("T1","A",100)); all.add(new Transaction("T2","B",200));
        Queue<Transaction> pending=new LinkedList<>(all);
        Set<String> validAccounts=new HashSet<>(Arrays.asList("A","B"));
        Stack<Transaction> rollback=new Stack<>();
        while(!pending.isEmpty()){
            Transaction t=pending.remove();
            if(!validAccounts.contains(t.acc)) System.out.println("Invalid "+t);
            else{ System.out.println("Execute "+t); rollback.push(t); }
        }
        if(!rollback.isEmpty()) System.out.println("Rollback "+rollback.pop());
    }
}