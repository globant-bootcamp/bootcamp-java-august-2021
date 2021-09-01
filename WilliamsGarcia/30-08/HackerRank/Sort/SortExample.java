package com.bootcamp.daythree.hackerrank.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        List<Student> studentList = new ArrayList<>();

        while (testCases > 0) {
            int id = scan.nextInt();
            String name = scan.next();
            double cumulativeGradePointAverage = scan.nextDouble();

            Student student = new Student(id, name, cumulativeGradePointAverage);
            studentList.add(student);

            testCases--;
        }

        Collections.sort(studentList);

        for (Student student : studentList) {
            System.out.println(student.getName());
        }
    }
}