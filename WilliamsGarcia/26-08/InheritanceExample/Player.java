package com.bootcamp.daytwo.miniproject;

public class Player extends Person implements PublicFigure {

    private int dorsalNumber;
    private String position;
    private final String ANSWER = "Well, it was played with the coach's instructions...bla..bla..";

    public Player(String name, String lastName, int age, int dorsalNumber, String position) {
        super(name, lastName, age);
        this.dorsalNumber = dorsalNumber;
        this.position = position;
    }

    public int getDorsalNumber() {
        return dorsalNumber;
    }

    public void setDorsalNumber(int dorsalNumber) {
        this.dorsalNumber = dorsalNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void training() {
        System.out.println("The player " + super.getName() + " " + super.getLastName() + " is in training");
    }

    public void playGame() {
        System.out.println("The player " + super.getName() + " " + super.getLastName() + " is in game with number: " + this.getDorsalNumber() + " at position: " + this.getPosition());
    }

    @Override
    public void travelToGame(String city) {
        System.out.println("The player " + super.getName() + " " + super.getLastName() + " is traveling to " + city + " for the game");
    }

    @Override
    public void meetToGame(String city) {
        System.out.println("The player " + super.getName() + " " + super.getLastName() + " is in " + city + " for the meeting");
    }

    @Override
    public void interview() {
        System.out.println(super.getName() + " " + super.getLastName() + ": " + ANSWER);
    }
}
