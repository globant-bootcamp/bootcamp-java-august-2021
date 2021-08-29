package application.hackerrank.inheritanceone;

public class Animal {
  
  private static final String WALK_ACTIVITY = "I am walking";

  protected void walk(){
    System.out.println(Animal.WALK_ACTIVITY);
  }
  
}
