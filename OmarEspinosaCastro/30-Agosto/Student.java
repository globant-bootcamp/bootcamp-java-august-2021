
package collection;

public class Student {

    private int id;
    private String firstName;
    private double qualification;

    public Student(int id, String firstName, double qualification) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.qualification = qualification;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getQualification() {
        return qualification;
    }

    public int getId() {
        return id;
    }

}