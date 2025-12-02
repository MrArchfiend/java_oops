import java.util.*;
public class SportsTournamentScheduler{
    public static class Team{ String id; int points; public Team(String id,int points){this.id=id;this.points=points;} public String toString(){return id+":"+points;} public boolean equals(Object o){ if(!(o instanceof Team)) return false; return id.equals(((Team)o).id);} public int hashCode(){return id.hashCode();} }
    public static class Match{ String id; public Match(String id){this.id=id;} public String toString(){return id;} }
    public static void main(String[]args){
        Set<Team> teams=new HashSet<>(); teams.add(new Team("T1",3)); teams.add(new Team("T2",6));
        Queue<Match> fixtures=new LinkedList<>(); fixtures.add(new Match("M1"));
        List<String> results=new ArrayList<>();
        TreeSet<Team> ranking=new TreeSet<>((a,b)->Integer.compare(b.points,a.points));
        ranking.addAll(teams);
        System.out.println(ranking);
    }
}