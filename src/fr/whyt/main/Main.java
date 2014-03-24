package fr.whyt.main;

import java.util.Map;

import fr.whyt.craft.Tree;
import fr.whyt.item.Item;
import fr.whyt.parser.DataDBReader;
import fr.whyt.parser.RecipeDBReader;

public class Main {
	
	public static void main(String[] args) {

		System.out.println("-------------- ITEMS MAP START --------------\n");
		/* Récupère les items depuis la base de données */
		Map<Integer, Item> items = DataDBReader.extractData();
		System.out.println(items.toString());
		System.out.println("-------------- ITEMS MAP END --------------\n\n");
		
		System.out.println("-------------- RECIPES MAP START --------------\n");
		/* Récupère les recettes depuis la base de données */
		Map<Integer, Tree> recipes = RecipeDBReader.extractRecipe();
		System.out.println(recipes.toString());
		System.out.println("-------------- RECIPES MAP END --------------\n\n");
		
	}

}
