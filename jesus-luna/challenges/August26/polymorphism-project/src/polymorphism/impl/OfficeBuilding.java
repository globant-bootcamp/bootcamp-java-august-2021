package polymorphism.impl;

import polymorphism.Building;
import polymorphism.Place;

public class OfficeBuilding extends Place implements Building {
	
	private static final String TYPE_BUILDING = "office";
	private static final String EXHIBITION_MSG = "Building => name: %s, area: %.2fmts, \n   Specs => type: %s, offices: %d, storeys: %d";
	
	private int numberOffices;
	private int numberStoreys;
	
	public OfficeBuilding(String name,double width, double large,int numberOffices,int numberStoreys) {
		super(name, large, width);
		this.setNumberOffices(numberOffices);
		this.setNumberStoreys(numberStoreys);
	}

	@Override
	public String typeBuilding() {
		return OfficeBuilding.TYPE_BUILDING;
	}
	
	@Override
	public void exhibition() {
		System.out.println(
				String.format(
						OfficeBuilding.EXHIBITION_MSG, 
						this.getName(),
						this.getArea(),
						this.typeBuilding(),
						this.getNumberOffices(),
						this.getNumberStoreys()
				)
		);
	}

	public int getNumberOffices() {
		return numberOffices;
	}

	public void setNumberOffices(int numberOffices) {
		this.numberOffices = numberOffices;
	}

	public int getNumberStoreys() {
		return numberStoreys;
	}

	public void setNumberStoreys(int numberStoreys) {
		this.numberStoreys = numberStoreys;
	}

}
