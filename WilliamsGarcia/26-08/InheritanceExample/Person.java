package com.bootcamp.daytwo.miniproject;

public class Person {

    protected String name;
    protected String lastName;
    protected int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void travelToGame(String city) {
        System.out.println("Traveling...");
    }

    public void meetToGame(String city) {
        System.out.println("Meeting...");
    }
}
