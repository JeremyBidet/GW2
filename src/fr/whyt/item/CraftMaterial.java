package fr.whyt.item;

import static fr.whyt.item.Type.ARTISANAT;

/**
 * Repr�sente un mat�riau permettant de crafter un item, ou pouvant �te craft�.<br>
 * Le mat�riau poss�de tous les champs d'un objet ({@link Item}) de base.
 * <br>
 * @author WhyT
 *
 */
public class CraftMaterial extends Item {
	
	public CraftMaterial(String name, Rarity rarity, int level, Currency price) {
		super(name, ARTISANAT, rarity, level, price);
	}

	public CraftMaterial(String name, Rarity rarity, int level, int price) {
		super(name, ARTISANAT, rarity, level, price);
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof CraftMaterial 
				&& super.equals(o);
	}
	
	@Override
	public String toString () {
		return super.toString() + "\n";
	}

}
