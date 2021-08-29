package myPackage;

public class Car extends Machine {
		
	@Override
	public void printSpeed(String speed){
		super.printSpeed("El carro corre a una velocidad aproximada de: " + speed);
	}

	@Override
	public void printColor(String color){
		super.printSpeed("El carro es de color: " + color);
	}
}