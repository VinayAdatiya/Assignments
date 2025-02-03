package StreamAPIExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----1. Filter and Sort Lists with Streams-----");
        List<String> names = new ArrayList<>(
                Arrays.asList("Vinay", "Raj", "Harsh", "Jay", "Raju", "Ajay", "Amit", "Krushit", "Vikas", "Arpan")
        );
        List<String> filtredStreamList = names
                .stream()
                .filter(p -> p.length() < 4)
                .sorted()
                .toList();
        System.out.println("Actual List :- " + names);
        System.out.println("Output :- " + filtredStreamList);
    }
}
