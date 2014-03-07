package fr.whyt.item;

import static fr.whyt.item.Type.ARME;

/**
 * D�finie une arme du jeu.<br>
 * H�rite de la classe {@link Item}.<br>
 * <br>
 * Avec les champs : <i>damage</i>:{@link Damage}, <i>bonus</i>:{@link Bonus}, <i>weapon</i>:{@link TypeWeapon}.
 * <br>
 * @author Jeremy
 *
 */
public class Weapon extends Item {
	
	private final TypeWeapon weapon;
	private final Damage damage;
	private final Bonus bonus;

	public Weapon(String name, Scarcity scarcity, int level, Currency price,
			Damage damage, Bonus bonus, TypeWeapon weapon) {
		super(name, ARME, scarcity, level, price);
		this.damage = damage;
		this.bonus = bonus;
		this.weapon = weapon;
	}

	public Weapon(String name, Scarcity scarcity, int level, int price,
			Damage damage, Bonus bonus, TypeWeapon weapon) {
		super(name, ARME, scarcity, level, price);
		this.damage = damage;
		this.bonus = bonus;
		this.weapon = weapon;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bonus == null) ? 0 : bonus.hashCode());
		result = prime * result + ((damage == null) ? 0 : damage.hashCode());
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Weapon 
				&& super.equals(o)
				&& ((Weapon)o).weapon.equals(weapon) 
				&& ((Weapon)o).damage.equals(damage) 
				&& ((Weapon)o).bonus.equals(bonus);
	}

	/**
	 * @return "<i>{@link Item}.toString()</i><br>
	 * 			<i>damage</i><br>
	 * 			<i>bonus</i><br>
	 * 			<i>weapon</i>"<br>
	 */
	@Override
	public String toString () {
		return super.toString()
				+ "| " + damage + "\n"
				+ bonus
				+ "| " + weapon + "\n\n";
	}

}
