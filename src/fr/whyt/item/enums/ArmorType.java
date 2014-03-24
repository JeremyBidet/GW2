package fr.whyt.item.enums;

public enum ArmorType {
	
	BOOTS("Boots"),
	LEGGINGS("Leggings"),
	SHOULDERS("Shoulders"),
	HELM("Helm"),
	GLOVES("Gloves"),
	COAT("Coat"),
	HELM_AQUATIC("HelmAquatic");
	
	private final String type;
	
	private ArmorType(String type) {
		this.type = type;
	}
	
	public static ArmorType resolve(String type) {
		for (ArmorType state : ArmorType.values()) {
			if (state.type.equals(type)) {
				return state;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
