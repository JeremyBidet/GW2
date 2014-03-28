package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.components.InfusionSlot;
import fr.whyt.item.enums.ArmorType;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.WeightType;
import fr.whyt.persona.enums.Restriction;

/**
 * H�rite de {@link Item}.<br>
 * Repr�sente un objet de type mat�riaux de recette dans le jeu.<br>
 * Ne poss�de aucun champs suppl�mentaires.<br>
 * @see ArmorType
 * @see WeightType
 * @see InfusionSlot
 * @see InfixUpgrade
 * @author WhyT
 */
public class CraftMaterial extends Item {
	
	public CraftMaterial(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity, 
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature, 
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions) {
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
	}
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 	{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------";
	}

}
