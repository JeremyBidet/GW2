package fr.whyt.item.enums;

public enum ConsumableType {
	
	UNLOCK("Unlock"),
	GENERIC("Generic"),
	FOOD("Food"),
	UTILITY("Utility"),
	TRANSMUTATION("Transmutation"),
	APPEARANCE_CHANGE("AppearanceChange"),
	CONTRACT_NPC("ContractNpc"),
	HALLOWEEN("Halloween"),
	IMMEDIATE("Immediate"),
	BOOZE("Booze");
	
	private String name;

	private ConsumableType(String name) {
		this.name = name;
	}

	public static ConsumableType resolve(String name) {
		for (ConsumableType value : ConsumableType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
