package StreamAPIExample;

import java.util.List;
import java.util.stream.IntStream;

public class Q4StreamAPI {
    public static boolean calculatePrime(int n) {
        int count = 0;
        for (int j = 1; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                count += 1;
            }
        }
        return count < 2;
    }
    public static void main(String[] args) {
        System.out.println("-----4. Experiment with Parallel Streams-----");
        long startTime = System.nanoTime();
        List<Integer> integerList = IntStream.range(2, 10000).filter(Q4StreamAPI::calculatePrime).boxed().toList();
        long regularStreamTime = System.nanoTime() - startTime;
        System.out.println("Sequential Stream Time :- " + regularStreamTime);
        startTime = System.nanoTime();
        List<Integer> integerList2 = IntStream.range(2, 10000).parallel().filter(Q4StreamAPI::calculatePrime).boxed().toList();
        long parallelStreamTime = System.nanoTime() - startTime;
        System.out.println("Parallel Stream Time :- " + parallelStreamTime);
    }
}
