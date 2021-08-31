import java.util.UUID;

// ============
// Father Class
// ============
public class AcademicPeople {

  protected enum SHIFT {
    AFTERNOON, MORNING
  }

  protected UUID id;
  protected String firstName;
  protected String lastName;
  protected String email;
  protected int age;
  protected SHIFT shift;

  public void takeAClass(AcademicPeople academicPeople) {
    String activity = "Was present in class";
    System.out.println(activity);
  }

  public void attendance() {
    String attendanceOk = "Showed up to classes";
    System.out.println(attendanceOk);
  }

}
