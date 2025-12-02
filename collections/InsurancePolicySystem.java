import java.util.*;
import java.time.*;
public class InsurancePolicySystem{
    public static class Policy implements Comparable<Policy>{
        private final String number;
        private final String holder;
        private final LocalDate expiry;
        private final String coverage;
        private final double premium;
        public Policy(String number,String holder,LocalDate expiry,String coverage,double premium){
            this.number=number;this.holder=holder;this.expiry=expiry;this.coverage=coverage;this.premium=premium;
        }
        public String getNumber(){return number;}
        public String getHolder(){return holder;}
        public LocalDate getExpiry(){return expiry;}
        public String getCoverage(){return coverage;}
        public double getPremium(){return premium;}
        public int compareTo(Policy o){ return this.expiry.compareTo(o.expiry); }
        public boolean equals(Object o){ if(!(o instanceof Policy)) return false; Policy p=(Policy)o; return number.equals(p.number); }
        public int hashCode(){ return number.hashCode(); }
        public String toString(){ return number+"|"+holder+"|"+expiry+"|"+coverage+"|"+premium; }
    }
    public static Set<Policy> asHashSet(Collection<Policy> c){ return new HashSet<>(c); }
    public static Set<Policy> asLinkedHashSet(Collection<Policy> c){ return new LinkedHashSet<>(c); }
    public static Set<Policy> asTreeSet(Collection<Policy> c){ return new TreeSet<>(c); }
    public static List<Policy> policiesExpiringSoon(Collection<Policy> policies,int days){
        LocalDate now=LocalDate.now();
        LocalDate limit=now.plusDays(days);
        List<Policy> out=new ArrayList<>();
        for(Policy p:policies) if(!p.getExpiry().isAfter(limit)) out.add(p);
        return out;
    }
    public static List<Policy> policiesByCoverage(Collection<Policy> policies,String coverage){
        List<Policy> out=new ArrayList<>();
        for(Policy p:policies) if(p.getCoverage().equalsIgnoreCase(coverage)) out.add(p);
        return out;
    }
    public static List<Policy> duplicatePoliciesByNumber(Collection<Policy> policies){
        Map<String,Integer> counts=new HashMap<>();
        for(Policy p:policies) counts.put(p.getNumber(), counts.getOrDefault(p.getNumber(),0)+1);
        List<Policy> out=new ArrayList<>();
        for(Policy p:policies) if(counts.get(p.getNumber())>1) out.add(p);
        return out;
    }
    public static Map<String,Long> performanceCompare(Collection<Policy> policies){
        Map<String,Long> result=new HashMap<>();
        long start, end;
        start=System.nanoTime();
        Set<Policy> hs=new HashSet<>();
        for(Policy p:policies) hs.add(p);
        end=System.nanoTime();
        result.put("HashSet_add_ns", end-start);
        start=System.nanoTime();
        hs.contains(policies.iterator().next());
        end=System.nanoTime();
        result.put("HashSet_contains_ns", end-start);
        start=System.nanoTime();
        hs.remove(policies.iterator().next());
        end=System.nanoTime();
        result.put("HashSet_remove_ns", end-start);
        start=System.nanoTime();
        Set<Policy> lhs=new LinkedHashSet<>();
        for(Policy p:policies) lhs.add(p);
        end=System.nanoTime();
        result.put("LinkedHashSet_add_ns", end-start);
        start=System.nanoTime();
        Set<Policy> ts=new TreeSet<>();
        for(Policy p:policies) ts.add(p);
        end=System.nanoTime();
        result.put("TreeSet_add_ns", end-start);
        return result;
    }
    public static void main(String[]args){
        List<Policy> list=new ArrayList<>();
        list.add(new Policy("P1","Alice",LocalDate.now().plusDays(10),"Health",5000));
        list.add(new Policy("P2","Bob",LocalDate.now().plusDays(40),"Auto",3000));
        list.add(new Policy("P3","Carol",LocalDate.now().plusDays(20),"Home",4500));
        list.add(new Policy("P1","Alice",LocalDate.now().plusDays(10),"Health",5000));
        System.out.println(asHashSet(list));
        System.out.println(asLinkedHashSet(list));
        System.out.println(asTreeSet(list));
        System.out.println(policiesExpiringSoon(list,30));
        System.out.println(policiesByCoverage(list,"Health"));
        System.out.println(duplicatePoliciesByNumber(list));
        System.out.println(performanceCompare(list));
    }
}