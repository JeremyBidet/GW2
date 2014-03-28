package fr.whyt.item.enums;

public enum ArmorType {
	
	BOOTS("Boots"),
	LEGGINGS("Leggings"),
	SHOULDERS("Shoulders"),
	HELM("Helm"),
	GLOVES("Gloves"),
	COAT("Coat"),
	HELM_AQUATIC("HelmAquatic");
	
	private String name;
	
	private ArmorType(String name) {
		this.name = name;
	}
	
	public static ArmorType resolve(String name) {
		for (ArmorType state : ArmorType.values()) {
			if (state.name.equals(name)) {
				return state;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
