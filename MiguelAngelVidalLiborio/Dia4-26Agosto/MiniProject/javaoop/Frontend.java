package javaoop;

import java.util.List;

public class Frontend extends Course {

	@Override
	public void getStudent() {
		super.getStudent();
	}

	@Override
	public void getStudent(int index) {
		super.getStudent(index);
	}

	@Override
	public void setMeeting(String myMeeting) {
		super.setMeeting("\nLet's go! Frontend: " + myMeeting);
	}

	@Override
	public void addStudent(Student student) {
		super.addStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		return super.getStudents();
	}

}
