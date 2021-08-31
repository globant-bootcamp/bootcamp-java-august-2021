package com.bootcamp.daytwo.miniproject;

public class Coach extends Person implements PublicFigure {

    private final String ANSWER = "The guys played as planned in the week...bla..bla..";

    public Coach(String name, String lastName, int age) {
        super(name, lastName, age);
    }

    public void leadGame() {
        System.out.println("The coach " + super.getName() + " " + super.getLastName() + "is lead the game");
    }

    public void leadTraining() {
        System.out.println("The coach " + super.getName() + " " + super.getLastName() + "is lead the training");
    }

    @Override
    public void travelToGame(String city) {
        System.out.println("The coach " + super.getName() + " " + super.getLastName() + " is traveling to " + city + " for the game");
    }

    @Override
    public void meetToGame(String city) {
        System.out.println("The coach " + super.getName() + " " + super.getLastName() + " is in " + city + "for the meeting");
    }

    @Override
    public void interview() {
        System.out.println(super.getName() + " " + super.getLastName() + ": " + ANSWER);
    }

}
