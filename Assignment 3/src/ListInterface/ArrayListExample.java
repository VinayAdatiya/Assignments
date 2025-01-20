package ListInterface;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Initializing ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Adding elements into ArrayList
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(-20);
        arrayList.add(30);

        // Iterating ArrayList using forEach
        System.out.println("-----Array List-----");
        for (Integer ele:arrayList) {
            System.out.println(ele);
        }

        //Sorting ArrayList
        Collections.sort(arrayList);
        System.out.println("-----Array List After Sorting-----");
        for (Integer ele:arrayList) {
            System.out.println(ele);
        }

        //arrayList remove at index 1
        arrayList.remove(1);

        //arrayList After Removing Elements
        System.out.println("-----Array List After Removing Element-----");
        for (Integer ele:arrayList) {
            System.out.println(ele);
        }

        //arrayList Set
        System.out.println("-----Array List After Updating Element-----");
//        arrayList.set(1,"Hello");  Give an error because arrayList contains only int
        arrayList.set(1,10);
        for (Integer ele:arrayList) {
            System.out.println(ele);
        }

        System.out.println("-----New ArrayList of String");
        ArrayList<String> arr2 = new ArrayList();
        arr2.add("Vinay");
        arr2.add("Krushit");
        arr2.add("Vikas");
        arr2.add("Arpan");
        System.out.println("Before Removing Element :- "+arr2);
        System.out.println("-----Removing element by value-----");
        arr2.remove("Vinay");
        System.out.println("After Removing element :- "+arr2);

        System.out.println("Iterating through Arraylist using stream");
        arr2.stream().forEach(System.out::println);

        System.out.println("-----Sorting Names with sort()-----");
        Collections.sort(arr2);
        System.out.println(arr2);

        System.out.println("-----Binary Search-----");
        System.out.println("Index of Vikas using binary search :- "+Collections.binarySearch(arr2,"Vikas"));

        System.out.println("-----Collections.Frequency()-----");
        arr2.add("Vikas");
        System.out.println("Frequency :- "+ Collections.frequency(arr2,"Vikas"));

        System.out.println("After Converting arrayList to Array :- ");
        String[] arrayEx = arr2.toArray(new String[arr2.size()]);
        System.out.println("Array Example :- "+arrayEx);
        for (String arr:arrayEx) {
            System.out.print(arr+" ");
        }

        System.out.println("\nAgain Converting array to list :- ");
        List<String> newList = Arrays.asList(arrayEx);
        System.out.println(newList);

    }
}
