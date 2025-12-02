import java.util.*;
public class StreamingWatchHistory{
    public static class Movie{ String id; String genre; public Movie(String id,String g){this.id=id;this.genre=g;} public String toString(){return id;} }
    public static void main(String[]args){
        Stack<Movie> history=new Stack<>();
        List<Movie> all=new ArrayList<>();
        Set<String> genres=new HashSet<>();
        Queue<Movie> upNext=new LinkedList<>();
        Movie m1=new Movie("M1","Drama");
        upNext.add(m1);
        Movie now=upNext.remove();
        history.push(now);
        genres.add(now.genre);
        System.out.println(history.peek());
    }
}