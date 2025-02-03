package StreamAPIExample;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q7StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----7. Stream Performance-----");

        //Performance of Spliterator
        Stream<Integer> integerStream1 = IntStream.rangeClosed(1000, 9999).boxed();
        Spliterator<Integer> splitr = integerStream1.spliterator();
        System.out.println("Estimate size: " + splitr.estimateSize());
        System.out.println("Exact size: " + splitr.getExactSizeIfKnown());
        System.out.println("integerStream1 Elements using spliterator :- ");
        long start = System.currentTimeMillis();
        splitr.forEachRemaining((n) -> {
            if (n % 1000 == 0) {
                System.out.print(n + " ");
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("Time Taken By Spliterator :- " + (end - start));

        //Performance of normal iterator
        List<Integer> integerList1 = IntStream.rangeClosed(1000, 9999).boxed().toList();
        Iterator<Integer> itr = integerList1.listIterator();
        start = System.currentTimeMillis();
        while (itr.hasNext()) {
            if (itr.next() % 1000 == 0) {
                System.out.print(itr.next()-1+" ");
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time Taken By Normal Iterator :- " + (end - start));
    }
}
