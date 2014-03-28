package fr.whyt.item.enums;

public enum UpgradeComponentFlag {
	
	AXE("Axe"),
	LONGBOW("LongBow"),
	SHORTBOW("ShortBow"),
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
	
	private String name;

	private UpgradeComponentFlag(String name) {
		this.name = name;
	}

	public static UpgradeComponentFlag resolve(String name) {
		for (UpgradeComponentFlag value : UpgradeComponentFlag.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
