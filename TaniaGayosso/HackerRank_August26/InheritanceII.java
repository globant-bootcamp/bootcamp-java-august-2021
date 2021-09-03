package challenges.two;

class Arithmetic {
	public int add(int number1, int number2) {
		int sum = number1 + number2;
		return sum;
	}
}

class Adder extends Arithmetic {
}

public class InheritanceII {
	public static void main(String[] args) {
		
		Adder a = new Adder();
		
		System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

		System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
	}
}