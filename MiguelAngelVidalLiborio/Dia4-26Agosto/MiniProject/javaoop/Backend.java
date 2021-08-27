package javaoop;

import java.util.List;
public class Backend extends Course {

	public void welcome() {
		System.out.println("Welcome to Java Course");
	}

	@Override
	public void setMeeting(String myMeeting) {
		super.setMeeting("Backend: " + myMeeting);
	}
	
	@Override
	public void addStudent(Student student) {
		super.addStudent(student);
	}
	
	@Override
	public List<Student> getStudents(){
		return super.getStudents();
	}

}
