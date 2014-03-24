package fr.whyt.craft;

import java.util.ArrayList;
import java.util.List;

import fr.whyt.item.Item;

/**
 * Repr�sente un noeud dans l'arbre de cr�ation.<br>
 * Il contient un objet ({@link Item}) et sa quantit�.<br>
 * @author WhyT
 *
 */
public class Node implements Cloneable {
	
	private int quantity;
	private final Item item;
	private int level;
	private List<Node> sons;
	
	/**
	 * Cr�e un noeud contenant une quantit�, un item, un niveau et des fils
	 * @param quantity quantit� de l'objet � crafter.
	 * @param item objet � crafter.
	 * @param level niveau de l'Item dans la recette
	 * @param sons tableau de fils : ingr�dient servant � la fabrication de cet Item
	 */
	public Node (int quantity, Item item, int level, Node... sons) {
		this.quantity = quantity;
		this.item = item;
		this.level = level;
		if(sons != null) {
			this.sons = new ArrayList<Node>(sons.length);
			for(Node son : sons) {
				this.sons.add(son);
			}
		} else {
			this.sons = new ArrayList<Node>(0);
		}
	}
	
	/**
	 * Cr�e un noeud contenant une quantit�, un item, un niveau et des fils
	 * @param quantity quantit� de l'objet � crafter.
	 * @param item objet � crafter.
	 * @param level niveau de l'Item dans la recette
	 * @param sons liste de fils : ingr�dient servant � la fabrication de cet Item
	 */
	public Node (int quantity, Item item, int level, List<Node> sons) {
		this.quantity = quantity;
		this.item = item;
		this.level = level;
		this.sons = sons;
	}
	
	public Long getID() {
		return item.getId();
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public List<Node> getSons() {
		return sons;
	}
	
	public boolean addSon(Node son) {
		return sons.add(son);
	}
	
	private String indent() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<this.level; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	
	/**
	 * Permet de changer la quantit� � crafter de cet objet.
	 * @param quantity quantit� de l'objet
	 */
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public Node clone() {
		return new Node(this.quantity, this.item, this.level, this.sons);
	}
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append(indent())
			.append(String.valueOf(quantity))
			.append(" ")
			.append(item.getName())
			.append("\n");
		for(Node son : sons) {
			sb.append(son.toString());
		}
		return sb.toString();
	}
}
