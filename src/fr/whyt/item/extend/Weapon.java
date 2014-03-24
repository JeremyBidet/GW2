package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.components.Damage;
import fr.whyt.item.components.InfixUpgrade;
import fr.whyt.item.components.InfusionSlot;
import fr.whyt.item.enums.DamageType;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.WeaponType;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type arme dans le jeu.<br>
 * Possède un type d'arme, un type de dégât, des dégats d'attaque, une valeur défensive,
 *  des emplacements d'infusion et des améliorations.<br>
 * @see WeaponType
 * @see DamageType
 * @see Damage
 * @see InfusionSlot
 * @see InfixUpgrade
 * @author WhyT
 */
public class Weapon extends Item {
	
	private final WeaponType weaponType;
	private final DamageType damageType;
	private final Damage damage;
	private final Integer defense;
	private List<InfusionSlot> infusionSlots;
	private InfixUpgrade infixUpgrade;
	
	/**
	 * Crée un {@link Item} de type arme.<br>
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
	 * @param weaponType			type de l'arme
	 * @param damageType			type de dégâts
	 * @param damage				puissance max et min
	 * @param defense				valeur défensive
	 * @param infusionSlots			emplacements d'infusion
	 * @param infixUpgrade			améliorations
	 */
	public Weapon(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity, 
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature, 
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Weapon fields
			WeaponType weaponType, DamageType damageType, Damage damage, Integer defense,
			List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.weaponType = weaponType;
		this.damageType = damageType;
		this.damage = damage;
		this.defense = defense;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
	}
	/* ** Getters ** */	
	public WeaponType getWeaponType() 								{ return weaponType; }
	public DamageType getDamageType() 								{ return damageType; }
	public Damage getDamage() 										{ return damage; }
	public Integer getDefense() 									{ return defense; }
	public List<InfusionSlot> getInfusionSlots() 					{ return infusionSlots; }
	public InfixUpgrade getInfixUpgrade() 							{ return infixUpgrade; }
	/* ** Setters ** */
	public void setInfusionSlots(List<InfusionSlot> infusionSlots) 	{ this.infusionSlots = infusionSlots; }
	public void setInfixUpgrade(InfixUpgrade infixUpgrade) 			{ this.infixUpgrade = infixUpgrade;	}
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 						{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + weaponType + "\n"
				+ "| " + damageType + "\n"
				+ "| " + damage + "\n"
				+ "| " + defense + "\n"
				+ "| " + infusionSlots + "\n"
				+ "| " + infixUpgrade + "\n";
	}

}
