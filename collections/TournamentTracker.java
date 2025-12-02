import java.util.*;
public class TournamentTracker{
    public static class Player{ String id; public Player(String id){this.id=id;} public String toString(){return id;} public boolean equals(Object o){ if(!(o instanceof Player)) return false; return id.equals(((Player)o).id);} public int hashCode(){return id.hashCode();} }
    public static class Match{ String id; public Match(String id){this.id=id;} public String toString(){return id;} }
    public static class Result{ String match; String winner; public Result(String m,String w){match=m;winner=w;} public String toString(){return match+":"+winner;} }
    public static class Score implements Comparable<Score>{ String player; int pts; public Score(String p,int pts){player=p;this.pts=pts;} public int compareTo(Score o){int r=Integer.compare(o.pts,this.pts); if(r!=0) return r; return player.compareTo(o.player);} public String toString(){return player+":"+pts;} }
    public static void main(String[]args){
        Set<Player> players=new HashSet<>(); players.add(new Player("P1")); players.add(new Player("P2"));
        Queue<Match> matches=new LinkedList<>(); matches.add(new Match("M1")); matches.add(new Match("M2"));
        List<Result> results=new ArrayList<>();
        TreeSet<Score> leaderboard=new TreeSet<>();
        results.add(new Result("M1","P1")); leaderboard.add(new Score("P1",3)); leaderboard.add(new Score("P2",1));
        System.out.println(leaderboard);
    }
}