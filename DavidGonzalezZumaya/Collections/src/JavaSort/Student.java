package JavaSort;

public class Student {

    private int id;
    private String firstName;
    private double score;

    public Student(int id, String firstName, double score) {
        this.id = id;
        this.firstName = firstName;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getScore() {
        return score;
    }
}
