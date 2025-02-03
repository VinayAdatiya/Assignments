package StreamAPIExample;

import java.util.stream.Collectors;

public class Q3StreamAPI {
    public static void main(String[] args) {
        System.out.println("-----3. Group Objects by Category-----");
        StreamAPIAssignment.productList.stream().collect(Collectors.groupingBy(Product::getCategory)).forEach((s, products) -> {
            System.out.println("Key :- " + s + " ||  Value :- " + products);
        });
    }
}
