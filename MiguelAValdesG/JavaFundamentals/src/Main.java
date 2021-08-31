public class Main {

  public static void main(String[] args) {
    Teacher teacher = new Teacher();
    Student student = new Student();
    String congrats = "Congratulations you pass your test. You are in the next level";

    teacher.takeAClass(teacher);
    student.takeAClass(student);

    String firstQuestion = "How can I improve my skills?";
    student.didAQuestion(firstQuestion);

    String secondQuestion = "What I should study to learn Java?";
    String topicQuestion =  "OPP Paradigm";
    student.didAQuestion(topicQuestion, secondQuestion);

    teacher.appliedATest(teacher, student);

    if (student.passedTest());
      System.out.println(congrats);
  }

}
