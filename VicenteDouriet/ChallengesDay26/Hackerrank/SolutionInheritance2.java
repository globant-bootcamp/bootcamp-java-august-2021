class Arithmetic
{
  private int a;
  private int b;
  
  void add(int a,int b) {
    System.out.print(a+b+" ");
    
  }
}
class Adder extends Arithmetic {
    Adder(){ 
      System.out.println("My superclass is: Arithmetic");
   }
   
}
public class Solution {

    public static void main(String[] args) {
      
        Adder ref=new Adder();
        ref.add(10,32);
        ref.add(10,3);
        ref.add(10,10);
        
    }
}