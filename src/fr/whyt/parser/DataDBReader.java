package fr.whyt.parser;

import static fr.whyt.item.enums.Type.ARMOR;
import static fr.whyt.item.enums.Type.BACK;
import static fr.whyt.item.enums.Type.BAG;
import static fr.whyt.item.enums.Type.CONSUMABLE;
import static fr.whyt.item.enums.Type.CONTAINER;
import static fr.whyt.item.enums.Type.CRAFTMATERIAL;
import static fr.whyt.item.enums.Type.GATHERING;
import static fr.whyt.item.enums.Type.GIZMO;
import static fr.whyt.item.enums.Type.MINIPET;
import static fr.whyt.item.enums.Type.TOOL;
import static fr.whyt.item.enums.Type.TRINKET;
import static fr.whyt.item.enums.Type.TROPHY;
import static fr.whyt.item.enums.Type.UPGRADE_COMPONENT;
import static fr.whyt.item.enums.Type.WEAPON;
import static fr.whyt.item.enums.Rarity.BASIC;
import static fr.whyt.item.enums.Rarity.FINE;
import static fr.whyt.item.enums.Rarity.MASTERWORK;
import static fr.whyt.item.enums.Rarity.RARE;
import static fr.whyt.item.enums.Rarity.EXOTIC;
import static fr.whyt.item.enums.Rarity.ASCENDED;
import static fr.whyt.item.enums.Rarity.LEGENDARY;
import static fr.whyt.item.enums.Rarity.JUNK;
import static fr.whyt.item.enums.WeaponType.AXE;
//import static fr.whyt.item.enums.WeaponType.BAG;
import static fr.whyt.item.enums.WeaponType.BULK;
import static fr.whyt.item.enums.WeaponType.COMPONENT;
//import static fr.whyt.item.enums.WeaponType.CONSUMABLE;
import static fr.whyt.item.enums.WeaponType.DAGGER;
import static fr.whyt.item.enums.WeaponType.DESSERT;
import static fr.whyt.item.enums.WeaponType.DYE;
import static fr.whyt.item.enums.WeaponType.EARRING;
import static fr.whyt.item.enums.WeaponType.FEAST;
import static fr.whyt.item.enums.WeaponType.FOCUS;
import static fr.whyt.item.enums.WeaponType.GREATSWORD;
import static fr.whyt.item.enums.WeaponType.HAMMER;
import static fr.whyt.item.enums.WeaponType.HARPOON;
import static fr.whyt.item.enums.WeaponType.INGREDIENT_COOKING;
import static fr.whyt.item.enums.WeaponType.INSCRIPTION;
import static fr.whyt.item.enums.WeaponType.INSIGNIA;
import static fr.whyt.item.enums.WeaponType.LONGBOW;
import static fr.whyt.item.enums.WeaponType.MACE;
import static fr.whyt.item.enums.WeaponType.MEAL;
import static fr.whyt.item.enums.WeaponType.PISTOL;
import static fr.whyt.item.enums.WeaponType.POTION;
import static fr.whyt.item.enums.WeaponType.REFINEMENT;
import static fr.whyt.item.enums.WeaponType.RIFLE;
import static fr.whyt.item.enums.WeaponType.SCEPTER;
import static fr.whyt.item.enums.WeaponType.SEASONING;
import static fr.whyt.item.enums.WeaponType.SHIELD;
import static fr.whyt.item.enums.WeaponType.SHORTBOW;
import static fr.whyt.item.enums.WeaponType.SNACK;
import static fr.whyt.item.enums.WeaponType.SOUP;
import static fr.whyt.item.enums.WeaponType.SPEARGUN;
import static fr.whyt.item.enums.WeaponType.STAFF;
import static fr.whyt.item.enums.WeaponType.SWORD;
import static fr.whyt.item.enums.WeaponType.TORCH;
import static fr.whyt.item.enums.WeaponType.TOY;
import static fr.whyt.item.enums.WeaponType.TRIDENT;
import static fr.whyt.item.enums.WeaponType.TWO_HANDED_TOY;
//import static fr.whyt.item.enums.WeaponType.UPGRADE_COMPONENT;
import static fr.whyt.item.enums.WeaponType.WARHORN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.whyt.item.Item;
import fr.whyt.item.components.Damage;
import fr.whyt.item.enums.AttributeType;
import fr.whyt.item.enums.Rarity;
import fr.whyt.item.enums.Type;
import fr.whyt.item.enums.WeaponType;
import fr.whyt.item.extend.CraftMaterial;
import fr.whyt.item.extend.Weapon;

