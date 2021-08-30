package application.hackerrank.inheritanceone;

public class Bird extends Animal {

  private static final String FLY_ACTIVITY = "I am flying";
  private static final String SING_ACTIVITY = "I am singing";

  protected void fly(){
    System.out.println(Bird.FLY_ACTIVITY);
  }

  protected void sing(){
    System.out.println(Bird.SING_ACTIVITY);
  }

}
