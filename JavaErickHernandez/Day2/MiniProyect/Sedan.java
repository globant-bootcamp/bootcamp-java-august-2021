package bootcamp;
public class Sedan extends Vehicle implements Gas {

	public Sedan(String company, String model, String type, int year, double price, boolean convertible) {
		super(company, model, type, year, price);
		this.convertible = convertible;
	}

	public boolean convertible;

	public boolean isConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	@Override
	public String gasType(String gas) {
		String gasMessage = (". This vehicle use gas: " + gas);
		System.out.println("");
		return gasMessage;
	}

	@Override
	String dataVehicle() {
		String data = ("Company: " + getCompany() + ". Model: " + getModel() + ". Type: " + getType() + ". Year: " + getYear() + ". Price: "
				+ getPrice() + " dollars. Convertible: " + convertible);
		return data;
	}

}
