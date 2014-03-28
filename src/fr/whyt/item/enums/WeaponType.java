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
	
	WARHORN("Warhorn"),
	PISTOL("Pistol"),
	TRIDENT("Trident"),
	SHORTBOW("ShortBow"),
	MACE("Mace"),
	LONGBOW("LongBow"),
	DAGGER("Dagger"),
	HARPOON("Harpoon"),
	SWORD("Sword"),
	SHIELD("Shield"),
	GREATSWORD("Greatsword"),
	RIFLE("Rifle"),
	HAMMER("Hammer"),
	FOCUS("Focus"),
	STAFF("Staff"),
	SCEPTER("Scepter"),
	AXE("Axe"),
	SPEARGUN("Speargun"),
	TORCH("Torch"),
	TOY("Toy"),
	TWO_HANDED_TOY("TwoHandedToy");
	
	private String name;
	
	private WeaponType(String name) {
		this.name = name;
	}
	
	public static WeaponType resolve(String name) {
		for (WeaponType state : WeaponType.values()) {
			if (state.name.equals(name)) {
				return state;
			}
		}
		throw new IllegalArgumentException(name);
	}
	
}
