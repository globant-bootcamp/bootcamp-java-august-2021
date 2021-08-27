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
        Operations operations = new Operations();

        // Print the name of the superclass on operations new line
        System.out.println(SUPERCLASS_IS + operations.getClass().getSimpleName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(operations.add(10, 32) + " " + operations.add(10, 3) + " " + operations.add(10, 10) + "\n");
    }
}
