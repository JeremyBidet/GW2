package fr.whyt.item.enums;

public enum UpgradeComponentFlag {
	
	AXE("Axe"),
	LONGBOW("LongBow"),
	SHOTBOW("ShortBow"),
	DAGGER("Dagger"),
	FOCUS("Focus"),
	GREATSWORD("Greatsword"),
	HAMMER("Hammer"),
	HARPOON("Harpoon"),
	MACE("Mace"),
	PISTOL("Pistol"),
	RIFLE("Rifle"),
	SCEPTER("Scepter"),
	SHIELD("Shield"),
	SPEARGUN("Speargun"),
	STAFF("Staff"),
	SWORD("Sword"),
	TORCH("Torch"),
	TRIDENT("Trident"),
	WARHORN("Warhorn"),
	TRINKET("Trinket"),
	HEAVY_ARMOR("HeavyArmor"),
	LIGHT_ARMOR("LightArmor"),
	MEDIUM_ARMOR("MediumArmor");
	
	private String type;

	private UpgradeComponentFlag(String type) {
		this.type = type;
	}

	public static UpgradeComponentFlag resolve(String type) {
		for (UpgradeComponentFlag value : UpgradeComponentFlag.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}

}
