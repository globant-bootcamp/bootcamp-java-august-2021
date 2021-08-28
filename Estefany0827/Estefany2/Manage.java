package mainclass;

public class Manage {

	public static void main(String[] args) {

		Loan loanReq = new Loan("Auto");
		CreditCard creditReq= new CreditCard("MasterCard");


		System.out.println("Loan request :"+ loanReq.getRequest());
		if(loanReq.getRequest() == "Auto") {

			loanReq.getCreditLimit();
		}
		
		
		System.out.println(loanReq.doAfterRequest());
		
		
		System.out.println(creditReq.doAfterRequest());
	}

}