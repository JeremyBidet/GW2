package fr.whyt.item;

import java.util.ArrayList;

/**
 * Définie les bonus d'un objet.<br>
 * Un champ <i>bonus<i> : ArrayList<{@link Stat}>.<br>
 * <br>
 * @author WhyT
 *
 */
public class Bonus {
	
	private final ArrayList<Stat> bonus;

	public Bonus(Stat... bonus) {
		this.bonus = new ArrayList<Stat> (bonus.length);
		for(Stat s : bonus) {
			this.bonus.add(s);
		}
	}
	
	public ArrayList<Stat> getBonus() {
		return bonus;
	}
	
	public boolean add(Stat bonus) {
		return this.bonus.add(bonus);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bonus == null) ? 0 : bonus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Bonus 
				&& ((Bonus)o).bonus.equals(bonus);
	}

	/**
	 * Affiche le tableau des bonus.<br>
	 * @return "+<i>value</i> <i>name</i>\n..."
	 * @see Stat
	 */
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		for(Stat s : bonus) {
			sb.append("| ").append(s.toString()).append("\n");
		}
		return sb.toString();
	}

}
