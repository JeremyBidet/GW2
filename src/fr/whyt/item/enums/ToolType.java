package fr.whyt.item.enums;

public enum ToolType {
	
	SALVAGE("Salvage");
	
	private String name;

	private ToolType(String name) {
		this.name = name;
	}

	public static ToolType resolve(String name) {
		for (ToolType value : ToolType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
