package fr.whyt.item.enums;

public enum InfusionSlotFlag {
	
	DEFENSE("Defense"),
	OFFENSE("Offense"),
	UTILITY("Utility");
	
	private String name;

	private InfusionSlotFlag(String name) {
		this.name = name;
	}

	public static InfusionSlotFlag resolve(String name) {
		for (InfusionSlotFlag value : InfusionSlotFlag.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
