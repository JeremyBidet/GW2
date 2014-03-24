package fr.whyt.item.enums;

public enum BagModifier {

	NO_SELL_OR_SORT("no_sell_or_sort");

	private String type;

	private BagModifier(String type) {
		this.type = type;
	}

	public static BagModifier resolve(String type) {
		for (BagModifier value : BagModifier.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

	public String getTechName() {
		return type;
	}

}
