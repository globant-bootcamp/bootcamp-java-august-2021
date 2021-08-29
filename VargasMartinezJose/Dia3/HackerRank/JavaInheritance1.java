class Animal{
	void walk(){
		System.out.println("I am walking");
	}
}

class Bird extends Animal{
	void fly(){
		System.out.println("I am flying");
	}
    void walk(){
        System.out.println("I am walking");
    }
    void sing(){
        System.out.println("I am singing");
    }
}

public class JavaInheritance1{

    public static void main(String args[]){
 
       Bird bird = new Bird();
       bird.walk();
       bird.fly();
       bird.sing();
     
    }
 }