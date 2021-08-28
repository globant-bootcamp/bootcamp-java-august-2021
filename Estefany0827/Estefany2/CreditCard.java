package mainclass;

public class CreditCard extends Bank {

	public CreditCard(String name2) {
		super(name2);
		
	}

	@Override
	public String doAfterRequest() {
		
		
		return "Reviewing bureau status ";
	}

}
