package challenge;

public class Main {
	public static void main(String[] args){
		Machine machine = new Car(); 
		machine.setColor("Red");
		machine.setSpeed("180 mph");

		machine.printColor(machine.getColor());
		machine.printSpeed(machine.getSpeed());
	}
}