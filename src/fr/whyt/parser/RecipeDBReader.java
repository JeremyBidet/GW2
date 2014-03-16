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
 * R�cup�re chaque recette pr�sente dans la base de donn�es
 * et cr�e un objet appropri� le repr�sentant.<br>
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
				/* Ingr�dients */
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
					// quantit�
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
