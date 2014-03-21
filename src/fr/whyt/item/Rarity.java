package fr.whyt.item;

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
	
	NORMAL,
	RAFFINE,
	CHEF_D_OEUVRE,
	RARE,
	EXOTIQUE,
	ELEVE,
	LEGENDAIRE;
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(Rarity t : Rarity.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
}
