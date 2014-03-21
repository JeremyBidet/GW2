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
 * R�cup�re chaque recette pr�sente dans la base de donn�es
 * et cr�e un objet appropri� le repr�sentant.<br>
 * <br>
 * @author WhyT
 *
 */
public class RecipeDBReader implements DBReader, DBConnect {
	
	/**
	 * Cr�e les recettes � partir de la base de donn�es.<br>
	 * La solution retenue pour cr�er les arbres de recettes s'ex�cute en deux passes :<br>
	 * <ul>
	 * 	<li>Lecture.</li>
	 * 	<li>Ecriture.</li>
	 * </ul>
	 * <h4>Lecture</h4>
	 * La phase 1, de lecture, lis int�gralement de haut en bas, de gauche � droite,
	 *  la base de donn�es, et cr�e pour chaque recette (ligne commen�ant par "..")
	 *  une sous-recette (sous-arbre) unique (ajout�e dans une {@link HashSet}<{@link Node}>),
	 *  compos�e de ses ingr�dients.<br>
	 * Un ingr�dient est identifi� par une indentation (\t) en d�but de ligne.
	 *  Un ingr�dient sans recette dans la base de donn�es correspond � un mat�riau primaire
	 *  dans la recette (une feuille dans le sous-arbre).<br>
	 * Le HashSet contient alors toutes les recettes (et sous-recettes) de la base de donn�es.
	 * <h4>Ecriture</h4>
	 * La phase 2, d'�criture, r�utilise le HashSet des sous-recettes pour cr�er la recette compl�te
	 *  d'un {@link Item} � partir de sa recette racine et des sous-recettes de ses ingr�dients.<br>
	 * Cette deuxi�me phase intervient seulement lorsque l'utilisateur demande explicitement
	 *  une recette, ceci afin de limiter la lecture de la base de donn�es et afin d'acc�l�rer
	 *  la cr�ation des recettes.<br>
	 * Cela impose le calcul des quantit�s h�rit�es d'une recette � la cr�ation et modification
	 *  de cette derni�re.<br>
	 * <br>
	 * @param items le Set (unique) des items de la base de donn�es
	 * @return une Set contenant les recettes et sous-recettes (arbres et sous-arbres) de la base de donn�es
	 */
	public static Map<Integer, Tree> extractRecipe () {
		if(!recipe.exists() || !recipe.canRead()) {
			return null;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(recipe));
			Pattern p = Pattern.compile(recipeRegExp);
			Node root = null; // Node temporaire stockant la derni�re recette lue (ingr�dient racine).
			for (String line; (line = br.readLine()) != null; ) {
				Matcher m = p.matcher(line);
				if(!m.matches()) continue; // ligne non valide
				String recipe = m.group("recipe");
				if(recipe == null || recipe.isEmpty()) continue; // pas de recettes : vide ou commentaire seul
				String indent = m.group("indent");
				String name = m.group("name");
				String quantity = m.group("quantity");
				if(indent.length() > 0 && root != null) { // ingr�dient et recette pr�-lue
					Item tmp = findItem(name); // cherche l'Item dans la map suivant son nom
					if(tmp == null) continue;
					root.addSon(new Node(
							Integer.parseInt(quantity!=null && !quantity.isEmpty() ? quantity : "1"), 
							tmp,
							1)); // on cherche l'item correspondant au nom et on l'ajoute avec sa quantit� au tableau)
				} else { // recette
					if(root != null && !recipes.containsKey(root.hashCode())) { // on ajoute la derni�re recette lue � la Map
						recipes.put(root.hashCode(), new Tree(root.clone()));
					}
					// on r�initialise notre recette root avec la nouvelle lue
					Item tmp = findItem(name); // cherche l'Item dans la map suivant son nom
					if(tmp == null) continue;
					root = new Node(
							Integer.parseInt(quantity!=null && !quantity.isEmpty() ? quantity : "1"), 
							tmp,
							0); // on cherche l'item correspondant au nom et on cr�er le Node � partir de cet Item
				}
			}
			if(root != null && !recipes.containsKey(root.hashCode())) { // on ajoute la derni�re recette de la base de donn�es � la Map
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
