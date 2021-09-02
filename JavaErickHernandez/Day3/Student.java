package bootcamp;

public class Student {
	Integer id;
	String name;
	double points;

	public Student(Integer id, String name, double points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoints() {
		return points;
	}

	public void setCgpa(double points) {
		this.points = points;
	}

}
