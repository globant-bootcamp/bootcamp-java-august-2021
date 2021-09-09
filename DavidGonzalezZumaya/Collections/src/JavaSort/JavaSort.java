package JavaSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSort {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentsList = new ArrayList<Student>();

        while(testCases>0){
            int id = in.nextInt();
            String firstName = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, firstName, cgpa);
            studentsList.add(st);

            testCases--;
        }

        studentsList.sort(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFirstName).thenComparing(Student::getId));

        for(Student st: studentsList){
            System.out.println(st.getFirstName());
        }
    }
}
