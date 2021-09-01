package challenge.day2;
/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 27/08/21
 */
public class Paypal extends Payment {

    @Override
    void initialize() {
        System.out.println("Initiate with paypal...");
    }

    @Override
    void startPayment() {
        System.out.println("Paying with paypal...");
    }

    @Override
    void endPayment() {
        System.out.println("Paypal payment finalized...");
    }

}
