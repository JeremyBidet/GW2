package fr.whyt.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dao.OfflineJsonDao;
import cz.zweistein.gw2.api.dao.OnlineJsonDao;
import cz.zweistein.gw2.api.transformer.JSONToJavaTransformer;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

//		System.out.println("-------------- ITEMS MAP START --------------\n");
//		/* Récupère les items depuis la base de données */
//		Map<Integer, Item> items = DataDBReader.extractData();
//		System.out.println(items.toString());
//		System.out.println("-------------- ITEMS MAP END --------------\n\n");
//		
//		System.out.println("-------------- RECIPES MAP START --------------\n");
//		/* Récupère les recettes depuis la base de données */
//		Map<Integer, Tree> recipes = RecipeDBReader.extractRecipe();
//		System.out.println(recipes.toString());
//		System.out.println("-------------- RECIPES MAP END --------------\n\n");
		
		GW2API api = new GW2API();
		JSONToJavaTransformer transformer = new JSONToJavaTransformer();
		
		api.setDao(new OfflineJsonDao());
		
		try {
			JSONObject items = (JSONObject) new JSONParser().parse(
					new InputStreamReader(
							new FileInputStream(
									new File("res/items.json")), 
									Charset.forName("UTF16")));
			JSONObject obj = new JSONObject();
			Set<String> ids = items.keySet();
			List<Long> result = new ArrayList<Long>(ids.size());
			for (String object : ids) {
				result.add(Long.valueOf(object));
			}
			obj.put("items", result);
			//
		} catch (IOException | ParseException e) {
			Logger.getGlobal().log(null, e.toString());
		}
		
	}

}
