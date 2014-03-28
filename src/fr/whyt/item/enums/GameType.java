package fr.whyt.item.enums;

public enum GameType {
	
	ACTIVITY("Activity"),
	DUNGEONS("Dungeons"),
	PVE("PvE"),
	WVW("WvW"),
	PVP("PvP");
	
	public String name;
	
	private GameType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static GameType resolve(String name) {
		for (GameType value : GameType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		return null;
	}

}
