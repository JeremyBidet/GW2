package fr.whyt.item.enums;

public enum UpgradeComponentType {
	
	SIGIL("Sigil"),
	DEFAULT("Default"),
	RUNE("Rune"),
	GEM("Gem");
	
	private String name;

	private UpgradeComponentType(String name) {
		this.name = name;
	}

	public static UpgradeComponentType resolve(String name) {
		for (UpgradeComponentType value : UpgradeComponentType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
