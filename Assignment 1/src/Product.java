//    id (Integer, unique)
//    name (String)
//    price (Double)
//    quantity (Integer, stock available)

import Exceptions.StockUnavailableException;

import java.util.Objects;

public class Product {

    // Field
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // equals with id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    // hashCode with id
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    //reduce Stock
    public void reduceStock(int quantity) throws StockUnavailableException {
        if (this.quantity < quantity) {
            throw new StockUnavailableException("Insufficient stock available.");
        } this.quantity -= quantity;
    }

    // Getter Setter for all Fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
