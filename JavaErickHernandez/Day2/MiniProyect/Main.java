package bootcamp;
public class Main {
	public static void main(String[] Args) {
		Vehicle v1 = new Sedan("Nissan", "Sentra", "Standard", 2019, 210, true);
		Vehicle v2 = new Truck("Ford", "Windstar", "Automatic", 2000, 60, "2 Wheels", 8);
		defineVehicle(v1);
		defineVehicle(v2);
	}	
	public static void defineVehicle(Vehicle vehicle) {
		if(vehicle instanceof Sedan) {
			String messageSedan = vehicle.dataVehicle();
			System.out.print(messageSedan);
			String gasSedan = ((Sedan) vehicle).gasType("diesel");
			System.out.print(gasSedan);
			System.out.println("");
		}else if(vehicle instanceof Truck) {
			String messageTruck = vehicle.dataVehicle();
			System.out.print(messageTruck);
			String gasTruck = ((Truck) vehicle).gasType("premium");
			System.out.print(gasTruck);
			System.out.println("");
		}else {
			System.out.println("Sorry we don´t count with that vehicle");
		}
	}
}
