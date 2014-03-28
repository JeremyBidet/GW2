package fr.whyt.item.enums;

public enum GatheringType {
	
	MINING("Mining"),
	LOGGING("Logging"),
	FORAGING("Foraging");
	
	private String name;

	private GatheringType(String name) {
		this.name = name;
	}

	public static GatheringType resolve(String name) {
		for (GatheringType value : GatheringType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
