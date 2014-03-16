package fr.whyt.item;

import static fr.whyt.item.Type.ARTISANAT;

/**
 * Représente un matériau permettant de crafter un item, ou pouvant ête crafté.<br>
 * Le matériau possède tous les champs d'un objet ({@link Item}) de base.
 * <br>
 * @author WhyT
 *
 */
public class CraftMaterial extends Item {
	
	public CraftMaterial(String name, Scarcity scarcity, int level, Currency price) {
		super(name, ARTISANAT, scarcity, level, price);
	}

	public CraftMaterial(String name, Scarcity scarcity, int level, int price) {
		super(name, ARTISANAT, scarcity, level, price);
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
