package fr.whyt.item;

/**
 * Repr�sente un objet dans le jeu.<br>
 * Il poss�de un nom, un type, une raret�, un niveau et une valeur.<br><br>
 * Il est possible d'instancier un objet avec deux valeurs diff�rentes :<br>
 * <ul>
 * <li>Avec la monnaie du jeu</li>
 * <li>Avec un entier repr�sentant la plus petite devise de la monnaie du jeu</li>
 * </ul>
 * <br>
 * @see Currency
 * @author Jeremy
 *
 */
public abstract class Item {

	private final String name;
	private final Type type;
	private final Scarcity scarcity;
	private final int level;
	private final Currency price;
	
	/**
	 * Cr�e un item. N'accepte que la monnaie de jeu.
	 * @param name nom de l'item
	 * @param type type de l'item ({@link Type})
	 * @param scarcity raret� de l'item ({@link Scarcity})
	 * @param level niveau de l'item
	 * @param price prix de l'item � l'achat/vente en monnaie de jeu ({@link Currency})
	 */
	public Item (String name, Type type, Scarcity scarcity, int level, Currency price) {
		this.name = name;
		this.type = type;
		this.scarcity = scarcity;
		this.level = level;
		this.price = price;
	}
	
	/**
	 * Cr�e un item. Accepte la valeur enti�re de l'objet.
	 * @param name nom de l'item
	 * @param type type de l'item ({@link Type})
	 * @param scarcity raret� de l'item ({@link Scarcity})
	 * @param level niveau de l'item (0-80)
	 * @param price prix de l'item � l'achat/vente sous forme enti�re (bronze)
	 */
	public Item (String name, Type type, Scarcity scarcity, int level, int price) {
		this.name = name;
		this.type = type;
		this.scarcity = scarcity;
		this.level = level;
		this.price = new Currency (price/10000, price/100%100, price%100);
	}
	
	/**
	 * R�cup�re le nom de l'objet
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((scarcity == null) ? 0 : scarcity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
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
