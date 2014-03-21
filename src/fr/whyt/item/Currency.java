package fr.whyt.item;

/**
 * Monnaie du jeu.<br>
 * Est repr�sent� sous forme de pi�ce d'or, d'argent, de bronze.<br>
 * Respectivement :<br>
 * pi�ce d'or, pi�ce d'argent, pi�ce de bronze : po, pa, pb<br>
 * o�<br>
 * 1 po = 100 pa<br>
 * 1 pa = 100 pb<br>
 * ex : 4 po 68 pa 13 pb = 468 pa 13 pb = 46813 pb
 * <br>
 * @author WhyT
 *
 */
public class Currency {
	
	private int gold;
	private int silver;
	private int bronze;
	
	/**
	 * Cr�e la monnaie du jeu.
	 * @param gold quantit� d'or
	 * @param silver quantit� d'argent
	 * @param bronze quantit� de bronze
	 */
	public Currency (int gold, int silver, int bronze) {
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	/**
	 * Permet de r�cup�rer la valeur totale de l'objet.
	 * @return la valeur de l'objet en bronze (int)
	 */
	public int toBronze () {
		return gold*10000 + silver*100 + bronze;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Currency 
				&& ((Currency)o).bronze == bronze 
				&& ((Currency)o).silver == silver 
				&& ((Currency)o).gold == gold;
	}

	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		return sb.append(gold).append(" po ")
				.append(silver).append(" pa ")
				.append(bronze).append(" pb")
				.toString();
	}
}
