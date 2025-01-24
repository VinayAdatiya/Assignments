interface makePayment{
    void payment();
}

public class AnonymousExample {

    public static void main(String[] args) {

        //Traditional Way
        class UPI implements makePayment{
            @Override
            public void payment() {
                System.out.println("Payment Successfully Done Via UPI");
            }
        }
        UPI upi = new UPI();


        //Updated way using LambdaExpression in Java 8+
        makePayment debitCardPayment = () -> System.out.println("Payment Successfully Done Via Debit Card.");
        //Updated way in Java 8+ without lambda Expression
        makePayment creditCardPayment = new makePayment() {
            @Override
            public void payment() {
                System.out.println("Payment Successfully Done Via Credit Card.");
            }
        };

        upi.payment();
        debitCardPayment.payment();
        creditCardPayment.payment();
    }
}