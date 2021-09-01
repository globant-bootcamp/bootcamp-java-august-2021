package com.mycompany.polymorphism;

public class Trombone extends Instrument{
    private final String SECTION = "Brass";
    
    @Override
    public void defineSection(){
        System.out.println("My section is: " + SECTION);
    }
    
    @Override
    public void makeSound(){
        System.out.println("To make sound I need to move my slide");
    }
}
