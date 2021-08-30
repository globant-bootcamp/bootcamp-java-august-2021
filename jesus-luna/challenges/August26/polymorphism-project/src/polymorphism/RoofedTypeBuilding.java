package polymorphism;

import java.util.Optional;

public enum RoofedTypeBuilding {
	ROOFED_BUILDING("R", "roofed"), NOT_ROOFED_BUILDING("NR", "not roofed");

	private final String code;
	private final String value;

	private RoofedTypeBuilding(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public static Optional<RoofedTypeBuilding> getEnumByCode(String code) {
		RoofedTypeBuilding roofedTypeBuilding = null;
		for (RoofedTypeBuilding roofType : RoofedTypeBuilding.values()) {
			if (code.equals(roofType.getCode())) {
				roofedTypeBuilding = roofType;
			}
		}
		return Optional.ofNullable(roofedTypeBuilding);
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

}
