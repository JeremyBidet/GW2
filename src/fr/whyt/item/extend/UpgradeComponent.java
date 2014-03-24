package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.InfusionSlotFlag;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.UpgradeComponentFlag;
import fr.whyt.item.enums.UpgradeComponentType;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type composant d'amélioration dans le jeu.<br>
 * Possède un type de composant, des drapeaux de composant, des améliorations, un suffix,
 *  des drapeaux d'emplacements d'infusion et des bonus.<br>
 * @see UpgradeComponentType
 * @see UpgradeComponentFlag
 * @see InfusionSlotFlag
 * @see InfixUpgrade
 * @author WhyT
 */
public class UpgradeComponent extends Item {
	
	private final UpgradeComponentType upgradeComponentType;
	private List<UpgradeComponentFlag> upgradeComponentFlags;
	private InfixUpgrade infixUpgrade;
	private final String suffix;
	private List<InfusionSlotFlag> infusionUpgradeFlags;
	private List<String> bonuses;
	
	/**
	 * Crée un {@link Item} de type de composants d'amélioration.<br>
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
	 * @param upgradeComponentType	type du composant d'amélioration
	 * @param upgradeComponentFlags	drapeaux du composant
	 * @param infixUpgrade			améliorations
	 * @param suffix				suffixe du composant
	 * @param infusionUpgradeFlags	drapeaux d'emplacements d'infusion
	 * @param bonuses				des bonus
	 */
	public UpgradeComponent(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity, 
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature,
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions, 
			// UpgradeComponent fields
			UpgradeComponentType upgradeComponentType, List<UpgradeComponentFlag> upgradeComponentFlags, 
			InfixUpgrade infixUpgrade, String suffix, List<InfusionSlotFlag> infusionUpgradeFlags,
			List<String> bonuses) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.upgradeComponentType = upgradeComponentType;
		this.upgradeComponentFlags = upgradeComponentFlags;
		this.infixUpgrade = infixUpgrade;
		this.suffix = suffix;
		this.infusionUpgradeFlags = infusionUpgradeFlags;
		this.bonuses = bonuses;
	}
	/* ** Getters ** */
	public UpgradeComponentType getUpgradeComponentType() 			{ return upgradeComponentType; }
	public List<UpgradeComponentFlag> getUpgradeComponentFlags() 	{ return upgradeComponentFlags; }
	public InfixUpgrade getInfixUpgrade() 							{ return infixUpgrade; }	
	public String getSuffix() 										{ return suffix; }
	public List<InfusionSlotFlag> getInfusionUpgradeFlags() 		{ return infusionUpgradeFlags; }
	public List<String> getBonuses() 								{ return bonuses; }
	/* ** Setters ** */
	public void setUpgradeComponentFlags(
			List<UpgradeComponentFlag> upgradeComponentFlags) {
		this.upgradeComponentFlags = upgradeComponentFlags;
	}
	public void setInfixUpgrade(InfixUpgrade infixUpgrade) 			{ this.infixUpgrade = infixUpgrade; }
	public void setInfusionUpgradeFlags(
			List<InfusionSlotFlag> infusionUpgradeFlags) {
		this.infusionUpgradeFlags = infusionUpgradeFlags;
	}
	public void setBonuses(List<String> bonuses) 					{ this.bonuses = bonuses; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 						{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + upgradeComponentType + "\n"
				+ "| " + upgradeComponentFlags + "\n"
				+ "| " + infixUpgrade + "\n"
				+ "| " + suffix + "\n"
				+ "| " + infusionUpgradeFlags + "\n"
				+ "| " + bonuses + "\n";
	}


}
