package StreamAPIExample;//Assignment :
//
//        1. Filter and Sort Lists with Streams
//        Write a program to filter out strings shorter than 4 characters and sort the remaining strings alphabetically.
//        2. Summarize Numeric Data with reduce()
//        Given a list of integers, find the product of all numbers using reduce().
//        3. Group Objects by Category
//        Create a StreamAPIExample.Product class with name and category. Group products by their category using Collectors.groupingBy.
//        4. Experiment with Parallel Streams
//        Compare the performance of sequential vs parallel streams for a CPU-intensive computation (e.g., calculating primes).
//        5. Custom Collectors
//        Implement a custom Collector to calculate the product of numbers in a stream.
//        6. flatMap vs map
//        Use flatMap to process nested lists of strings, and compare with map.
//        7. Stream Performance
//        Analyze the performance of spliterator and learn tips for efficient parallelization.
//        8. Custom Collector for Aggregation
//        Write a custom collector to aggregate employee salaries into a department-wise total.

import java.util.*;

public class StreamAPIAssignment {
    static List<Product> productList = new ArrayList<>();
    static List<Employee> empList = new ArrayList<>();
    static {
        productList.add(new Product("Laptop", "Tech"));
        productList.add(new Product("Mobile", "Tech"));
        productList.add(new Product("Tablet", "Tech"));
        productList.add(new Product("Smart Watch", "Tech"));
        productList.add(new Product("Earbuds", "Accessories"));
        productList.add(new Product("Charger", "Accessories"));
        productList.add(new Product("Cover", "Accessories"));
        productList.add(new Product("Mobile Skin", "Accessories"));
        productList.add(new Product("Screen Protector", "Accessories"));

        empList.add(new Employee("E1", "IT", 30000));
        empList.add(new Employee("E2", "IT", 40000));
        empList.add(new Employee("E3", "IT", 50000));
        empList.add(new Employee("E4", "HR", 32000));
        empList.add(new Employee("E5", "HR", 37000));
        empList.add(new Employee("E6", "HR", 3000));
        empList.add(new Employee("E7", "Support", 300000));
        empList.add(new Employee("E8", "Support", 32000));
        empList.add(new Employee("E9", "Support", 35000));
    }
}
