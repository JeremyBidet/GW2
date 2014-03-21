package fr.whyt.item;

/**
 * Enumération des différents types d'objets disponibles.<br>
 * <ul>
 * 	<li>ARME : Armes</li>
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

	ARME,
	COLIFICHET,
	ARTISANAT,
	RUNE,
	CACHET;
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(Type t : Type.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
}
