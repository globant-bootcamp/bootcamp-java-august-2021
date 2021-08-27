package bootcamp;
public class Main {
	public static void main(String[] Args) {
		Sedan sedan = new Sedan("Nissan", "Sentra", "Standard", 2019, 210, true);
		String messageSedan = sedan.dataVehicle();
		String gasSedan = sedan.gasType("diesel");
		System.out.print(messageSedan);
		System.out.print(gasSedan);
		
		
		Truck truck = new Truck("Ford", "Windstar", "Automatic", 2000, 60, "2 Wheels", 8);
		String messageTruck = truck.dataVehicle();
		String gasTruck = truck.gasType("premium");
		System.out.print(messageTruck);
		System.out.print(gasTruck);
	}
}
