package com.mycompany.polymorphism;

public class Saxophone extends Instrument{
    private final String SECTION = "Woodwind";
    
    @Override
    public void defineSection(){
        System.out.println("My section is: " + SECTION);
    }
    
    @Override
    public void makeSound(){
        System.out.println("To make sound I need a Reed");
    }
    
    @Override
    public void commonCharacteristic(){
        System.out.println("I make sound in an Orchestra but most commonly in jazz band");
    }
}
