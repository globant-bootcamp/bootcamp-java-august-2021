package inheritancesum;

public class JavaInheritanceSecond {

	public static void main(String[] args) {
		Adder mySum = new Adder();

		System.out.println(mySum.add(103, 20));
		System.out.println(mySum.add(53, 0));
		System.out.println(mySum.add(1024, 199));
		System.out.println(mySum.add(-2, -5));
		System.out.println("this is my superclass: " + mySum.getClass().getSuperclass());
	}
}
