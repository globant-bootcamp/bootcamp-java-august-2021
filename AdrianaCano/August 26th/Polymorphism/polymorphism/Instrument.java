package com.mycompany.polymorphism;

public class Instrument {
    
    private final String FIRST_MSG = "Hi, I am a...";
    
    public void makeSound()
    {
        System.out.println("To make sound I need: ");
    }
    
    public void commonCharacteristic(){
        System.out.println("I make sound in an Orchestra");
    }
    
    public void defineSection(){
        System.out.println("My section is: ");
    }
    
    public void welcome(String name){
        System.out.println(FIRST_MSG + name);
    }
       
}
