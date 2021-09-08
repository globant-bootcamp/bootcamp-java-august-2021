package hackerrank.day3.sort;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */

public class Student {
    private int id;
    private String nameStudent;
    private double cgpa;

    public Student(int id, String nameStudent, double cgpa) {
        super();
        this.id = id;
        this.nameStudent = nameStudent;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public double getCgpa() {
        return cgpa;
    }
}
