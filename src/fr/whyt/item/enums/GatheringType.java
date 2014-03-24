package fr.whyt.item.enums;

public enum GatheringType {
	
	MINING("Mining"),
	LOGGING("Logging"),
	FORAGING("Foraging");
	
	private String type;

	private GatheringType(String type) {
		this.type = type;
	}

	public static GatheringType resolve(String type) {
		for (GatheringType value : GatheringType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
