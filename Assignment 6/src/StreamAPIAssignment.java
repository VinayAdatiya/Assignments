//Assignment :
//
//        1. Filter and Sort Lists with Streams
//        Write a program to filter out strings shorter than 4 characters and sort the remaining strings alphabetically.
//        2. Summarize Numeric Data with reduce()
//        Given a list of integers, find the product of all numbers using reduce().
//        3. Group Objects by Category
//        Create a Product class with name and category. Group products by their category using Collectors.groupingBy.
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

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product {
    private String name;
    private String Category;

    public Product(String name, String category) {
        this.name = name;
        Category = category;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}

class Employee {
    private String empId;
    private String Department;
    private double salary;

    public Employee(String empId, String department, double salary) {
        this.empId = empId;
        Department = department;
        this.salary = salary;
    }

    public Employee(String department, double salary) {
        Department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", Department='" + Department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class StreamAPIAssignment {

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

        System.out.println("-----2. Summarize Numeric Data with reduce()-----");
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 10, 12)
        );
        int productOfNumbers = numbers.stream().reduce((n1, n2) -> n1 * n2).orElse(0);
        System.out.println("Original List of Integers :- " + numbers);
        System.out.println("output :- " + productOfNumbers);

        System.out.println("-----3. Group Objects by Category-----");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", "Tech"));
        productList.add(new Product("Mobile", "Tech"));
        productList.add(new Product("Tablet", "Tech"));
        productList.add(new Product("Smart Watch", "Tech"));
        productList.add(new Product("Earbuds", "Accessories"));
        productList.add(new Product("Charger", "Accessories"));
        productList.add(new Product("Cover", "Accessories"));
        productList.add(new Product("Mobile Skin", "Accessories"));
        productList.add(new Product("Screen Protector", "Accessories"));
        Map<String, List<Product>> groupedProducts = productList.stream().collect(Collectors.groupingBy(Product::getCategory));
        for (Map.Entry<String, List<Product>> entryset : groupedProducts.entrySet()) {
            System.out.println("Key :- " + entryset.getKey() + " ||  Value :- " + entryset.getValue());
        }

        System.out.println("-----4. Experiment with Parallel Streams-----");
        long startTime = System.nanoTime();
        List<Integer> integerList = IntStream.range(2, 10000).filter(StreamAPIAssignment::calculatePrime).boxed().collect(Collectors.toList());
        long regularStreamTime = System.nanoTime() - startTime;
        System.out.println("Sequential Stream Time :- " + regularStreamTime);

        startTime = System.nanoTime();
        List<Integer> integerList2 = IntStream.range(2, 10000).parallel().filter(StreamAPIAssignment::calculatePrime).boxed().collect(Collectors.toList());
        long parallelStreamTime = System.nanoTime() - startTime;
        System.out.println("Parallel Stream Time :- " + parallelStreamTime);

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
        System.out.println("Product of nummberList :- "+productOfNumberList);

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

        System.out.println("-----8. Custom Collectors for Aggregation-----");
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("E1", "IT", 30000));
        empList.add(new Employee("E2", "IT", 40000));
        empList.add(new Employee("E3", "IT", 50000));
        empList.add(new Employee("E4", "HR", 32000));
        empList.add(new Employee("E5", "HR", 37000));
        empList.add(new Employee("E6", "HR", 3000));
        empList.add(new Employee("E7", "Support", 300000));
        empList.add(new Employee("E8", "Support", 32000));
        empList.add(new Employee("E9", "Support", 35000));

        Map<String, Double> depWiseSpend = empList.parallelStream().collect(Collector.of(
                HashMap::new,
                (map, emp) -> {
                    map.merge(emp.getDepartment(), emp.getSalary(), Double::sum);
                },
                (map1, map2) -> {
                    for (Map.Entry<String, Double> entry : map2.entrySet()) {
                        String dept = entry.getKey();
                        Double value = entry.getValue();

                        if (map1.containsKey(dept)) {
                            double sum = map1.get(dept) + value;
                            map1.put(dept, sum);
                        } else {
                            map1.put(dept, value);
                        }
                    }
                    return map1;
                }
        ));
        System.out.println("Employee List :- ");
        empList.forEach(System.out::println);
        System.out.println("DeptWise Spend Using Custom Collector :- ");
        System.out.println(depWiseSpend.entrySet());
    }
}
