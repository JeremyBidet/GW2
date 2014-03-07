package fr.whyt.craft;

import java.util.ArrayList;
import java.util.List;

import fr.whyt.item.Item;

/**
 * Représente un noeud dans l'arbre de création.<br>
 * Il contient un objet ({@link Item}) et sa quantité.<br>
 * @author WhyT
 *
 */
public class Node {
	private int quantity;
	private final Item item;
	private int level;
	private List<Node> sons;
	
	/**
	 * Crée un noeud contenant une quantité et un item
	 * @param quantity quantité de l'objet à crafter.
	 * @param item objet à crafter.
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
			this.sons = null;
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public List<Node> getSons() {
		return sons;
	}
	
	private String indent() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<this.level; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	
	/**
	 * Permet de changer la quantité à crafter de cet objet.
	 * @param quantity quantité de l'objet
	 */
	public void setQuantity (int quantity) {
		this.quantity = quantity;
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
