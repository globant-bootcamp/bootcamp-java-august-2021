package challenge.day2;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 27/08/21
 */

public class Ticket {
    public static void main(String[] args) {
        PayHamburger();
        PayHotDog();
    }

    private static void PayHamburger() {
        System.out.println("The payment for the hamburger:");
        Payment payment = new Visa();
        payment.makePayment();
    }

    private static void PayHotDog() {
        System.out.println("The payment for the hotdog:");
        Payment payment = new Paypal();
        payment.makePayment();
    }
}
