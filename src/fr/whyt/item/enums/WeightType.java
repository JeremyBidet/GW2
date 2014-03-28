package fr.whyt.item.enums;

public enum WeightType {
	
	LIGHT("Light"),
	MEDIUM("Medium"),
	HEAVY("Heavy"),
	CLOTHING("Clothing");
	
	private String name;

	private WeightType(String name) {
		this.name = name;
	}
	
	public static WeightType resolve(String name) {
		for (WeightType value : WeightType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
