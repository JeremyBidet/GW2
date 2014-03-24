package fr.whyt.item.enums;

public enum GizmoType {
	
	DEFAULT("Default"),
	RENTABLE_CONTRACT_NPC("RentableContractNpc"),
	UNLIMITED_CONSUMABLE("UnlimitedConsumable");
	
	private String type;

	private GizmoType(String type) {
		this.type = type;
	}

	public static GizmoType resolve(String type) {
		for (GizmoType value : GizmoType.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
