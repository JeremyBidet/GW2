package fr.whyt.item.enums;

public enum DamageType {
	
	PHYSICAL("Physical"),
	ICE("Ice"),
	FIRE("Fire"),
	LIGHTNING("Lightning");
	
	private String type;

	private DamageType(String type) {
		this.type = type;
	}

	public static DamageType resolve(String type) {
		for (DamageType value : DamageType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
