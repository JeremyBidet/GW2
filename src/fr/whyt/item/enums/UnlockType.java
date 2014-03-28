package fr.whyt.item.enums;

public enum UnlockType {
	
	CRAFTING_RECIPE("CraftingRecipe"),
	DYE("Dye");
	
	private String name;

	private UnlockType(String name) {
		this.name = name;
	}

	public static UnlockType resolve(String name) {
		for (UnlockType value : UnlockType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
