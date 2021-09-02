package com.mycompany.polymorphism;

public class Main {
    public static void main(String[] args) {
        
        Instrument saxophone = new Saxophone();
        Instrument trombone = new Trombone();
        Instrument violin = new Violin();
        
        saxophone.welcome("Saxophone");
        saxophone.defineSection();
        saxophone.makeSound();
        saxophone.commonCharacteristic();
        
        trombone.welcome("Trombone");
        trombone.defineSection();
        trombone.makeSound();
        trombone.commonCharacteristic();
        
        violin.welcome("Violin");
        violin.defineSection();
        violin.makeSound();
        violin.commonCharacteristic();

    }
}
