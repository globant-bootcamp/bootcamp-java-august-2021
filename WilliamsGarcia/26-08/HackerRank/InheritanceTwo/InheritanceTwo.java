package com.bootcamp.daytwo.hackerrank.inheritancetwo;

public class InheritanceTwo {

    public static void main(String[] args) {
        
        Adder adder = new Adder();
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());
        System.out.print(adder.add(10, 32) + " " + adder.add(10, 3) + " " + adder.add(10, 10) + "\n");
    }
}
