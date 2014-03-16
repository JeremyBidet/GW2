package fr.whyt.craft;


/**
 * Arbre représentant la racine de l'objet à crafter.<br>
 * Il contient donc un sous-arbre ({@link SubTree}).<br>
 * Ce sous-arbre est la racine de l'arbre de création.<br>
 * @author WhyT
 *
 */
public class Tree {

	private final int id;
	private final Node root;
	
	/**
	 * Crée une racine à l'arbre.
	 * @param root
	 */
	public Tree (Node root) {
		this.id = root.hashCode();
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	@Override
	public String toString () {
		return "Recette :\n" + root.toString();
	}

	public Integer getId() {
		return id;
	}
}
