//orderId (Integer, unique)
//customer (Customer object)
//product (Product object)
//quantity (Integer)

//Methods:
//Constructor to initialize an order.
//toString() to display order details.
//Method calculateTotal() to calculate and return the total price of the order.
//Exception handling:
//Throw InvalidOrderException if the quantity requested is invalid (e.g., less than 1 or exceeds stock).
//Use the reduceStock() method from Product.

import Exceptions.InvalidOrderException;
import Exceptions.StockUnavailableException;

import java.util.Objects;

public class Order {
    //Field
    private int orderId;
    private Customer customer;
    private Product product;
    private int quantity;

    //Constructor
    public Order(int orderId, Customer customer, Product product, int quantity) throws InvalidOrderException , StockUnavailableException {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        if (quantity < 1){
            throw new InvalidOrderException("Minimum Order Quantity must be 1");
        }
        product.reduceStock(quantity);
        this.quantity = quantity;

        Main.orderList.add(this);
    }

    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    //toString
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    //calculateTotal
    public double calculateTotal(){
        return product.getPrice() * quantity;
    }

    //Getter Setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
