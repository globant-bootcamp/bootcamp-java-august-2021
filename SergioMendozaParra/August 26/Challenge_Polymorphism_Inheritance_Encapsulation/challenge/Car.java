package challenge;

public class Car extends Machine {
		
	@Override
	public void printSpeed(final String SPEED){
		super.printSpeed("The car runs approximately with a velocity of: " + SPEED);
	}

	@Override
	public void printColor(final String COLOR){
		super.printSpeed("The color of the car is: " + COLOR);
	}
}