package challenge.day2;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 27/08/21
 */
public class Visa extends Payment {

    @Override
    void initialize() {
        System.out.println("Initiate with VISA....");
    }

    @Override
    void startPayment() {
        System.out.println("Paying with VISA....");
    }

    @Override
    void endPayment() {
        System.out.println("VISA payment finalized...");
    }

}
