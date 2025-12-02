import java.util.*;
public class ListProblems{
    public static <T> List<T> reverseList(List<T> list){
        List<T> out = new ArrayList<>(list.size());
        for(int i=list.size()-1;i>=0;i--) out.add(list.get(i));
        return out;
    }
    public static List<Integer> reverseLinkedList(LinkedList<Integer> list){
        LinkedList<Integer> out = new LinkedList<>();
        for(Integer v: list) out.addFirst(v);
        return out;
    }
    public static Map<String,Integer> frequency(List<String> list){
        Map<String,Integer> freq=new HashMap<>();
        for(String s:list) freq.put(s,freq.getOrDefault(s,0)+1);
        return freq;
    }
    public static <T> List<T> rotate(List<T> list,int k){
        int n=list.size();
        if(n==0) return new ArrayList<>();
        k=((k%n)+n)%n;
        List<T> out=new ArrayList<>(n);
        for(int i=0;i<n;i++) out.add(list.get((i+k)%n));
        return out;
    }
    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list){
        Set<T> seen=new LinkedHashSet<>();
        List<T> out=new ArrayList<>();
        for(T e:list) if(seen.add(e)) out.add(e);
        return out;
    }
    public static <T> T nthFromEnd(LinkedList<T> list,int n){
        Iterator<T> it=list.iterator();
        for(int i=0;i<n;i++) if(it.hasNext()) it.next(); else return null;
        Iterator<T> lead=list.iterator();
        Iterator<T> follow=list.iterator();
        for(int i=0;i<n;i++) lead.next();
        while(lead.hasNext()){
            lead.next();
            follow.next();
        }
        return follow.hasNext()?follow.next():null;
    }
    public static void main(String[]args){
        List<Integer> a=Arrays.asList(1,2,3,4,5);
        System.out.println(reverseList(a));
        LinkedList<Integer> ll=new LinkedList<>(a);
        System.out.println(reverseLinkedList(ll));
        List<String> fruits=Arrays.asList("apple","banana","apple","orange");
        System.out.println(frequency(fruits));
        System.out.println(rotate(Arrays.asList(10,20,30,40,50),2));
        System.out.println(removeDuplicatesPreserveOrder(Arrays.asList(3,1,2,2,3,4)));
        LinkedList<String> letters=new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        System.out.println(nthFromEnd(letters,2));
    }
}