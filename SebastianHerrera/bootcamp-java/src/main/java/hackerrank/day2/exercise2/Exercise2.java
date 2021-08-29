package hackerrank.day2.exercise2;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 26/08/21
 */
public class Exercise2 {

    public static final String SUPERCLASS_IS = "My superclass is: ";

    /**
     * Set the values to Operation class
     */
    public static void setOperationInfo() {
        // Create operations new Adder object
        Adder adder = new Adder();

        // Print the name of the superclass on operations new line
        System.out.println(SUPERCLASS_IS + adder.getClass().getSuperclass().getSimpleName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(adder.add(10, 32) + " " + adder.add(10, 3) + " " + adder.add(10, 10) + "\n");
    }
}
