package fr.whyt.item.enums;

public enum GameType {
	
	ACTIVITY("Activity"),
	DUNGEONS("Dungeons"),
	PVE("PvE"),
	WVW("WvW"),
	PVP("PvP");
	
	public final String type;
	
	private GameType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public static GameType resolve(String type) {
		for (GameType value : GameType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		return null;
	}

}
