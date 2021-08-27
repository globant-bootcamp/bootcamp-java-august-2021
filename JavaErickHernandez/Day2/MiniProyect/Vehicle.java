package bootcamp;
public abstract class Vehicle {
	public String company, model, type;
	public int year;
	public double price;

	public Vehicle(String company, String model, String type, int year, double price) {
		this.company = company;
		this.model = model;
		this.type = type;
		this.year = year;
		this.price = price;
	}

	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	abstract String dataVehicle();
	
	public static void main(String[] Args) {
		Sedan sedan = new Sedan("Nissan", "Sentra", "Standard", 2019, 210);
		sedan.descapotable = false;
		sedan.dataVehicle();
		sedan.gasType("diesel");
		System.out.println("");
		Truck truck = new Truck("Ford", "Windstar", "Automatic", 2000, 60);
		truck.passengersCapacity = 8;
		truck.traccion = "2 Wheels";
		truck.dataVehicle();
		sedan.gasType("premium");
	}
}
