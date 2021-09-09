package animal;

public static final String FLYING_MESSAGE = "I am flying";
public static final String SINGING_MESSAGE = "I am singing";

public class Bird extends Animal{

    void fly(){
	System.out.println(FLYING_MESSAGE);
    }
    
    void sing(){
        System.out.println(SINGING_MESSAGE);
    }
    
}
