import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static Set<Product> inventory = new HashSet<>();
    static Set<Customer> customerList = new HashSet<>();
    static List<Order> orderList = new ArrayList<>();
    public static void main(String[] args) {

        // Listing Product their price and Quantity
        Product product1 = new Product(001,"HP Envy",89999.99,10);
        Product product2 = new Product(001,"HP Envy",89999.99,10);
        Product product3 = new Product(002,"HP Victus",49999.99,13);

        inventory.add(product1);
        //product 2 not added in set due to same id
        inventory.add(product2);
        inventory.add(product3);

        System.out.println("Size of the Inventory :- "+inventory.size());

        Customer customer1 = new Customer(001,"Vinay","vinay@gmail.com","9898978787");
        Customer customer2 = new Customer(001,"Vinay","vinay@gmail.com","9898978787");
        Customer customer3 = new Customer(002,"Raj","raj@gmail.com","1212178787");

        customerList.add(customer1);
        //customer2 having same id as customer1, due to that reason customer2 will be not added in customerList
        customerList.add(customer2);
        customerList.add(customer3);

        System.out.println("No of Customers :- "+customerList.size());

        Order order1 = null;
        Order order2 = null;
        Order order3 = null;
        Order order4 = null;
        Order order5 = null;


        try{
            order1 = new Order(001, customer1 , product1 , 2);

            // it will throw an error invalid order exception
            order2 = new Order(002, customer1 , product1 , 0);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            order3 = new Order(003, customer1 , product1 , 5);

            order5 = new Order(005, customer1 , product3 , 2);

            //it will throw an error stockUnavailable exception
            order4 = new Order(004, customer1 , product1 , 9);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("No of Orders :- "+orderList.size());

        ShoppingCart cart1 = new ShoppingCart(customer1);
        cart1.addOrder(order1);
        cart1.addOrder(order3);
        cart1.addOrder(order5);

        // Listing all the items of cart1
        cart1.viewCart();

        //removing order3 from the cart
        try{
            cart1.removeOrder(003);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Listing all cart products after removing order3
        cart1.viewCart();

        //Generating Bill and clearing cart
        cart1.checkOut();

    }
}
