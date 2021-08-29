package polymorphism;

import java.util.Optional;

public interface SportBuilding extends Building {
	public static final String NO_SPECIFIED = "not specified";
	
	public default String roofedTypeBuilding(String codeOfRoofedType) {
		Optional<RoofedTypeBuilding> roofEnum = RoofedTypeBuilding.getEnumByCode(codeOfRoofedType);
		String response = SportBuilding.NO_SPECIFIED;
		if(roofEnum.isPresent()) {
			response = roofEnum.get().getValue();
		}
		return response;
	}
}
