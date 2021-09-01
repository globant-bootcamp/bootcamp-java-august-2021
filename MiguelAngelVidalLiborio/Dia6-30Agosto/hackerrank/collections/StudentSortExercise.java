package collections;

public class StudentSortExercise {
	private int id;
	private String firstName;
	private double cgpa;

	public StudentSortExercise(int id, String firstName, double cgpa) {
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
