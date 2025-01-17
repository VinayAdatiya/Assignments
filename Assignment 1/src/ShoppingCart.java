import Exceptions.OrderNotFoundException;

import java.util.ArrayList;
import java.util.List;

//Attributes:
//        customer (Customer object)
//        cartItems (List of Order objects)
//
//Methods:
//        Method addOrder(Order order) to add an order to the cart.
//        Method removeOrder(int orderId) to remove an order; throw OrderNotFoundException if the order does not exist.
//        Method viewCart() to display all items in the cart.
//        Method checkout() to display the total price and clear the cart.


public class ShoppingCart{
    private Customer customer;
    static List<Order> cartItems = new ArrayList<>();

    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    // Adding an Order into the Cart
    public void addOrder(Order order){
        if (order != null){
            cartItems.add(order);
            System.out.println("Order "+order.getOrderId()+" is successfully added into the "+customer.getName()+"'s cart");
        }
        else{
            System.out.println("Order is not added into the cart");
        }
    }

    // Removing an Order from the Cart
    public void removeOrder(int orderId) throws OrderNotFoundException{
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getOrderId() == orderId){
                cartItems.remove(cartItems.get(i));
                System.out.println("Order is removed successfully from the cart");
                return ;
            }
        }
        throw new OrderNotFoundException("Order is not exist in item cart");
    }

    //viewCart
    public void viewCart(){
        double grandTotal = 0.0;
        System.out.println("----------Cart Items----------");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println("Order ID :- "+cartItems.get(i).getOrderId());
            System.out.println("    Product Details :- ");
            System.out.println("        Product Title :- "+cartItems.get(i).getProduct().getName());
            System.out.println("        Product Unit Price :- ₹"+cartItems.get(i).getProduct().getPrice());
            System.out.println("    Ordered Quantity :- "+cartItems.get(i).getQuantity());
            System.out.println("    Total :- ₹"+cartItems.get(i).calculateTotal());
            grandTotal += cartItems.get(i).calculateTotal();
            }
        System.out.println("Grand Total :- ₹"+grandTotal);
        }

    public void checkOut(){
        //Fields
        double totalPrice = 0.0;
        double taxableAmount = 0.0;
        double grandTotal = 0.0;

        //Total Price Calculation Logic
        for(Order order:cartItems){
            totalPrice += order.calculateTotal();
        }

        //Taxable Amount Logic
        taxableAmount = totalPrice * .12 * 2;
        grandTotal = totalPrice + taxableAmount;

        // Bill Printing
        System.out.println("----------BILL----------");
        System.out.println("Total Price :- ₹"+totalPrice);
        System.out.println("CGST :- ₹"+totalPrice*.12);
        System.out.println("SGST :- ₹"+totalPrice*.12);
        System.out.println("Total Taxable Amount :- ₹"+taxableAmount);
        System.out.println("Grand Total :- ₹"+grandTotal);

        // all Cart items are removed
        cartItems.clear();
    }
}
