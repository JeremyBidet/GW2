package fr.whyt.item;


/**
 * Représente un objet dans le jeu.<br>
 * Il possède un nom, un type, une rareté, un niveau et une valeur.<br><br>
 * Il est possible d'instancier un objet avec deux valeurs différentes :<br>
 * <ul>
 * <li>Avec la monnaie du jeu</li>
 * <li>Avec un entier représentant la plus petite devise de la monnaie du jeu</li>
 * </ul>
 * <br>
 * @see Currency
 * @author Jeremy
 *
 */
public abstract class Item {

	private final int id;
	private final String name;
	private final Type type;
	private final Scarcity scarcity;
	private final int level;
	private final Currency price;
	
	/**
	 * Crée un item. N'accepte que la monnaie de jeu.<br>
	 * L'ID unique est créé à partir du hashcode du nom en minuscule concaténé au type et à la rareté en majuscule de l'objet.<br>
	 * @param name nom de l'item
	 * @param type type de l'item ({@link Type})
	 * @param scarcity rareté de l'item ({@link Scarcity})
	 * @param level niveau de l'item
	 * @param price prix de l'item à l'achat/vente en monnaie de jeu ({@link Currency})
	 */
	public Item (String name, Type type, Scarcity scarcity, int level, Currency price) {
		// calculate the hashcode of concat lowercase name and uppercase scarcity, type string
		this.id = (name.toLowerCase() + type.toString().toUpperCase() + scarcity.toString().toUpperCase())
				.hashCode();
		this.name = name;
		this.type = type;
		this.scarcity = scarcity;
		this.level = level;
		this.price = price;
	}
	
	/**
	 * Crée un item. Accepte la valeur entière de l'objet.<br>
	 * L'ID unique est créé à partir du hashcode du nom en minuscule concaténé au type et à la rareté en majuscule de l'objet.<br>
	 * @param name nom de l'item
	 * @param type type de l'item ({@link Type})
	 * @param scarcity rareté de l'item ({@link Scarcity})
	 * @param level niveau de l'item (0-80)
	 * @param price prix de l'item à l'achat/vente sous forme entière (bronze)
	 */
	public Item (String name, Type type, Scarcity scarcity, int level, int price) {
		// calculate the hashcode of concat lowercase name and uppercase scarcity, type string
		this.id = (name.toLowerCase() + type.toString().toUpperCase() + scarcity.toString().toUpperCase())
				.hashCode();
		this.name = name;
		this.type = type;
		this.scarcity = scarcity;
		this.level = level;
		this.price = new Currency (price/10000, price/100%100, price%100);
	}
	
	/**
	 * Récupère l'Id de l'objet
	 * @return l'id de l'objet
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Récupère le nom de l'objet
	 * @return le nom de l'objet
	 */
	public String getName () {
		return name;
	}
	
	private String borderLength() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<name.length()-3; i++) {
			sb.append("_");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Item 
				&& ((Item)o).name.equalsIgnoreCase(name) 
				&& ((Item)o).type.equals(type) 
				&& ((Item)o).level == level 
				&& ((Item)o).price.equals(price) 
				&& ((Item)o).scarcity.equals(scarcity);
	}

	@Override
	public String toString () {
		return " _Item" + borderLength() + "\n"
				+ "| " + name + "\n"
				+ "| " + scarcity + "\n"
				+ "| " + type + "\n"
				+ "| " + level + "\n"
				+ "| " + price + "\n";
	}
}
