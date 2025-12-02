import java.util.*;
public class SetProblems{
    public static <T> boolean setsEqual(Set<T> a, Set<T> b){ return a.size()==b.size() && a.containsAll(b); }
    public static <T> Set<T> union(Set<T> a, Set<T> b){ Set<T> out=new HashSet<>(a); out.addAll(b); return out; }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b){ Set<T> out=new HashSet<>(a); out.retainAll(b); return out; }
    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b){
        Set<T> out=new HashSet<>(a); out.addAll(b);
        Set<T> inter=new HashSet<>(a); inter.retainAll(b);
        out.removeAll(inter);
        return out;
    }
    public static List<Integer> setToSortedList(Set<Integer> set){
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public static <T> boolean isSubset(Set<T> small, Set<T> big){ return big.containsAll(small); }
    public static void main(String[]args){
        Set<Integer> s1=new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2=new HashSet<>(Arrays.asList(3,2,1));
        System.out.println(setsEqual(s1,s2));
        System.out.println(union(s1,new HashSet<>(Arrays.asList(3,4,5))));
        System.out.println(intersection(s1,new HashSet<>(Arrays.asList(3,4,5))));
        System.out.println(symmetricDifference(s1,new HashSet<>(Arrays.asList(3,4,5))));
        System.out.println(setToSortedList(new HashSet<>(Arrays.asList(5,3,9,1))));
        System.out.println(isSubset(new HashSet<>(Arrays.asList(2,3)), new HashSet<>(Arrays.asList(1,2,3,4))));
    }
}