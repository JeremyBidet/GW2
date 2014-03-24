package fr.whyt.item.enums;

/**
 * Enumération des différents types d'objets disponibles.<br>
 * <ul>
 *	<li>ARME : Armes</li>
 * 	<li>COLIFICHET : Equipement additionnel (Bague, Amulette ...)</li>
 * 	<li>ARTISANAT : matériau d'artisanat</li>
 * 	<li>RUNE : runes</li>
 * 	<li>CACHET : cachets</li>
 * </ul>
 * <br>
 * @author WhyT
 *
 */
public enum Type {

	ARMOR("Armor"),
	BACK("Back"),
	BAG("Bag"),
	CONSUMABLE("Consumable"),
	CONTAINER("Container"),
	CRAFTMATERIAL("Crafting Material"),
	GATHERING("Gathering"),
	GIZMO("Gizmo"),
	MINIPET("Mini Pet"), //no bound information
	TOOL("Tool"),
	TRINKET("Trinket"),
	TROPHY("Trophy"), //no bound information
	UPGRADE_COMPONENT("Upgrade Component"),
	WEAPON("Weapon");
	
	private String type;

	private Type(String type) {
		this.type = type;
	}

	public static Type resolve(String type) {
		for (Type value : Type.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(Type t : Type.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
}
