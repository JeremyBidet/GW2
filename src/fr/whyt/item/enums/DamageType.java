package fr.whyt.item.enums;

public enum DamageType {
	
	PHYSICAL("Physical"),
	ICE("Ice"),
	FIRE("Fire"),
	LIGHTNING("Lightning");
	
	private String name;

	private DamageType(String name) {
		this.name = name;
	}

	public static DamageType resolve(String name) {
		for (DamageType value : DamageType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
