package fr.whyt.item.enums;

public enum TrinketType {

	AMULET("Amulet"),
	RING("Ring"),
	ACCESSORY("Accessory");
	
	private final String type;
	
	private TrinketType(String type) {
		this.type = type;
	}
	
	public static TrinketType resolve(String type) {
		for (TrinketType value : TrinketType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
}
