package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.components.InfusionSlot;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type dorsale dans le jeu.<br>
 * Possède des emplacements d'infusions, une améliorations.<br>
 * @see InfusionSlot
 * @see InfixUpgrade
 * @author WhyT
 */
public class Back extends Item {
	
	private List<InfusionSlot> infusionSlots;
	private InfixUpgrade infixUpgrade;
	private final String suffixItemId;
	
	/**
	 * Crée un {@link Item} de type dorsale.<br>
	 * @param id 					identifiant unique de l'item
	 * @param name 					nom de l'item
	 * @param description 			description de l'item
	 * @param type					type de l'item ({@link Type})
	 * @param rarity				rareté de l'item ({@link Rarity})
	 * @param level					niveau de l'item
	 * @param basePrice				prix de l'item à l'achat/vente chez un marchand ({@link Currency})
	 * @param blPrice				prix de l'item à l'achat/vente au lion noir ({@link Currency})
	 * @param iconFileID			id de l'image de l'item
	 * @param iconFileSignature		signature de l'image de l'item
	 * @param gameType				type de jeu de l'item ({@link GameType})
	 * @param flags					drapeaux de l'item ({@link Flag})
	 * @param restrictions			restrictions de personnages de l'item ({@link Restriction})
	 * @param infusionSlots			emplacements d'infusions ({@link InfusionSlot})
	 * @param infixUpgrade			améliorations de l'armure ({@link InfixUpgrade})
	 * @param suffixItemId			ID du suffixe de l'item
	 */
	public Back(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity,
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature,
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Bag fields
			List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade, String suffixItemId) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
		this.suffixItemId = suffixItemId;
	}
	/* ** Getters ** */
	public List<InfusionSlot> getInfusionSlots()					{ return infusionSlots; }
	public InfixUpgrade getInfixUpgrade() 							{ return infixUpgrade; }
	public String getSuffixItemId() 								{ return suffixItemId; }
	/* ** Setters ** */
	public void setInfusionSlots(List<InfusionSlot> infusionSlots) 	{ this.infusionSlots = infusionSlots; }
	public void setInfixUpgrade(InfixUpgrade infixUpgrade) 			{ this.infixUpgrade = infixUpgrade; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 						{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + infusionSlots + "\n"
				+ "| " + infixUpgrade + "\n"
				+ "| " + suffixItemId + "\n";
	}

}
