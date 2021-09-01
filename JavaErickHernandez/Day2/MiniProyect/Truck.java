package bootcamp;
public class Truck extends Vehicle implements Gas{
	
	public int passengersCapacity;

	public int getPassengers() {
		return passengersCapacity;
	}

	public void setPassengersCapacity(int passengersCapacity) {
		this.passengersCapacity = passengersCapacity;
	}

	public String getTraction() {
		return traction;
	}

	public void setTraction(String traccion) {
		this.traction = traccion;
	}

	public String traction;

	public Truck(String company, String model, String type, int year, double price, String traction, int passengersCapacity ) {
		super(company, model, type, year, price);
		this.traction = traction;
		this.passengersCapacity = passengersCapacity;
	}



	@Override
	public String gasType(String gas) {
		String gasMessage = (". This vehicle use gas: " +gas);
		System.out.println("");
		return gasMessage;
	}

	@Override
	String dataVehicle() {
		String data = ("Company: " + getCompany() + ". Model: " + getModel() + ". Type: " + getType() + ". Year: " + getYear() + ". Price: "
				+ getPrice() + " dollars. Traction: " + traction + ".  Passengers Capacity: " + passengersCapacity);
		return data;
	}


	

	
	
	
}
