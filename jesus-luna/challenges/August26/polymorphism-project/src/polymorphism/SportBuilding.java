package polymorphism;

import java.util.Optional;

public interface SportBuilding {
	public static final String ROOFED_BUILDING = "roofed";
	public static final String NO_ROOFED_BUILDING = "no roofed";
	public static final String NO_SPECIFIED = "no specified";
	
	public default String typeSportBuilding(String codeOfroofedType) {
		Optional<RoofedTypeBuilding> roofEnum = RoofedTypeBuilding.getEnumByCode(codeOfroofedType);
		String response = "not specified";
		if(roofEnum.isPresent()) {
			response = roofEnum.get().getValue();
		}
		return response;
	}
}
