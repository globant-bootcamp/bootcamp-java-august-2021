package challenge;

public class Car extends Machine {
		
	@Override
	public void printSpeed(String speed){
		super.printSpeed("The car runs approximately with a velocity of: " + speed);
	}

	@Override
	public void printColor(final String COLOR){
		super.printSpeed("The color of the car is: " + COLOR);
	}
}