package fr.whyt.item.extend;

import java.util.List;

import fr.whyt.item.Item;
import fr.whyt.item.components.Currency;
import fr.whyt.item.enums.BagModifier;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.persona.enums.Restriction;

/**
 * H�rite de {@link Item}.<br>
 * Repr�sente un objet de type sac � dos dans le jeu.<br>
 * Poss�de une taille et des modificateurs.<br>
 * @see BagModifier
 * @author WhyT
 */
public class Bag extends Item {

	private final Short size;
	private List<BagModifier> bagModifiers;
	/**
	 * Cr�e un {@link Item} de type sac � dos.<br>
	 * @param id 					identifiant unique de l'item
	 * @param name 					nom de l'item
	 * @param description 			description de l'item
	 * @param type					type de l'item ({@link Type})
	 * @param rarity				raret� de l'item ({@link Rarity})
	 * @param level					niveau de l'item
	 * @param basePrice				prix de l'item � l'achat/vente chez un marchand ({@link Currency})
	 * @param blPrice				prix de l'item � l'achat/vente au lion noir ({@link Currency})
	 * @param iconFileID			id de l'image de l'item
	 * @param iconFileSignature		signature de l'image de l'item
	 * @param gameType				type de jeu de l'item ({@link GameType})
	 * @param flags					drapeaux de l'item ({@link Flag})
	 * @param restrictions			restrictions de personnages de l'item ({@link Restriction})
	 * @param size					taille du sac � dos
	 * @param bagModifiers			modificateurs du sac � dos ({@link BagModifier})
	 */
	public Bag(
			// Item fields
			Long id, String name, String description, Type type, Integer level, Rarity rarity,
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature,
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions,
			// Bag fields
			Short size, List<BagModifier> bagModifiers) {
		
		super(id, name, description, type, level, rarity, basePrice, blPrice,
				iconFileID, iconFileSignature, gameType, flags, restrictions);
		this.size = size;
		this.bagModifiers = bagModifiers;
	}
	/* ** Getters ** */
	public Short getSize()										{ return size; }
	public List<BagModifier> getBagModifiers()		 			{ return bagModifiers; }
	/* ** Setters ** */
	public void setBagModifiers(List<BagModifier> bagModifiers)	{ this.bagModifiers = bagModifiers; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) 					{ return super.equals(o); }
	@Override public String toString() {
		return super.toString()
				+ "|-----------------------------------"
				+ "| " + size + "\n"
				+ "| " + bagModifiers + "\n";
	}

}
