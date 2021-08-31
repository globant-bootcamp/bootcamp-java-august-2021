package company;

import employee.Employee;
import employee.Manager;
import employee.Programmer;
import employee.Tester;

public class Company {
    public static void main(String[] args){

        Programmer frontEndProgrammer = new Programmer();
        Programmer backEndProgrammer = new Programmer();
        Employee manager = new Manager();
        Tester qa = new Tester();

        frontEndProgrammer.setAssignment("IBM");
        frontEndProgrammer.doTheJob();
        frontEndProgrammer.displayAssignment();
        frontEndProgrammer.setSeniority("SSR");
        frontEndProgrammer.displaySeniority();

        backEndProgrammer.setAssignment("Banamex");
        backEndProgrammer.doTheJob();
        backEndProgrammer.displayAssignment();
        backEndProgrammer.setSeniority("JR");
        backEndProgrammer.displaySeniority();

        manager.setAssignment("IBM");
        manager.doTheJob();
        manager.displayAssignment();

        qa.setAssignment("Banamex");
        qa.doTheJob();
        qa.displayAssignment();
        qa.setFramework("Selenium");
        qa.displayFramework();
    }
}
