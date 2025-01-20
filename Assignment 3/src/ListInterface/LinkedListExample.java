package ListInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        //Initializing LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding Elements into the linkedList
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Welcome");
        linkedList.add("to");
        linkedList.add("the world of coding");

        // Initializing iterator
        Iterator<String> itr = linkedList.iterator();

        //Iterating through linkedList
        System.out.println("-----LinkedList using Iterator-----");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // Initializing another list called ll2
        LinkedList<String> ll2 = new LinkedList<>();
        ll2.add("Java");
        ll2.add("Python");

        //adding at first place in main linkedList
        linkedList.addFirst("Jay Ho!!!");
        //adding at last place in main linkedList
        linkedList.addLast("Thank You!!!");
        //adding a complete another ll2 in main linkedList
        linkedList.addAll(1,ll2);

        //Iterating through linkedList
        System.out.println("-----LinkedList After Adding First Last and Complete List in between -----");
//        ConcurrentModificationException :-
//              IMP :- after modification iterator becomes invalid !!!
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
        for (String ll:linkedList) {
            System.out.println(ll);
        }

        //Reversing LinkedList
        System.out.println("-----LinkedList After reversing it-----");
        Collections.reverse(linkedList);
        for (String ll:linkedList) {
            System.out.println(ll);
        }

        //Sorting LinkedList
        System.out.println("-----LinkedList After Sorting it-----");
        Collections.sort(linkedList);
        for (String ll:linkedList) {
            System.out.println(ll);
        }

        //Removing Elements based on position and elements
        System.out.println("-----LinkedList After Removing elements-----");
        linkedList.remove(0);
        linkedList.remove("Hello");
        for (String ll:linkedList) {
            System.out.println(ll);
        }
    }
}
