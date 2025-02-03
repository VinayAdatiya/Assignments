package StreamAPIExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----2. Summarize Numeric Data with reduce()-----");
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 10, 12)
        );
        int productOfNumbers = numbers.stream().reduce((n1, n2) -> n1 * n2).orElse(0);
        System.out.println("Original List of Integers :- " + numbers);
        System.out.println("output :- " + productOfNumbers);
    }
}
