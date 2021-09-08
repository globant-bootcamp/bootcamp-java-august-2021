package bootcamp.collections.com;

import java.util.*;

class StudentSort {
    private int id;
    private String firstName;
    private double averageGrades;
    public void Student(int id, String firstName, double averageGrades) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.averageGrades = averageGrades;
    }
   
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public double getAverageGrades() {
        return averageGrades;
    }
}