/**
 * Cette classe implémente {@link DBConnect}.<br>
 * Récupère chaque élément présent dans la base de données
 * et crée un objet le représentant.<br>
 * Les objets crées sont des {@link Weapon} ou {@link CraftMaterial} hérités de {@link Item}.<br>
 * <br>
 * @author WhyT
 *
 */
public class DataDBReader implements DBReader, DBConnect {
	
	private static Type getType (String type) {
		switch (type.toUpperCase()) {
			case "ARME": return WEAPON;
			case "ARTISANAT": return CRAFTMATERIAL;
			default: return null;
		}
	}
	
	private static Rarity getScarcity (String scarcity) {
		switch (scarcity.toUpperCase()) {
			case "BASIC": return BASIC;
			case "FINE": return FINE;
			case "MASTERWORK": return MASTERWORK;
			case "RARE": return RARE;
			case "EXOTIC": return EXOTIC;
			case "ASCENDED": return ASCENDED;
			case "LEGENDARY": return LEGENDARY;
			case "JUNK": return JUNK;
			default: return null;
		}
	}

	private static WeaponType getWeaponType (String weapontype) {
		switch (weapontype.toUpperCase()) {
			case "ARC_COURT": return ARC_COURT;
			case "ARC_LONG": return ARC_LONG;
			case "BATON": return BATON;
			case "BOUCLIER": return BOUCLIER;
			case "COR_DE_GUERRE": return COR_DE_GUERRE;
			case "DAGUE": return DAGUE;
			case "EPEE": return EPEE;
			case "ESPADON": return ESPADON;
			case "FOCUS": return FOCUS;
			case "FUSIL": return FUSIL;
			case "FUSIL_HARPON": return FUSIL_HARPON;
			case "HACHE": return HACHE;
			case "LANCE": return LANCE;
			case "MARTEAU": return MARTEAU;
			case "MASSE": return MASSE;
			case "PISTOLET": return PISTOLET;
			case "SCEPTRE": return SCEPTRE;
			case "TORCHE": return TORCHE;
			case "TRIDENT": return TRIDENT;
			default: return null;
		}
	}
	
	private static Bonus getBonus (String s_bonus) {
		Stat[] bonus = new Stat[0];
		String regex = "(?<bonus>(?<value>\\d+) (?<type>\\w+)[ ]?)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s_bonus);
		while(m.find()) {
			String type = m.group("type"); // to AttributeType
			String s_value = m.group("value"); // to int
			AttributeType stattype;
			switch (type.toUpperCase()) {
				case "PUISSANCE": stattype = PUISSANCE; break;
				case "ROBUSTESSE": stattype = ROBUSTESSE; break;
				case "VITALITE": stattype = VITALITE; break;
				case "PRECISION": stattype = PRECISION; break;
				case "GUERISON": stattype = GUERISON; break;
				case "ALTERATION": stattype = ALTERATION; break;
				case "CRITIQUE": stattype = CRITIQUE; break;
				default: stattype = null; break;
			}
			int value = Integer.parseInt(s_value != null && !s_value.isEmpty() ? s_value : "0");
			bonus = Arrays.copyOf(bonus, bonus.length+1);
			bonus[bonus.length-1] = new Stat(stattype, value);
		}
		return new Bonus(bonus);
	}

	public static Map<Integer, Item> extractData () {
		if(!data.exists() || !data.canRead()) {
			return null;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(data));
			Pattern p = Pattern.compile(dataRegExp);
			for (String line; (line = br.readLine()) != null; ) {
				Matcher m = p.matcher(line);
				if(!m.matches()) continue; // ligne non valide
				String item = m.group("item");
				if(item == null || item.isEmpty()) continue; // ligne vide ou commentaire
				String name = m.group("name");
				Type type = getType(m.group("type"));
				Rarity rarity = getScarcity(m.group("scarcity"));
				int level = Integer.parseInt(m.group("level"));
				int price = Integer.parseInt(m.group("price"));
				switch (type) {
					case WEAPON:
						WeaponType weapontype = getWeaponType(m.group("weapontype"));
						Damage damage = new Damage(
								Integer.parseInt(m.group("highdamage")), 
								Integer.parseInt(m.group("lowdamage")));
						Bonus bonus = getBonus(m.group("bonuslist"));
						Item new_weapon = new Weapon(name, rarity, level, price, damage, bonus, weapontype);
						if(!items.containsKey(new_weapon.getId())) {
							items.put(new_weapon.getId(), new_weapon);
						}
						break;
					case CRAFTMATERIAL:
						Item new_craft_material = new CraftMaterial(name, rarity, level, price);
						if(!items.containsKey(new_craft_material.getId())) {
							items.put(new_craft_material.getId(), new_craft_material);
						}
						break;
					default: break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
}
