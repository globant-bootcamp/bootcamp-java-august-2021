package collections.sort;

import java.util.*;

public class JavaSort {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    int testCases = readLineTerminal.nextInt();

    List<Student> studentList = new ArrayList<>();

    while(testCases > 0) {
      int id = readLineTerminal.nextInt();
      readLineTerminal.nextLine();
      String firstName = readLineTerminal.nextLine();
      double cgpa = readLineTerminal.nextDouble();
      Student student = new Student(id, firstName, cgpa);
      studentList.add(student);
      testCases--;
    }

    studentList.sort(Comparator.comparing(
      Student::getCgpa).reversed().
      thenComparing(Student::getFirstName).
      thenComparing(Student::getId)
    );

    for (Student student : studentList) {
      System.out.println(student.getFirstName());
    }
  }
}

// Challenge: https://www.hackerrank.com/challenges/java-sort/problem
