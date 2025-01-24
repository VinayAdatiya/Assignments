package LambdaFunction;

import java.util.*;
import java.util.function.*;

public class LambdaFunctionTutorial {
    // Traditional approach: Using an interface with a method
    interface NumberProcessor {
        int process(int number);
    }

    public static void demonstrateLambdaEvolution() {
        // 1. Traditional Anonymous Inner Class Approach
        NumberProcessor squareTraditional = new NumberProcessor() {
            @Override
            public int process(int number) {
                return number * number;
            }
        };

        // 2. Lambda Expression - Simplified Syntax
        NumberProcessor squareLambda = (number) -> number * number;

        // 3. Lambda with Multiple Parameters <T first argument,U second argument,R return type>
        BiFunction<Integer, Integer, Integer> addNumbers = (a, b) -> a + b;

        // 4. Lambda with Complex Logic
        Function<String, Integer> stringLength = (str) -> {
            System.out.println("Processing string: " + str);
            return str.length();
        };

        // Example Demonstrations
        System.out.println("Traditional Square: " + squareTraditional.process(5));
        System.out.println("Lambda Square: " + squareLambda.process(5));
        System.out.println("Add Numbers: " + addNumbers.apply(3, 4));
        System.out.println("String Length: " + stringLength.apply("Hello Lambda"));
    }

    // Real-world Example: Sorting with Lambda
    public static void sortingExample() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Traditional Comparator
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });

        // Lambda Comparator - Concise Version
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Method Reference - Most Concise
        Collections.sort(people, Comparator.comparingInt(Person::getAge));
    }

    // Demonstration of Different Lambda Use Cases
    public static void lambdaUseCases() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1. Filtering with Predicate Lambda
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println("Even Numbers :- "+evenNumbers);

        // 2. Mapping with Function Lambda
        List<Integer> squaredNumbers = numbers.stream()
                .map(num -> num * num)
                .toList();
        System.out.println("Squared Numbers :- "+squaredNumbers);

        // 3. Reducing with BinaryOperator Lambda
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum after Reducing with Binary Operator :- "+sum);
    }

    // Simple Person class for demonstration
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() { return age; }
    }

    public static void main(String[] args) {
        demonstrateLambdaEvolution();
        sortingExample();
        lambdaUseCases();
    }
}
