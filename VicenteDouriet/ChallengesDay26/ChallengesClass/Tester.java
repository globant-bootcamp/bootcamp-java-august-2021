package com.king_arthur.company;

class Tester extends Employee {
    String work;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Working in: " + work);
    }

}
