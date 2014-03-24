package fr.whyt.item.enums;

/**
 * Enumération réprésentant les différentes raretés dans le jeu.<br><br>
 * Elle se décompose en paliers (du plus courant au plus rare) :
 * <ol>
 * <li>NORMAL : Normale</li>
 * <li>RAFFINE : Raffiné</li>
 * <li>CHEF_D_OEUVRE : Chef-d'oeuvre</li>
 * <li>RARE : Rare</li>
 * <li>EXOTIQUE : Exotique</li>
 * <li>ELEVE : Elevé</li>
 * <li>LEGENDAIRE : Légendaire</li>
 * </ol>
 * @author WhyT
 *
 */
public enum Rarity {
	
	BASIC("Basic"),
	FINE("Fine"),
	MASTERWORK("Masterwork"),
	RARE("Rare"),
	EXOTIC("Exotic"),
	ASCENDED("Ascended"),
	LEGENDARY("Legendary"),
	JUNK("Junk");
	
	private String type;

	private Rarity(String type) {
		this.type = type;
	}

	public static Rarity resolve(String type) {
		for (Rarity value : Rarity.values()) {
			if (value.type.equals(type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(Rarity t : Rarity.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
}
