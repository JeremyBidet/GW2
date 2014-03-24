package fr.whyt.item.enums;

public enum ToolType {
	
	SALVAGE("Salvage");
	
	private String type;

	private ToolType(String type) {
		this.type = type;
	}

	public static ToolType resolve(String type) {
		for (ToolType value : ToolType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
