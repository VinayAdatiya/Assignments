import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetExample {
    public static void main(String[] args) {
        //Initializing Linked Hash Set
        LinkedHashSet<String> lhs=new LinkedHashSet<>();

        //Initializing HashSet
        HashSet<String> hs = new HashSet<>();

        //Adding elements in lhs
        //Order is maintained
        lhs.add("hello");
        lhs.add("world");
        lhs.add("hello"); // Not added into the lhs
        lhs.add("welcome");

        //iterating through lhs
        System.out.println("-----Iterating Through LinkedHashSet(Insertion Order Maintained)-----");
        for (String ele:lhs) {
            System.out.println(ele);
        }

        //Adding elements in hs
        //Order is not maintained
        hs.add("hello");
        hs.add("world");
        hs.add("hello"); // added into the lhs
        hs.add("welcome");
        hs.add("vinay");
        hs.add(null); //hashset allows only one null element
        hs.add(null);

        //iterating through lhs
        System.out.println("-----Iterating Through HashSet(Insertion Order not maintained)-----");
        for (String ele:hs) {
            System.out.println(ele);
        }

        // Hash Set Contains method
        if(hs.contains("vinay")){
            System.out.println("HashSet Contains Vinay");
        }
        //removing elements from the hashset
        System.out.println("-----HashSet after removing element-----");
        hs.remove("vinay");
        for (String ele:hs) {
            System.out.println(ele);
        }
        
        //Size of the HashSet
        System.out.println("Size of the Set :- "+hs.size());
        
        //cloning
        HashSet<String> hs1 = new HashSet<>();
        hs1 = (HashSet)hs.clone();
        System.out.println("Cllonned Hash Set :- "+hs1);

        //clearing all elements
        hs.clear();
        System.out.println("After Clearing all elements :- " + hs);
        System.out.println("After Clearing all elements in hs checking hs1:- " + hs1);
    }
}
