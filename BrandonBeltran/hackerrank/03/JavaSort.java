package bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<Student>();

        while(testCases>0){

            int id = scanner.nextInt();
            String fname = scanner.next();
            double cgpa = scanner.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList);

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}



