package application.hackerrank.inheritanceone;

import application.hackerrank.Problem;

public class InheritanceProblemOne extends Problem {

  @Override
  public void solve() {
    Bird bird = new Bird();
	  bird.walk();
    bird.fly();
    bird.sing();
  }
  
}
