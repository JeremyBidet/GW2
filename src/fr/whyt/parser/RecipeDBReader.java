package fr.whyt.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import fr.whyt.craft.Node;
import fr.whyt.craft.Tree;
import fr.whyt.item.Item;

/**
 * Récupère chaque recette présente dans la base de données
 * et crée un objet approprié le représentant.<br>
 * <br>
 * @author WhyT
 *
 */
public class RecipeDBReader extends DBReader {
	
	private static void getIndent (String line, int i) {
		if(line.length() == 0) {
			pointer.setI(i);
			pointer.setObject(0);
			return;
		}
		for (; line.charAt(i) != '"'; i++);
		pointer.setI(i);
		pointer.setObject(i);
	}
	
	private static void getQuantity (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; i < line.length(); i++) {
			sb.append(line.charAt(i));
		}
		pointer.setI(i);
		pointer.setObject(Integer.parseInt(sb.toString()));
	}
	
	/**
	 * Crée les recettes à partir de la base de données.<br>
	 * La solution retenue pour créer les arbres de recettes s'exécute en deux passes :<br>
	 * <ul>
	 * 	<li>Lecture.</li>
	 * 	<li>Ecriture.</li>
	 * </ul>
	 * <h4>Lecture</h4>
	 * La phase 1, de lecture, lis intégralement de haut en bas, de gauche à droite,
	 *  la base de données, et crée pour chaque recette (ligne commençant par "..")
	 *  une sous-recette (sous-arbre) unique (ajoutée dans une {@link HashSet}<{@link Node}>),
	 *  composée de ses ingrédients.<br>
	 * Un ingrédient est identifié par une indentation (\t) en début de ligne.
	 *  Un ingrédient sans recette dans la base de données correspond à un matériau primaire
	 *  dans la recette (une feuille dans le sous-arbre).<br>
	 * Le HashSet contient alors toutes les recettes (et sous-recettes) de la base de données.
	 * <h4>Ecriture</h4>
	 * La phase 2, d'écriture, réutilise le HashSet des sous-recettes pour créer la recette complète
	 *  d'un {@link Item} à partir de sa recette racine et des sous-recettes de ses ingrédients.<br>
	 * Cette deuxième phase intervient seulement lorsque l'utilisateur demande explicitement
	 *  une recette, ceci afin de limiter la lecture de la base de données et afin d'accèlérer
	 *  la création des recettes.<br>
	 * Cela impose le calcul des quantités héritées d'une recette à la création et modification
	 *  de cette dernière.<br>
	 * <br>
	 * @param items le Set (unique) des items de la base de données
	 * @return une Set contenant les recettes et sous-recettes (arbres et sous-arbres) de la base de données
	 */
	public static Map<Integer, Tree> extractTree (Map<Integer, Item> items) {
		if(!recipe.exists() || !recipe.canRead()) {
			return null;
		}
		Map<Integer, Tree> recipes = new HashMap<Integer, Tree>(lines(recipe)-56, .90f);
		try {
			BufferedReader br = new BufferedReader(new FileReader(recipe));
			pointer = new Pointer();
			for (String line; (line = br.readLine()) != null; ) {
				/* Recette */
				// vide ou commentaire
				if(isEmpty(line) || isCommentLine(line)) continue;
				// nom
				getName(line, 0);	String name = (String)pointer.getObject();
				/* Ingrédients */
				Node[] sons = new Node[1];
				int i = 0;
				while((line = br.readLine()) != null) {
					// commentaire
					if(isCommentLine(line)) continue;
					// indentation
					getIndent(line, 0);						int indent = (Integer)pointer.getObject();
					if(indent == 0) break;
					// nom
					getName(line, pointer.getI());			String sub_name = (String)pointer.getObject();
					// quantité
					getQuantity(line, pointer.getI()+1);	int quantity = (Integer)pointer.getObject();
					if(i == sons.length) {
						sons = Arrays.copyOf(sons, sons.length+1);
					}
					Item temp = items.get(sub_name.toLowerCase().hashCode());
					sons[i++] = new Node(quantity, temp, 1);
				}
				Item temp = items.get(name.toLowerCase().hashCode());
				Node node = new Node(1, temp, 0, sons);
				Tree tree = new Tree(node);
				if(!recipes.containsKey(tree.getId())) {
					recipes.put(tree.getId(), tree);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return recipes;
	}
		
}
