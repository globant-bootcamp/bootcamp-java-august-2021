package javaoop;

public class Main {

	public static void main(String[] args) {
		Backend backend = new Backend();
		backend.setMeeting("Teams");
		backend.addStudent(new Student("Miguel Angel Vidal Liborio", 24));
		backend.addStudent(new Student("Antonio Perez Landa", 21));
		backend.addStudent(new Student("Maria Mercedes", 25));
		backend.getStudents().forEach(student -> System.out.printf("* %s - %d\n", student.studentName, student.age));
		backend.getStudent();
		backend.getStudent(1);

		Frontend frontend = new Frontend();
		frontend.setMeeting("Zoom");
		frontend.addStudent(new Student("Juan Romero", 17));
		frontend.addStudent(new Student("Estefany Lizeth Flores", 19));
		frontend.getStudents().forEach(student -> System.out.printf("* %s - %d\n", student.studentName, student.age));
		frontend.getStudent();
	}

}
