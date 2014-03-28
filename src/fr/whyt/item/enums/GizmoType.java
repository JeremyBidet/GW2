package fr.whyt.item.enums;

public enum GizmoType {
	
	DEFAULT("Default"),
	RENTABLE_CONTRACT_NPC("RentableContractNpc"),
	UNLIMITED_CONSUMABLE("UnlimitedConsumable");
	
	private String name;

	private GizmoType(String name) {
		this.name = name;
	}

	public static GizmoType resolve(String name) {
		for (GizmoType value : GizmoType.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
