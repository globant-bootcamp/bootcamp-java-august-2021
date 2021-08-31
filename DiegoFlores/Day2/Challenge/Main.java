package person;

    	public static final String STUDENT1CAREER = "architecture";
	public static final String STUDENT1NAME = "John";
	public static final String STUDENT1SURNAME = "Connor";

	public static final String STUDENT2CAREER = "Biology";
	public static final String STUDENT2NAME = "Anakin";
	public static final String STUDENT2SURNAME = "Skywalker";

	public static final String TEACHER1COURSE  = "Structures";
	public static final String TEACHER1TIME = "Full time";
	public static final String TEACHER1NAME = "Obi-Wan";
	public static final String TEACHER1SURNAME = "Kenobi";


public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student(000001,"architecture",1);
			student1.setNames("John");
			student1.setSurnames("Connor");
			student1.setAge(12);
		
		Student student2 = new Student(000002,"Biology",5);
			student2.setNames("Anakin");
			student2.setSurnames("Skywalker");
			student2.setAge(30);
		
		Teacher teacher = new Teacher("Structures", "Full time");
			teacher.setNames("Obi-Wan");
			teacher.setSurnames("Kenobi");
			teacher.setAge(50);
		
		System.out.println(student1.getNames());
		System.out.println(student1.getCareer());
		
		System.out.println(student2.getNames());
		System.out.println(student2.getCareer());
		
		System.out.println(teacher.getNames());
		System.out.println(teacher.getAgreementTime());
		
	}

}
