import java.util.*;
public class LibraryCatalog{
 public static void main(String[]args){
  Map<String,String> catalog=new HashMap<>();
  catalog.put("978-1234567890","The Java Way");
  catalog.put("978-1111111111","Algorithms");
  catalog.put("978-2222222222","Data Structures");
  catalog.put("978-3333333333","Design Patterns");
  System.out.println(searchByISBN(catalog,"978-1111111111"));
  catalog.remove("978-3333333333");
  TreeMap<String,String> sorted=new TreeMap<>(catalog);
  for(Map.Entry<String,String> e:sorted.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
  System.out.println(searchByTitle(catalog,"Algorithms"));
 }
 static String searchByISBN(Map<String,String> catalog,String isbn){
  return catalog.getOrDefault(isbn,"Book not found");
 }
 static List<String> searchByTitle(Map<String,String> catalog,String title){
  List<String> list=new ArrayList<>();
  for(Map.Entry<String,String> e:catalog.entrySet()) if(e.getValue().equalsIgnoreCase(title)) list.add(e.getKey());
  return list;
 }
}