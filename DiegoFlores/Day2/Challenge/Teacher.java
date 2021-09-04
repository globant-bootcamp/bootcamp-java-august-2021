package person;

public class Teacher extends User {

	private String course;
	private String agreementTime;
	
	public Teacher () {
		
	}
		
	public Teacher(String course, String agreementTime) {
		super();
		this.course = course;
		this.agreementTime = agreementTime;
	}

	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAgreementTime() {
		return agreementTime;
	}
	public void setAgreementTime(String agreementTime) {
		this.agreementTime = agreementTime;
	}

}
