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
	
	private String name;

	private Rarity(String name) {
		this.name = name;
	}

	public static Rarity resolve(String name) {
		for (Rarity value : Rarity.values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}
	
}
