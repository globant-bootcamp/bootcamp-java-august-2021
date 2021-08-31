package polymorphism.impl;

import polymorphism.Place;
import polymorphism.SportBuilding;

public class HealthBuilding extends Place  implements SportBuilding{
	
	private static final String TYPE_BUILDING = "sports";
	private static final String EXHIBITION_MSG = "Building => name: %s, area: %.2fmts, \n   Specs => type: %s, is roofed?: %s";
	
	private String roofedType;
	
	public HealthBuilding(String name, double large, double width) {
		super(name, large, width);
		this.setRoofedType(this.roofedTypeBuilding(HealthBuilding.TYPE_BUILDING));
	}

	public HealthBuilding(String name, double large, double width,String codeRoof) {
		super(name, large, width);
		this.setRoofedType(this.roofedTypeBuilding(codeRoof));
	}


	@Override
	public String typeBuilding() {
		return HealthBuilding.TYPE_BUILDING;
	}
	
	@Override
	public void exhibition() {
		System.out.println(
				String.format(
						HealthBuilding.EXHIBITION_MSG, 
						this.getName(),
						this.getArea(),
						this.typeBuilding(),
						this.getRoofedType()
				)
		);
	}

	public String getRoofedType() {
		return roofedType;
	}


	public void setRoofedType(String roofedType) {
		this.roofedType = roofedType;
	}

}
