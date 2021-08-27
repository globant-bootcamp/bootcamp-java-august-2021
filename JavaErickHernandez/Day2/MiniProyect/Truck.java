package bootcamp;
public class Truck extends Vehicle implements Gas{
	
	public double passengersCapacity;

	public double getPassengers() {
		return passengersCapacity;
	}

	public void setCapacidadPasajeros(double capacidadPasajeros) {
		this.passengersCapacity = capacidadPasajeros;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}

	public String traccion;

	public Truck(String marca, String modelo, String tipo, int año, double precio) {
		super(marca, modelo, tipo, año, precio);
		traccion = "standard";
		passengersCapacity = 0;
	}



	@Override
	public String gasType(String gas) {
		System.out.print("This vehicle use gas: " +gas);
		return null;
	}

	@Override
	String dataVehicle() {
		System.out.print("Company: " + getCompany() + ". Model: " + getModel() + ". Type: " + getType() + ". Year: " + getYear() + ". Price: "
				+ getPrice() + " dollars. Traction: " + traccion + ".  Passengers Capacity: " + passengersCapacity);
		return null;
	}


	

	
	
	
}
