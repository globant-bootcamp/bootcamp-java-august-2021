package javasort;

class Student implements Comparable<Object> {
	private int id;
	private String name;
	private double average;

	public Student(int id, String name, double average) {
		this.id = id;
		this.name = name;
		this.average = average;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAverage() {
		return average;
	}

	@Override
	public int compareTo(Object object) {
		Student student = (Student) object;
		if (Double.compare(this.average, student.average) == 0) {
			if (this.name.compareTo(student.name) == 0) {
				return this.id - student.id;
			} else {
				return this.name.compareTo(student.name);
			}
		} else {
			return Double.compare(this.average, student.average);
		}
	}
}