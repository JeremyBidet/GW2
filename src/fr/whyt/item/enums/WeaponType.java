package fr.whyt.item.enums;

/**
 * Enumération représentant les différents types d'armes.<br>
 * <ul></ul>
 * <ul>
 * 	<li>Les armes à une main :<br>
 * 		<ul>
 * 			<li>Hache</li>
 * 			<li>Dague</li>
 * 			<li>Masse</li>
 * 			<li>Pistolet</li>
 * 			<li>Sceptre</li>
 * 			<li>Epée</li>
 * 		</ul>
 * 	</li>
 * 	<li>Les armes à main secondaire :<br>
 * 		<ul>
 * 			<li>Focus</li>
 * 			<li>Bouclier</li>
 * 			<li>Torche</li>
 * 			<li>Cor de guerre</li>
 * 		</ul>
 * 	</li>
 * 	<li>Les armes à deux mains :<br>
 * 		<ul>
 * 			<li>Espadon</li>
 * 			<li>Marteau</li>
 * 			<li>Arc long</li>
 * 			<li>Fusil</li>
 * 			<li>Arc court</li>
 * 			<li>Bâton</li>
 * 		</ul>
 * 	</li>
 * 	<li>Les armes aquatiques :<br>
 * 		<ul>
 * 			<li>Fusil-harpon</li>
 * 			<li>Lance</li>
 * 			<li>Trident</li>
 * 		</ul>
 * 	</li>
 * </ul>
 * <bR>
 * @author WhyT
 *
 */
public enum WeaponType {
	
	
	DESSERT("Dessert"),
	COMPONENT("Component"),
	WARHORN("Warhorn"),
	PISTOL("Pistol"),
	TRIDENT("Trident"),
	SHORTBOW("ShortBow"),
	MEAL("Meal"),
	MACE("Mace"),
	LONGBOW("LongBow"),
	DAGGER("Dagger"),
	HARPOON("Harpoon"),
	SWORD("Sword"),
	SHIELD("Shield"),
	UPGRADE_COMPONENT("UpgradeComponent"),
	GREATSWORD("Greatsword"),
	INGREDIENT_COOKING("IngredientCooking"),
	RIFLE("Rifle"),
	DYE("Dye"),
	INSCRIPTION("Inscription"),
	BULK("Bulk"),
	HAMMER("Hammer"),
	SNACK("Snack"),
	FOCUS("Focus"),
	SEASONING("Seasoning"),
	FEAST("Feast"),
	STAFF("Staff"),
	SCEPTER("Scepter"),
	SOUP("Soup"),
	CONSUMABLE("Consumable"),
	AXE("Axe"),
	REFINEMENT("Refinement"),
	POTION("Potion"),
	INSIGNIA("Insignia"),
	SPEARGUN("Speargun"),
	BAG("Bag"),
	EARRING("Earring"),
	TORCH("Torch"),
	TOY("Toy"),
	TWO_HANDED_TOY("TwoHandedToy");
	
	private final String type;
	
	private WeaponType(String type) {
		this.type = type;
	}
	
	public static WeaponType resolve(String type) {
		for (WeaponType state : WeaponType.values()) {
			if (state.type.equals(type)) {
				return state;
			}
		}
		throw new IllegalArgumentException(type);
	}
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(WeaponType t : WeaponType.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
}
