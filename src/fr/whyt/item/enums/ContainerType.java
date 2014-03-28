package fr.whyt.item.enums;

public enum ContainerType {
	
	DEFAULT("Default"),
	GIFT_BOX("GiftBox");
	
	private String name;

	private ContainerType(String name) {
		this.name = name;
	}

	public static ContainerType resolve(String name) {
		for (ContainerType value : ContainerType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
