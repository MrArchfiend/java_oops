import java.util.*;
public class HospitalPatientManagementSystem{
    public static class Patient{ String id; public Patient(String id){this.id=id;} public String toString(){return id;} public boolean equals(Object o){ if(!(o instanceof Patient)) return false; return id.equals(((Patient)o).id);} public int hashCode(){return id.hashCode();} }
    public static void main(String[]args){
        Set<Patient> admitted=new HashSet<>();
        Queue<Patient> waiting=new LinkedList<>();
        Stack<Patient> discharged=new Stack<>();
        List<Patient> history=new ArrayList<>();
        Patient p1=new Patient("P1");
        admitted.add(p1); waiting.add(p1); history.add(p1);
        while(!waiting.isEmpty()){
            Patient p=waiting.remove();
            System.out.println("Treat "+p);
            admitted.remove(p);
            discharged.push(p);
        }
        Patient re=discharged.pop();
        admitted.add(re);
        System.out.println(history);
    }
}