package com.bootcamp.daythree.hackerrank.sort;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student studentOne, Student studentTwo) {

        if (studentOne.getCgpa() == studentTwo.getCgpa()) {
            return studentOne.getFname().compareTo(studentTwo.getFname());
        } else if (studentOne.getCgpa() < studentTwo.getCgpa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
