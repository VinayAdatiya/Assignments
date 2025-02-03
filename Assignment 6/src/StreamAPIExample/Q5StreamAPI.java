package StreamAPIExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Q5StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----5. Custom Collectors-----");
        List<Integer> numberList = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );
        int productOfNumberList = numberList
                .stream()
                .collect(
                        Collector.of(
                                ()->new int[]{1},   //supplier
                                (e1,e2)->e1[0]*=e2,     //accumulator
                                (e1,e2) -> {
                                    e1[0]*=e2[0];
                                    return e1;
                                },      //combiner
                                a->a[0]     //finisher
                        )
                );
        System.out.println("StreamAPIExample.Product of numberList :- "+productOfNumberList);
    }
}
