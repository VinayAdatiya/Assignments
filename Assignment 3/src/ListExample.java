import java.util.*;

class Customer implements Comparable<Customer>{
    private int customerId;
    private String firstName;
    private String lastName;
    private String mobileNo;

    public Customer(int customerId, String firstName, String lastName, String mobileNo) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(mobileNo, customer.mobileNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, mobileNo);
    }

    @Override
    public String toString() {
        return "Customer :- \n" +
                "   customerId = " + customerId + '\n' +
                "   firstName = " + firstName + '\n' +
                "   lastName = " + lastName + '\n' +
                "   mobileNo = " + mobileNo + '\n';
    }

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(this.customerId,o.customerId);
    }
}
public class ListExample {
    public static void main(String[] args) {
        //Initializing Customer
        List<Customer> customerList = new ArrayList<Customer>();

        //Customer Objects
        Customer cs1 = new Customer(001,"Vinay","Adatiya","9898951515");
        Customer cs2 = new Customer(002,"Raj","Shah","9898978787");
        // Overrided hashcode & equals on mobile number and id still
        Customer cs3 = new Customer(003,"Raj","Shah","9898978787");

        // adding Customer Object into the list (Create)
        customerList.add(cs1);
        customerList.add(cs2);
        customerList.add(cs3);

        System.out.println("-----Iterating List Through forEach-----");
        //iterating through for each object and printing it
        for (Customer customer:customerList) {
            System.out.println(customer);
        }

        //removing customer object at 0th index (Delete)
        customerList.remove(0);

        //accessing customer at 0 th index (Read)
        System.out.println("-----Get-----");
        System.out.println("Customer at index 0 :- \n"+customerList.get(0));

        //again setting cs1 at last index of the list   (Update)
        customerList.set(1,cs1);

        //List Iterator
        System.out.println("-----List Iterator-----");
        ListIterator<Customer> iterator = customerList.listIterator();
        while (iterator.hasNext()){
            System.out.println("List Index :- "+ iterator.nextIndex() + "\nValue :- "+iterator.next());
        }

        //Implemented Comparable in Customer Class and sorted based on CustomerId
        Collections.sort(customerList);

        System.out.println("-----Iterating List Through forEach After Sorting based on customerId-----");
        //iterating through for each object and printing it
        for (Customer customer:customerList) {
            System.out.println(customer);
        }
    }
}
