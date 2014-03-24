package fr.whyt.item.enums;

public enum ContainerType {
	
	DEFAULT("Default"),
	GIFT_BOX("GiftBox");
	
	private String type;

	private ContainerType(String type) {
		this.type = type;
	}

	public static ContainerType resolve(String type) {
		for (ContainerType value : ContainerType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
