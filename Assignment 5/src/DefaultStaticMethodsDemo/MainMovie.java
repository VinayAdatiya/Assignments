package DefaultStaticMethodsDemo;
interface simpleBooking{
    Movie movie(String title,double grandTotal);
}
interface complexBooking{
    Movie movie(String title,double grandTotal);
    void cancel(String title);
    static void getDetails(String title){
        System.out.println("Movie Title :- "+title);
    }
    default double applyDiscount(String coupan,double basePrice){
        return basePrice * .90; // 10% Discount
    }
}

class Movie{
    private String title;
    private double basePrice;

    public Movie(String title, double basePrice) {
        this.title = title;
        this.basePrice = basePrice;
        System.out.println("Movie Booked Successfully ...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Movie :- \n" +
                "   title :- " + title + "\n"+
                "   basePrice :- " + basePrice;
    }
}

class TicketBookingSystem implements complexBooking{
    @Override
    public Movie movie(String title,double grandTotal){
        return new Movie(title,grandTotal);
    }

    @Override
    public void cancel(String title){
        System.out.println("Ticket is Cancelled...");
    }
}

public class MainMovie {
    public static void main(String[] args) {
        System.out.println("-----Complex Booking System with Static and Default Methods-----");
        TicketBookingSystem ob1 = new TicketBookingSystem();
        ob1.movie("Pushpa 2",340);
        ob1.cancel("Pushpa 2");
        System.out.println("Discounted price :- "+ob1.applyDiscount("sp10",340));
        complexBooking.getDetails("Pushpa 2");

        System.out.println("-----Modern Booking with Functional Interface and Constructor Reference-----");
        simpleBooking modernBooking = Movie::new;
        Movie ob2 = modernBooking.movie("pushpa 2",200);
    }
}
