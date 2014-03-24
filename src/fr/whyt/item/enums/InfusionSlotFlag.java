package fr.whyt.item.enums;

public enum InfusionSlotFlag {
	
	DEFENSE("Defense"),
	OFFENSE("Offense"),
	UTILITY("Utility");
	
	private String type;

	private InfusionSlotFlag(String type) {
		this.type = type;
	}

	public static InfusionSlotFlag resolve(String type) {
		for (InfusionSlotFlag value : InfusionSlotFlag.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
