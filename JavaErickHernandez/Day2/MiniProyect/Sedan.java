package bootcamp;
public class Sedan extends Vehicle implements Gas {

	public Sedan(String company, String model, String type, int year, double price) {
		super(company, model, type, year, price);
		descapotable = true;
	}

	public boolean descapotable;

	public boolean isDescapotable() {
		return descapotable;
	}

	public void setDescapotable(boolean descapotable) {
		this.descapotable = descapotable;
	}

	@Override
	public String gasType(String gas) {
		System.out.print(". This vehicle use gas: " + gas);
		System.out.println("");
		return null;
	}

	@Override
	String dataVehicle() {
		System.out.print("Company: " + getCompany() + ". Model: " + getModel() + ". Type: " + getType() + ". Year: " + getYear() + ". Price: "
				+ getPrice() + " dollars. Descapotable: " + descapotable);
		return null;
	}

}
