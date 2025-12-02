import java.util.*;
public class LibraryManagementSystem{
    public static class Book{ String id; public Book(String id){this.id=id;} public String toString(){return id;} }
    public static void main(String[]args){
        List<Book> books=new ArrayList<>();
        Set<String> members=new HashSet<>();
        Queue<Book> issueQueue=new LinkedList<>();
        Stack<Book> returned=new Stack<>();
        books.add(new Book("B1")); books.add(new Book("B2"));
        members.add("M1"); members.add("M1");
        issueQueue.add(books.get(0));
        Book b=issueQueue.remove();
        returned.push(b);
        System.out.println(returned.peek());
    }
}