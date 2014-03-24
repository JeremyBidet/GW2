package fr.whyt.item.enums;

public enum WeightClass {
	
	LIGHT("Light"),
	MEDIUM("Medium"),
	HEAVY("Heavy"),
	CLOTHING("Clothing");
	
	private String type;

	private WeightClass(String type) {
		this.type = type;
	}
	
	public static WeightClass resolve(String type) {
		for (WeightClass value : WeightClass.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
