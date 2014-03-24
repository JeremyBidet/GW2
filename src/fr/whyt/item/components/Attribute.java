package fr.whyt.item.components;

import fr.whyt.item.enums.AttributeType;

/**
 * Représente un attribut d'un objet dans le jeu.<br>
 * Possède un  type d'attribut et un modificateur d'attribut.<br>
 * <br>
 * @see AttributeType
 * @author WhyT
 */
public class Attribute {
	
	private final AttributeType attribute;
	private final Integer modifier;
	
	/**
	 * Crée un attribut.<br>
	 * @param attribute	type de l'attribut
	 * @param modifier	modificateur de l'attribut
	 */
	public Attribute(AttributeType attribute, Integer modifier) {
		this.attribute = attribute;
		this.modifier = modifier;
	}
	/* ** Getters ** */
	public AttributeType getAttribute() 	{ return attribute; }
	public Integer getModifier() 			{ return modifier; }
	/* ** Overrides ** */
	@Override public boolean equals(Object o) {
		return o instanceof Attribute 
				&& ((Attribute)o).attribute.equals(attribute)
				&& ((Attribute)o).modifier == modifier;
	}
	@Override public String toString() {
		return "Attribute [attribute=" + attribute + ", modifier=" + modifier + "]";
	}

}
