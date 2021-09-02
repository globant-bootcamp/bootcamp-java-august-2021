
package collection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberStudent  = Integer.parseInt(in.nextLine());
        List<Student> studentList = new ArrayList<Student>();
        while (numberStudent > 0) {
            int id = in.nextInt();
            String name = in.next();
            double cgpa = in.nextDouble();
            Student st = new Student(id, name, cgpa);
            studentList.add(st);
            numberStudent--;
        }
        Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparing(Student::getId));
        for (Student student : studentList) {
            System.out.println(student.getFname());
        }
    }
}
