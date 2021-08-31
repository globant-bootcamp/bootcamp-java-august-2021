package bootcamp;

class Arithmetic {
	int add(int intOne, int intTwo) {
		int sum = intOne + intTwo;
		return sum;
	}
}
class Adder extends Arithmetic {}
 
public class Result {
	 public static void Main(String []args) {
		 Adder adder = new Adder();
		 System.out.println("My superclass is: "+ adder.getClass().getSuperclass().getName());
		 System.out.print(adder.add(40,2) + " " + adder.add(12,1) + " " + adder.add(19,1));
	 }
}
