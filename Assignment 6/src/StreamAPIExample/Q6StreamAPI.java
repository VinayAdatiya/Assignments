package StreamAPIExample;

import java.util.*;

public class Q6StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----6. flatMap vs map-----");
        List<List<Integer>> nestedList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(7, 8, 5, 6),
                        Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(10, 9, 11, 12))
        );
        List<List<Integer>> listInteger1 = nestedList
                .stream()
                .map(list -> {
                    List<Integer> sortedList = new ArrayList<>(list);
                    Collections.sort(sortedList);
                    return sortedList;
                })
                .sorted((l1, l2) -> l1.get(0).compareTo(l2.get(0)))
                .toList();
        System.out.println("Nested Integer List Sorted with Map() :- ");
        System.out.println(listInteger1);
        List<Integer> listInteger2 = nestedList
                .stream()
                .flatMap(Collection::stream)
                .sorted().toList();
        System.out.println("Nested Integer List Sorted with flatMap() :- ");
        System.out.println(listInteger2);
    }
}
