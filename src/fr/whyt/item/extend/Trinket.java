package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.components.InfusionSlot;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.TrinketType;
import fr.whyt.item.enums.Type;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type bijou dans le jeu.<br>
 * Possède un type de bijou, des emplacements d'infusions, des améliorations et un suffixe de l'item.<br>
 * @see TrinketType
 * @see InfusionSlot
 * @see InfixUpgrade
 * @author WhyT
 */
public class Trinket extends Item {

	private final TrinketType trinketType;
	private List<InfusionSlot> infusionSlots;
	private InfixUpgrade infixUpgrade;
	private final Long suffixItemId;
	
	/**
	 * Crée un {@link Item} de type bijou.<br>
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
	 * @param trinketType			type du bijou ({@link TrinketType})
	 * @param infusionSlots			emplacements d'infusion
	 * @param infixUpgrade			améliorations
	 * @param suffixItemId			suffixe de l'item
	 */
	public Trinket(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity, 
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature, 
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Trinket fields
			TrinketType trinketType, List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade, 
			Long suffixItemId) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.trinketType = trinketType;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
		this.suffixItemId = suffixItemId;
	}
	/* ** Getters ** */
	public List<InfusionSlot> getInfusionSlots() 					{ return infusionSlots; }
	public InfixUpgrade getInfixUpgrade() 							{ return infixUpgrade; }
	public Long getSuffixItemId() 									{ return suffixItemId; }
	public TrinketType getTrinketType() 							{ return trinketType; }
	/* ** Setters ** */
	public void setInfusionSlots(List<InfusionSlot> infusionSlots) 	{ this.infusionSlots = infusionSlots; }
	public void setInfixUpgrade(InfixUpgrade infixUpgrade) 			{ this.infixUpgrade = infixUpgrade; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 						{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + trinketType + "\n"
				+ "| " + infusionSlots + "\n"
				+ "| " + infixUpgrade + "\n"
				+ "| " + suffixItemId + "\n";
	}
	
}
