import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


class Solution{
    
    public static final String ERROMESSAGE = "Not found";
    
	public static void main(String []args){
		
        	Map<String, Integer> phoneBook = new HashMap<String, Integer>();  
            
		Scanner in = new Scanner(System.in);
		int numberEntries = in.nextInt();    
        	in.nextLine();
        
		for(int i=0;i<numberEntries;i++){
			
			String name=in.nextLine();
			int phoneNumber = in.nextInt();            
            		phoneBook.put(name, phoneNumber);            
			in.nextLine();
			
		}
        
		while(in.hasNext()){
			
			String name = in.nextLine();
            		Integer phoneNumber = phoneBook.get(name);
            
            		if( phoneNumber == null){
                		System.out.println(ERROMESSAGE);
            		}else{
                		System.out.println( name + "=" + phoneNumber);
           		}
			
		}
        
	}
	
}
