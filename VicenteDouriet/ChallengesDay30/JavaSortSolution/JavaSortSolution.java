package com.king_arthur.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSortSolution {
    public static void main(String[] args) {
        //Code provided by hackerrank
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        //My solution
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() == s2.getCgpa()) {
                    return s1.getFname().compareTo(s2.getFname());
                } else if (s1.getCgpa() < s2.getCgpa()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
