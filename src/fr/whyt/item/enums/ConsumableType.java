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
	
	private String type;

	private ConsumableType(String type) {
		this.type = type;
	}

	public static ConsumableType resolve(String type) {
		for (ConsumableType value : ConsumableType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
