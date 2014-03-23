package fr.whyt.main;

import static fr.whyt.item.Rarity.CHEF_D_OEUVRE;
import static fr.whyt.item.Rarity.NORMAL;
import static fr.whyt.item.Rarity.RAFFINE;
import static fr.whyt.item.Rarity.RARE;
import static fr.whyt.item.StatType.PUISSANCE;
import static fr.whyt.item.StatType.ROBUSTESSE;
import static fr.whyt.item.StatType.VITALITE;
import static fr.whyt.item.WeaponType.HACHE;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import fr.whyt.craft.Node;
import fr.whyt.craft.Tree;
import fr.whyt.item.Bonus;
import fr.whyt.item.CraftMaterial;
import fr.whyt.item.Currency;
import fr.whyt.item.Damage;
import fr.whyt.item.Item;
import fr.whyt.item.Stat;
import fr.whyt.item.Weapon;
import fr.whyt.parser.DataDBReader;
import fr.whyt.parser.RecipeDBReader;

public class Main {
	
	public static void main(String[] args) {
		
		/***********************************************************************************/
		System.out.println("-------------- TREE TEST START --------------\n");
		/* Crée les items de la recette */
		Item cdbs = new Weapon(
				"Couperet de bandit solide",
				RARE,
				35,
				new Currency(1, 17, 38),
				new Damage(500, 400),
				new Bonus(
						new Stat(PUISSANCE, 30),
						new Stat(ROBUSTESSE, 24),
						new Stat(VITALITE, 24)),
				HACHE);
		Item iespefs = new CraftMaterial(
				"Inscription enchantée sur plaque en fer solide",
				RARE,
				125,
				4052);
		Item pe = new CraftMaterial(
				"Petite écaille",
				RARE,
				125,
				155);
		Item gspef = new CraftMaterial(
				"Goujon sur plaque en fer",
				CHEF_D_OEUVRE,
				125,
				1025);
		Item hdhef = new CraftMaterial(
				"Hampe de hache en fer",
				RAFFINE,
				125,
				1002);
		Item ldhef = new CraftMaterial(
				"Lame de hache en fer",
				RAFFINE,
				125,
				986);
		Item ldf = new CraftMaterial(
				"Lingot de fer",
				NORMAL,
				125,
				368);
		Item mdf = new CraftMaterial(
				"Minerai de fer",
				NORMAL,
				100,
				122);
		Item pebt = new CraftMaterial(
				"Planche en bois tendre",
				NORMAL,
				125,
				432);
		Item rebs = new CraftMaterial(
				"Rondin en bois tendre",
				NORMAL,
				100,
				108);
		/* Crée l'arbre de recette */
		Tree couperet_de_bandit_solide = new Tree(
				new Node(1, cdbs, 0,
					new Node(1, iespefs, 1,
							new Node(2, gspef, 2,
									new Node(4, pebt, 3,
											new Node(16, rebs, 4)),
									new Node(6, ldf, 3,
											new Node(18, mdf, 4))),
							new Node(15, pe, 2)),
					new Node(1, hdhef, 1,
							new Node(3, ldf, 2,
									new Node(9, mdf, 3))),
					new Node(1, ldhef, 1,
							new Node(3, ldf, 2,
									new Node(9, mdf, 3)))));
		
		/* Affiche l'arbre de recette créé manuellement */
		System.out.println(couperet_de_bandit_solide.toString());
		System.out.println("-------------- TREE TEST END --------------\n\n");
		/***********************************************************************************/
		
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
		
		System.out.println("=======decode=======");
        
		  String s="[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		  Object obj=JSONValue.parse(s);
		  JSONArray array=(JSONArray)obj;
		  System.out.println("======the 2nd element of array======");
		  System.out.println(array.get(1));
		  System.out.println();
		                
		  JSONObject obj2=(JSONObject)array.get(1);
		  System.out.println("======field \"1\"==========");
		  System.out.println(obj2.get("1"));    

		                
		  s="{}";
		  obj=JSONValue.parse(s);
		  System.out.println(obj);
		                
		  s="[5,]";
		  obj=JSONValue.parse(s);
		  System.out.println(obj);
		                
		  s="[5,,2]";
		  obj=JSONValue.parse(s);
		  System.out.println(obj);
		
	}

}
