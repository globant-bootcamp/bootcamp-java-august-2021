import java.util.*;

class Student {

  private int id;
  private String firstName;
  private double cgpa;

  public Student(int id, String firstName, double cgpa) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public double getCgpa() {
    return cgpa;
  }
}

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
