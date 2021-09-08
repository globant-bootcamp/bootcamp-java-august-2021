package javaSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = scanner.nextInt();
            String fname = scanner.next();
            double cgpa = scanner.nextDouble();

            Student student = new Student(id, fname, cgpa);
            studentList.add(student);

            testCases--;
        }
        scanner.close();

        Collections.sort(studentList, new SortInDescendingOrder());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
