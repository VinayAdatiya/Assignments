import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        //Initializing TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        //Adding Elements into the tree set
        //store in ascending order
        treeSet.add("Vinay");
        treeSet.add("Hello");
        treeSet.add("Vinay"); // do not allow duplicates
//        treeSet.add(null); not allowed
        treeSet.add("Jay");
        treeSet.add("World");
        treeSet.add("Java");

        System.out.println("-----Printing TreeSet-----");
        System.out.println(treeSet);
        System.out.println("Intial Set: "+treeSet);
        System.out.println("Head Set(...,Vinay): "+treeSet.headSet("Vinay"));
        System.out.println("SubSet(Jay,world): "+treeSet.subSet("Jay", "World"));
        System.out.println("TailSet(Vinay,...): "+treeSet.tailSet("Vinay"));

        System.out.println("Printing Treeset using descending iterator");
        Iterator i=treeSet.descendingIterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        System.out.println("First Element :- "+treeSet.pollFirst());
        System.out.println("Last Element :- "+treeSet.pollLast());
        System.out.println("-----Printing TreeSet after polling elements");
        System.out.println(treeSet);
    }
}
