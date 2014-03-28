package fr.whyt.item.enums;

public enum TrinketType {

	AMULET("Amulet"),
	RING("Ring"),
	ACCESSORY("Accessory");
	
	private String name;
	
	private TrinketType(String name) {
		this.name = name;
	}
	
	public static TrinketType resolve(String name) {
		for (TrinketType value : TrinketType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}
}
