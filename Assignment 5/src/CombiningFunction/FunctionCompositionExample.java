package CombiningFunction;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        Function<Integer,Integer> square = s -> s*s;
        Function<Integer,Integer> add = s-> s*2;

        Function<Integer,Integer> addThenSquare = square.compose(add);
        Function<Integer,Integer> squareThenAdd = square.andThen(add);

        int ans = addThenSquare.apply(4); // (4+4)*2
        System.out.println("Ans after add then square :- "+ans);

        int ans2 = squareThenAdd.apply(4); // (4*4)*2
        System.out.println("Ans after square then add :- "+ans2);

        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("a");

        Predicate<String> composed1 = startsWithA.and(endsWithX);
        Predicate<String> composed2 = startsWithA.or(endsWithX);

        String input = "A hardworking person must relax";
        boolean result1 = composed1.test(input); //true and false => false
        boolean result2 = composed2.test(input); //true or false => false
        System.out.println(result1);
        System.out.println(result2);
    }
}
