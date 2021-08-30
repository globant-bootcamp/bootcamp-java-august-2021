package challenge.day2;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 27/08/21
 */
public abstract class Payment {
    /**
     * Create methods for payment processes
     */
    abstract void initialize();

    abstract void startPayment();

    abstract void endPayment();

    public final void makePayment() {
        initialize();
        startPayment();
        endPayment();
    }
}
