package hackerrank.day3.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExcerciseSort {

    /**
     * Get the data of students to CompareList class
     */
    public static void getScanInfoStudents() {
        Scanner numberDataList = new Scanner(System.in);
        int testCases = Integer.parseInt(numberDataList.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = numberDataList.nextInt();
            String studentName = numberDataList.next();
            double cgpa = numberDataList.nextDouble();

            Student student = new Student(id, studentName, cgpa);
            studentList.add(student);

            testCases--;
        }

        studentList.sort(new StudentComparator());
        System.out.println("\nOutput: \n");
        for (Student student : studentList) {
            System.out.println(student.getNameStudent());
        }
    }
}