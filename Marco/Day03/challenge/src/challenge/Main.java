package challenge;

import challenge.classes.Car;
import challenge.classes.Bicycle;

public class Main {

    public static void main(String[] args) {

        Car redCar = new Car();
        Bicycle blueBicycle = new Bicycle();

        System.out.println("Each vehicle goes...");

        redCar.identifies();
        redCar.sound();
        redCar.transport();

        blueBicycle.identifies();
        blueBicycle.sound();
        blueBicycle.transport();

    }
}
