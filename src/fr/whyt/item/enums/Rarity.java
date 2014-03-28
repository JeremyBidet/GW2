package fr.whyt.item.enums;

/**
 * Enum�ration r�pr�sentant les diff�rentes raret�s dans le jeu.<br><br>
 * Elle se d�compose en paliers (du plus courant au plus rare) :
 * <ol>
 * <li>NORMAL : Normale</li>
 * <li>RAFFINE : Raffin�</li>
 * <li>CHEF_D_OEUVRE : Chef-d'oeuvre</li>
 * <li>RARE : Rare</li>
 * <li>EXOTIQUE : Exotique</li>
 * <li>ELEVE : Elev�</li>
 * <li>LEGENDAIRE : L�gendaire</li>
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
