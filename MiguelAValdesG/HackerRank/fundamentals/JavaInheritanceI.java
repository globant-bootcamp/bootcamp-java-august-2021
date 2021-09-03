package fundamentals;

class Animal{
  void walk() {
    final String WALKING = "I am walking";
    System.out.println(WALKING);
  }
}

class Bird extends Animal {
  void fly() {
    final String FLYING = "I am flying";
    System.out.println(FLYING);
  }

  void sing() {
    final String SINGING = "I am singing";
    System.out.println(SINGING);
  }
}

public class JavaInheritanceI{

    public static void main(String[] args) {
      Bird bird = new Bird();
      bird.walk();
      bird.fly();
      bird.sing();
    }
}
