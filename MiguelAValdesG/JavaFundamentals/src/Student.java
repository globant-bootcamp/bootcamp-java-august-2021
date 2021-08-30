// ===========================
// Class son of AcademicPeople
// ===========================
public class Student extends AcademicPeople {

  // ==========================
  // Class' specific attributes
  // ==========================
  protected int grade;
  protected char group;

  // ===================================
  // Next three methods use Polymorphism
  // ===================================
  @Override
  public void takeAClass(AcademicPeople student) {
    String activity = student.firstName.concat(" Took notes and paid attention");
    System.out.println(activity);
  }

  public void didAQuestion(String question) {
    System.out.println(question);
  }

  public void didAQuestion(String question, String topic) {
    String topicAndQuestion = String.format("Topic: %s | Question: %s", topic, question);
    System.out.println(topicAndQuestion);
  }

  // ====================================================
  // Next three methods could be an Encapsulation example
  // ====================================================
  public boolean passedTest() {
    boolean result = false;

    if (didHomework() && preparedHimself())
      result = true;

    return result;
  }

  private boolean didHomework() {
    return true;
  }

  private boolean preparedHimself() {
    return true;
  }

}
