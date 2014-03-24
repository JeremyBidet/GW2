package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.enums.ConsumableType;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.UnlockType;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de type consommable dans le jeu.<br>
 * Possède un type de consommable, une description, une durée, un type de dévérouillage,
 *  un id de couleur et un id de recette.<br>
 * @see ConsumableType
 * @see UnlockType
 * @author WhyT
 */
public class Consumable extends Item {
	
	private final ConsumableType consumableType;
	private final String consumableDescription;
	private Integer duration;
	private final UnlockType unlockType;
	private final Long colorID;
	private final Long recipeID;
	
	/**
	 * Crée un {@link Item} de type consommable</b>.<br>
	 * @param id 					identifiant unique de l'item
	 * @param name 					nom de l'item
	 * @param consumableDescription 			consumableDescription de l'item
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
	 * @param consumableType		type du consommable ({@link ConsumableType})
	 * @param consumableDescription	description du consommable
	 * @param duration				durée d'effet du consommable
	 * @param unlockType			type de dévérouillage ({@link UnlockType})
	 * @param colorID				ID de la couleur
	 * @param recipeID				ID de la recette
	 */
	public Consumable(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity,
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature,
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Consumable fields
			ConsumableType consumableType, String consumableDescription, Integer duration, UnlockType unlockType,
			Long colorID, Long recipeID) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.consumableType = consumableType;
		this.consumableDescription = consumableDescription;
		this.duration = duration;
		this.unlockType = unlockType;
		this.colorID = colorID;
		this.recipeID = recipeID;
	}
	/* ** Getters ** */
	public UnlockType getUnlockType() 				{ return this.unlockType; }
	public Long getColorID() 						{ return this.colorID; }
	public Long getRecipeID() 						{ return this.recipeID; }
	public String getConsumableDescription() 		{ return consumableDescription; }
	public Integer getDuration() 					{ return duration; }
	public ConsumableType getConsumableType() 		{ return consumableType; }
	/* ** Setters ** */
	public void setDuration(Integer duration) 		{ this.duration = duration; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 		{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + consumableType + "\n"
				+ "| " + consumableDescription + "\n"
				+ "| " + duration + "\n"
				+ "| " + unlockType + "\n"
				+ "| " + colorID + "\n"
				+ "| " + recipeID + "\n";
	}
	
}
