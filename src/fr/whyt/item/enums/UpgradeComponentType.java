package fr.whyt.item.enums;

public enum UpgradeComponentType {
	
	SIGIL("Sigil"),
	DEFAULT("Default"),
	RUNE("Rune"),
	GEM("Gem");
	
	private String type;

	private UpgradeComponentType(String type) {
		this.type = type;
	}

	public static UpgradeComponentType resolve(String type) {
		for (UpgradeComponentType value : UpgradeComponentType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
