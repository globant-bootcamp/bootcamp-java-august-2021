package JavaSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();

        while (testCases > 0) {
            int id = in.nextInt();
            String firstName = in.next();
            double score = in.nextDouble();

            Student student = new Student(id, firstName, score);
            studentList.add(student);

            testCases--;
        }

        studentList.sort(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getFirstName)
                .thenComparing(Student::getId));

        for (Student student : studentList) {
            System.out.println(st.getFirstName());
        }
    }
}
