
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
            String firstName = in.next();
            double qualification = in.nextDouble();
            Student st = new Student(id, firstName, qualification);
            studentList.add(st);
            numberStudent--;
        }
        Collections.sort(studentList, Comparator.comparing(Student::getQualification).reversed().thenComparing(Student::getFirstName).thenComparing(Student::getId));
        for (Student student : studentList) {
            System.out.println(student.getFirstName());
        }
    }
}
