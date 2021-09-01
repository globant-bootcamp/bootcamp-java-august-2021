package polymorphism.impl;

import polymorphism.Place;
import polymorphism.SportBuilding;

public class StadiumBuilding extends Place implements SportBuilding {
	
	private String hostingSport;
	private String roofedType;
	
	private static final String TYPE_BUILDING = "stadium";
	private static final String EXHIBITION_MSG = "Building => name: %s, area: %.2fmts, \n   Specs => type: %s, is roofed?: %s, sport hosting: %s";

	public StadiumBuilding(String name, double large, double width,String hostingSport) {
		super(name, large, width);
		this.setHostingSport(hostingSport);
		this.setRoofedType(this.roofedTypeBuilding(StadiumBuilding.TYPE_BUILDING));
	}
	
	public StadiumBuilding(String name, double large, double width,String codeRoof,String hostingSport) {
		super(name, large, width);
		this.setHostingSport(hostingSport);
		this.setRoofedType(this.roofedTypeBuilding(codeRoof));
	}

	@Override
	public String typeBuilding() {
		return StadiumBuilding.TYPE_BUILDING;
	}
	
	@Override
	public void exhibition() {
		System.out.println(
				String.format(
						StadiumBuilding.EXHIBITION_MSG, 
						this.getName(),
						this.getArea(),
						this.typeBuilding(),
						this.getRoofedType(),
						this.getHostingSport()
				)
		);
	}

	public String getHostingSport() {
		return hostingSport;
	}

	public void setHostingSport(String hostingSport) {
		this.hostingSport = hostingSport;
	}

	public String getRoofedType() {
		return roofedType;
	}

	public void setRoofedType(String roofedType) {
		this.roofedType = roofedType;
	}

}
