package fr.whyt.item;

/**
 * Définie les statistiques bonus d'un objet.<br>
 * Un champ <i>name</i> : {@link StatType} et <i>value</i>
 * <br>
 * @author WhyT
 *
 */
public class Stat {
	
	private StatType name;
	private int value;
	
	public Stat (StatType name, int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Stat 
				&& ((Stat)o).name.equals(name) 
				&& ((Stat)o).value == value;
	}
	
	/**
	 * Retourne la valeur du bonus et son nom.
	 * <br>
	 * @return "+<i>value</i> <i>name</i>"
	 */
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		return sb.append("+").append(value).append(" ").append(name).toString();
	}

}
