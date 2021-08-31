// ===========================
// Class son of AcademicPeople
// ===========================
public class Teacher extends AcademicPeople {

  protected String[] subjects;

  @Override
  public void takeAClass(AcademicPeople teacher) {
    String activity = teacher.firstName.concat(" gave the class");
    System.out.println(activity);
  }

  public void appliedATest(Teacher teacher, Student student) {
    String activity = String.format("Teacher %s applied a test to %s", teacher.firstName, student.lastName);
    System.out.println(activity);
  }

}
