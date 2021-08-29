package application;

import polymorphism.Building;
import polymorphism.impl.HealthBuilding;
import polymorphism.impl.OfficeBuilding;
import polymorphism.impl.StadiumBuilding;

public class Application {

	public static void main(String[] args) {
		Building[] buildings = new Building[5];
		
		buildings[0] = new OfficeBuilding("Continental", 80, 10, 100, 2);
		buildings[1] = new HealthBuilding("Rogers Centre", 100, 50, "R");
		buildings[2] = new OfficeBuilding("Reforma", 100, 10, 150, 3);
		buildings[3] = new HealthBuilding("Ricetrack Hermanos Rodriguez", 100, 50);
		buildings[3] = new HealthBuilding("Air Canadá Centre", 100, 50,"NR");
		buildings[4] = new StadiumBuilding("Commonwealth Stadium", 100, 50, "NR", "Soccer");
		
		for (Building building : buildings) {
			building.exhibition();
		}
	}
}
