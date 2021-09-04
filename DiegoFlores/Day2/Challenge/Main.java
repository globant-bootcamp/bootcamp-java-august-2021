package person;

    	public static final String STUDENT_ONE_CAREER = "architecture";
	public static final String STUDENT_ONE_NAME = "John";
	public static final String STUDENT_ONE_LASTNAME = "Connor";

	public static final String STUDENT_TWO_AREER = "Biology";
	public static final String STUDENT_TWO_NAME = "Anakin";
	public static final String STUDENT_TWO_LASTNAME = "Skywalker";

	public static final String TEACHER_ONE_COURSE  = "Structures";
	public static final String TEACHER_ONE_TIME = "Full time";
	public static final String TEACHER_ONE_NAME = "Obi-Wan";
	public static final String TEACHER_ONE_SURNAME = "Kenobi";


public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student(000001,STUDENT_ONE_CAREER,1);
			student1.setUserNames(STUDENT_ONE_NAME);
			student1.setUserLastName(STUDENT_ONE_LASTNAME);
			student1.setUserAge(12);
		
		Student student2 = new Student(000002,STUDENT_TWO_AREER,5);
			student2.setUserNames(STUDENT_TWO_NAME);
			student2.setUserLastName(STUDENT_TWO_LASTNAME);
			student2.setUserAge(30);
		
		Teacher teacher = new Teacher(TEACHER_ONE_COURSE, TEACHER_ONE_TIME);
			teacher.setUserNames(TEACHER_ONE_NAME);
			teacher.setUserLastName(TEACHER_ONE_SURNAME);
			teacher.setUserAge(50);
		
		System.out.println(student1.getUserNames());
		System.out.println(student1.getCareer());
		
		System.out.println(student2.getUserNames());
		System.out.println(student2.getCareer());
		
		System.out.println(teacher.getUserNames());
		System.out.println(teacher.getAgreementTime());
		
	}

}
