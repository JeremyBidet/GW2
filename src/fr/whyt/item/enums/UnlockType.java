package fr.whyt.item.enums;

public enum UnlockType {
	
	CRAFTING_RECIPE("CraftingRecipe"),
	DYE("Dye");
	
	private String type;

	private UnlockType(String type) {
		this.type = type;
	}

	public static UnlockType resolve(String type) {
		for (UnlockType value : UnlockType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
