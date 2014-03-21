package fr.whyt.item;

import static fr.whyt.item.Type.ARME;

/**
 * Définie une arme du jeu.<br>
 * Hérite de la classe {@link Item}.<br>
 * <br>
 * Avec les champs : <i>damage</i>:{@link Damage}, <i>bonus</i>:{@link Bonus}, <i>weapon</i>:{@link WeaponType}.
 * <br>
 * @author Jeremy
 *
 */
public class Weapon extends Item {
	
	private final WeaponType weapon;
	private final Damage damage;
	private final Bonus bonus;

	public Weapon(String name, Rarity rarity, int level, Currency price,
			Damage damage, Bonus bonus, WeaponType weapon) {
		super(name, ARME, rarity, level, price);
		this.damage = damage;
		this.bonus = bonus;
		this.weapon = weapon;
	}

	public Weapon(String name, Rarity rarity, int level, int price,
			Damage damage, Bonus bonus, WeaponType weapon) {
		super(name, ARME, rarity, level, price);
		this.damage = damage;
		this.bonus = bonus;
		this.weapon = weapon;
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
