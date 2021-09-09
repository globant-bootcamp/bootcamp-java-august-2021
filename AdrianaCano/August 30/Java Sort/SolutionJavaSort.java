package com.mycompany.javacollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SolutionJavaSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentsList = new ArrayList<>();
        int numInputs = Integer.parseInt(bufferedReader.readLine());
        for (int point = 0; point < numInputs; point++) {
            String[] values = bufferedReader.readLine().split(" ");
            int id = Integer.parseInt(values[0]);
            String fname = values[1];
            double cgpa = Double.parseDouble(values[2]);
            Student student = new Student(id, fname, cgpa);
            studentsList.add(student);
        }

        //Lambda expression
        studentsList.sort((Student student1, Student student2) -> {
            if (student1.getCgpa() == student2.getCgpa()) {
                return student1.getFname().compareTo(student2.getFname());

            } else if (student1.getCgpa() < student2.getCgpa()) {
                return 1;
            } else {
                return -1;
            }
        });

        for (Student st : studentsList) {
            System.out.println(st.getFname());
        }
    }
}
