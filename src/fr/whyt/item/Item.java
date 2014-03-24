package fr.whyt.item;

import java.util.List;

import fr.whyt.item.components.Currency;
import fr.whyt.item.enums.Flag;
import fr.whyt.item.enums.GameType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.persona.enums.Restriction;

/**
 * Représente un objet dans le jeu.<br>
 * Possède un id, un nom, une description, un type, un niveau, une rareté,
 *  une valeur marchande de base, une valeur marchande noire, une image,
 *  des types de jeu, des drapeaux et des rectrictions.<br>
 * <br>
 * @see Rarity
 * @see Currency
 * @see GameType
 * @see Flag
 * @see Restriction
 * @author WhyT
 */
public abstract class Item {

	private final Long id;
	private final String name;
	private final String description;
	private final Type type;
	private final Integer level;
	private final Rarity rarity;
	private final Currency basePrice;
	private Currency blPrice;
	private final Long iconFileID;
	private final String iconFileSignature;
	private final List<GameType> gameType;
	private final List<Flag> flags;
	private final List<Restriction> restrictions;

	/**
	 * Crée un item.<br>
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
	 */
	public Item(
			Long id, String name, String description, Type type, Integer level, Rarity rarity,
			Integer basePrice, Integer blPrice, Long iconFileID, String iconFileSignature,
			List<GameType> gameType, List<Flag> flags, List<Restriction> restrictions) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.rarity = rarity;
		this.level = level;
		this.basePrice = new Currency(basePrice/10000, basePrice/100%100, basePrice%100);
		this.blPrice = new Currency(blPrice/10000, blPrice/100%100, blPrice%100);
		this.iconFileID = iconFileID;
		this.iconFileSignature = iconFileSignature;
		this.gameType = gameType;
		this.flags = flags;
		this.restrictions = restrictions;
	}
	/* ** Getters ** */
	public Long getId() 						{ return id; }
	public String getName() 					{ return name; }	
	public String getDescription() 				{ return description; }
	public Type getType() 						{ return type; }
	public Integer getLevel() 					{ return level; }
	public Rarity getRarity() 					{ return rarity; }
	public Currency getBasePrice() 				{ return basePrice; }
	public Currency getBlPrice() 				{ return blPrice; }
	public Long getIconFileID() 				{ return iconFileID; }
	public String getIconFileSignature() 		{ return iconFileSignature; }
	public List<GameType> getGameType() 		{ return gameType; }
	public List<Flag> getFlags() 				{ return flags; }
	public List<Restriction> getRestrictions() 	{ return restrictions; }
	/* ** Setters ** */
	public void setBl_price(Currency blPrice) 	{ this.blPrice = blPrice; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o)	{ return o instanceof Item && ((Item) o).id == id; }
	@Override public String toString() {
		return " _Item______________________________\n"
				+ "| " + id + "\n"
				+ "| " + name + "\n"
				+ "| " + description + "\n"
				+ "| " + type + "\n"
				+ "| " + rarity + "\n"
				+ "| " + level + "\n"
				+ "| " + basePrice + "\n"
				+ "| " + blPrice + "\n"
				+ "| " + iconFileID + "\n"
				+ "| " + iconFileSignature + "\n"
				+ "| " + gameType + "\n"
				+ "| " + flags + "\n"
				+ "| " + restrictions + "\n";
	}
	
}
