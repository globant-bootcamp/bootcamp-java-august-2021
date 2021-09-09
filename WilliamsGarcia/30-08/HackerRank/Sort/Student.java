package com.bootcamp.daythree.hackerrank.sort;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double cumulativeGradePointAverage;

    public Student(int id, String name, double cumulativeGradePointAverage) {
        super();
        this.id = id;
        this.name = name;
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double cumulativeGradePointAverage() {
        return cumulativeGradePointAverage;
    }

    @Override
    public int compareTo(Student student) {
        if (this.cumulativeGradePointAverage() == student.cumulativeGradePointAverage()) {
            return this.getName().compareTo(student.getName());
        } else if (this.cumulativeGradePointAverage() < student.cumulativeGradePointAverage()) {
            return 1;
        } else {
            return -1;
        }
    }
}