package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.components.InfusionSlot;
import fr.whyt.item.enums.ArmorType;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.WeightClass;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type armure dans le jeu.<br>
 * Possède un type d'armure, une classe de poids, une valeur défensive, des emplacements d'infusions
 *  et des améliorations.<br>
 * @see ArmorType
 * @see WeightClass
 * @see InfusionSlot
 * @see InfixUpgrade
 * @author WhyT
 */
public class Armor extends Item {
	
	private final ArmorType armorType;
	private final WeightClass weightClass;
	private final Long defense;
	private List<InfusionSlot> infusionSlots;
	private InfixUpgrade infixUpgrade;
	
	/**
	 * Crée un {@link Item} de type armure.<br>
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
	 * @param armorType				type de l'armure ({@link ArmorType})
	 * @param weightClass			classe de poids de l'armure ({@link WeightClass})
	 * @param defense				valeur défensive de l'armure
	 * @param infusionSlots			emplacements d'infusions ({@link InfusionSlot})
	 * @param infixUpgrade			améliorations de l'armure ({@link InfixUpgrade})
	 */
	public Armor(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity,
			Integer base_price, Integer bl_price, Long icon_file_if, String icon_file_signature,
			List<GameType> game_type, List<Flag> flags, List<Restriction> restrictions,
			// Armor fields
			ArmorType armorType, WeightClass weightClass, Long defense, List<InfusionSlot> infusionSlots,
			InfixUpgrade infixUpgrade) {
		
		super(id, name, description, type, level, rarity, base_price, bl_price,
				icon_file_if, icon_file_signature, game_type, flags,
				restrictions);
		this.armorType = armorType;
		this.weightClass = weightClass;
		this.defense = defense;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
	}
	/* ** Getters ** */
	public ArmorType getArmorType() 								{ return armorType; }
	public WeightClass getWeightClass() 							{ return weightClass; }
	public Long getDefense() 										{ return defense; }
	public List<InfusionSlot> getInfusionSlots()				 	{ return infusionSlots; }
	public InfixUpgrade getInfixUpgrade() 							{ return infixUpgrade; }
	/* ** Setters ** */
	public void setInfusionSlots(List<InfusionSlot> infusionSlots) 	{ this.infusionSlots = infusionSlots; }
	public void setInfixUpgrade(InfixUpgrade infixUpgrade) 			{ this.infixUpgrade = infixUpgrade; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 						{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + armorType + "\n"
				+ "| " + weightClass + "\n"
				+ "| " + defense + "\n"
				+ "| " + infusionSlots + "\n"
				+ "| " + infixUpgrade + "\n";
	} 

}
