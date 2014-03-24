package fr.whyt.item.components;

/**
 * Repr�sente les d�gats d'un arme.<br>
 * Un champ <i>lower</i> : int et <i>higher</i> : int.<br>
 * Respectivement les d�g�ts les plus faibles et les plus �lev�s.<br>
 * <br>
 * @author WhyT
 *
 */
public class Damage {
	
	private int lower;
	private int higher;

	public Damage(int higher, int lower) {
		this.lower = lower;
		this.higher = higher;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Damage 
				&& ((Damage)o).lower == lower 
				&& ((Damage)o).higher == higher;
	}

	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		return sb.append(lower).append("-").append(higher).toString();
	}

}
