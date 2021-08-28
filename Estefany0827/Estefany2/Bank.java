package mainclass;

public abstract class Bank {

	private String request;

	public Bank(String request) {
		this.request= request;
	}

	public String getRequest() {
		return request;
	}

	/*public void setRequest(String request) {
		this.request = request;
	}*/
	
	  public abstract String  doAfterRequest() ;
	
}
