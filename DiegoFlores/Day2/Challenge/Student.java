package person;

public class Student extends Person {

	private int studentId;
	private String	career;
	private int semester;
	
	
	public Student() {
		
	}
	
	public Student(int studentId, String career, int semester) {
		super();
		this.studentId = studentId;
		this.career = career;
		this.semester = semester;
	}
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
