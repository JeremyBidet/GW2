package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.GatheringType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.persona.enums.Restriction;

/**
 * Hérite de {@link Item}.<br>
 * Représente un objet de gatheringType collecteur dans le jeu.<br>
 * Possède un gatheringType de collecteur.<br>
 * @see GatheringType
 * @author WhyT
 */
public class Gathering extends Item {

	private final GatheringType gatheringType;
	
	/**
	 * Crée un {@link Item} de type collecteur.<br>
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
	 * @param gatheringType			type du collecteur ({@link GatheringType})
	 */
	public Gathering(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity, 
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature, 
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Gathering fields
			GatheringType gatheringType) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.gatheringType = gatheringType;
	}
	/* ** Getters ** */
	public GatheringType getGatheringType()				{ return gatheringType; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 	{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + gatheringType + "\n";
	}
	
}
