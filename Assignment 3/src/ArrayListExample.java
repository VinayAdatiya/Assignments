import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
    }
}
