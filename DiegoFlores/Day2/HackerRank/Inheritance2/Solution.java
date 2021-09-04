package arithmetic;

class Arithmetic{
    
    public int add(Integer firstInteger, Integer secondInteger){
        return firstInteger + secondInteger;
    }
    
}

class Adder extends Arithmetic{
    
}

public class Solution{
    
    public static void main(String []args){

        Adder operation = new Adder();
        
        System.out.println("My superclass is: " + operation.getClass().getSuperclass().getName());        
        System.out.print(operation.add(10,32) + " " + operation.add(10,3) + " " + operation.add(10,10) + "\n");
        
     }
}
