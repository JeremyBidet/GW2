package fr.whyt.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
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
public class RecipeDBReader extends DBReader {
	
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
	public static Map<Integer, Tree> extractTree (Map<Integer, Item> items) {
		if(!recipe.exists() || !recipe.canRead()) {
			return null;
		}
		Map<Integer, Tree> recipes = new HashMap<Integer, Tree>(10, .90f);
		try {
			BufferedReader br = new BufferedReader(new FileReader(recipe));
			/* <gname>		<#pgname>	<#gname>	<description>
			 * _all							0		zero or one <recipe> and zero or one <comment>
			 * recipe			0			1		? : zero or one <- <indent>"<name>"\s*<quantity> ->
			 * indent			1			2		\t? : zero or one indent \t 
			 * name				1			3		.+ : one or more of any characters
			 * quantity			1			4		\d* : zero or more of any digits
			 * comment			0			5		? : zero or one \s*<content>
			 * content			5			6		//.* : zero or one <- // and zero or more any characters ->
			 **
			 * gname : group name,
			 * #pgname : number of parent group name,
			 * #gname : number of group name,
			 * description : description of group feature
			 */
			String regex = "(?<recipe>(?<indent>\t?)\"(?<name>.+)\"\\s*(?<quantity>\\d*))?(?<comment>\\s*(?<content>//.*)?)?";
			Pattern p = Pattern.compile(regex);
			Node root = null; // Node temporaire stockant la derni�re recette lue (ingr�dient racine).
			for (String line; (line = br.readLine()) != null; ) {
				Matcher m = p.matcher(line);
				if(!m.matches()) continue; // ligne non valide
				System.out.println(
						"group 0 total : \"" + m.group() + "\"\n"
						+ "group 1 recipe : \"" + m.group("recipe") + "\"\n"
						+ "group 2 indent : \"" + m.group("indent") + "\"\n"
						+ "group 3 name : \"" + m.group("name") + "\"\n"
						+ "group 4 quantity : \"" + m.group("quantity") + "\"\n"
						+ "group 5 comment : \"" + m.group("comment") + "\"\n"
						+ "group 6 content : \"" + m.group("content") + "\"\n");
				
				String recipe = m.group("recipe");
				if(recipe == null || recipe.isEmpty()) continue; // pas de recettes : vide ou commentaire seul
				
				String indent = m.group("indent");
				String name = m.group("name");
				String quantity = m.group("quantity");
				
				if(indent.length() > 0 && root != null) { // ingr�dient et recette pr�-lue
					Item tmp = items.get(name.toLowerCase().hashCode());
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
					Item tmp = items.get(name.toLowerCase().hashCode());
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
		
}
