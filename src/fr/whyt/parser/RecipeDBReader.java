package fr.whyt.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class RecipeDBReader implements DBReader, DBConnect {
	
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
	public static Map<Integer, Tree> extractRecipe () {
		if(!recipe.exists() || !recipe.canRead()) {
			return null;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(recipe));
			Pattern p = Pattern.compile(recipeRegExp);
			Node root = null; // Node temporaire stockant la dernière recette lue (ingrédient racine).
			for (String line; (line = br.readLine()) != null; ) {
				Matcher m = p.matcher(line);
				if(!m.matches()) continue; // ligne non valide
				String recipe = m.group("recipe");
				if(recipe == null || recipe.isEmpty()) continue; // pas de recettes : vide ou commentaire seul
				String indent = m.group("indent");
				String name = m.group("name");
				String quantity = m.group("quantity");
				if(indent.length() > 0 && root != null) { // ingrédient et recette pré-lue
					Item tmp = findItem(name); // cherche l'Item dans la map suivant son nom
					if(tmp == null) continue;
					root.addSon(new Node(
							Integer.parseInt(quantity!=null && !quantity.isEmpty() ? quantity : "1"), 
							tmp,
							1)); // on cherche l'item correspondant au nom et on l'ajoute avec sa quantité au tableau)
				} else { // recette
					if(root != null && !recipes.containsKey(root.hashCode())) { // on ajoute la dernière recette lue à la Map
						recipes.put(root.hashCode(), new Tree(root.clone()));
					}
					// on réinitialise notre recette root avec la nouvelle lue
					Item tmp = findItem(name); // cherche l'Item dans la map suivant son nom
					if(tmp == null) continue;
					root = new Node(
							Integer.parseInt(quantity!=null && !quantity.isEmpty() ? quantity : "1"), 
							tmp,
							0); // on cherche l'item correspondant au nom et on créer le Node à partir de cet Item
				}
			}
			if(root != null && !recipes.containsKey(root.hashCode())) { // on ajoute la dernière recette de la base de données à la Map
				recipes.put(root.hashCode(), new Tree(root.clone()));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return recipes;
	}

	private static Item findItem(String name) {
		Iterator<Item> it = items.values().iterator();
		while(it.hasNext()) {
			Item item = it.next();
			if(item.getName().toLowerCase().equals(name.toLowerCase())) return item;
		}
		return null;
	}
		
}
