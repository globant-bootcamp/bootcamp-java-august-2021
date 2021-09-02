package com.mycompany.polymorphism;

public class Violin extends Instrument{
    private final String SECTION = "String";
    
    @Override
    public void defineSection(){
        System.out.println("My section is: " + SECTION);
    }
    
    @Override
    public void makeSound(){
        System.out.println("To make sound I need a Bow");
    }
    
}
