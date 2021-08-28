package mainclass;

public class Loan extends Bank {

	public Loan(String name2) {
		super(name2);
		
	}
	
	public void getCreditLimit() {
		
		System.out.println(" retrieving credit History");
	}
	
	@Override
	public String doAfterRequest() {
		
		
		return "Loan request sent";
	}

	
	
}
