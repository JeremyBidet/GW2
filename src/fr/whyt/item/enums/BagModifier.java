package fr.whyt.item.enums;

public enum BagModifier {

	NO_SELL_OR_SORT("no_sell_or_sort");

	private String name;

	private BagModifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static BagModifier resolve(String name) {
		for (BagModifier value : BagModifier.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}
	
}
