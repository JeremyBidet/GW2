package fr.whyt.parser;

import static fr.whyt.item.Rarity.CHEF_D_OEUVRE;
import static fr.whyt.item.Rarity.ELEVE;
import static fr.whyt.item.Rarity.EXOTIQUE;
import static fr.whyt.item.Rarity.LEGENDAIRE;
import static fr.whyt.item.Rarity.NORMAL;
import static fr.whyt.item.Rarity.RAFFINE;
import static fr.whyt.item.Rarity.RARE;
import static fr.whyt.item.StatType.ALTERATION;
import static fr.whyt.item.StatType.CRITIQUE;
import static fr.whyt.item.StatType.GUERISON;
import static fr.whyt.item.StatType.PRECISION;
import static fr.whyt.item.StatType.PUISSANCE;
import static fr.whyt.item.StatType.ROBUSTESSE;
import static fr.whyt.item.StatType.VITALITE;
import static fr.whyt.item.Type.ARME;
import static fr.whyt.item.Type.ARTISANAT;
import static fr.whyt.item.Type.CACHET;
import static fr.whyt.item.Type.COLIFICHET;
import static fr.whyt.item.Type.RUNE;
import static fr.whyt.item.WeaponType.ARC_COURT;
import static fr.whyt.item.WeaponType.ARC_LONG;
import static fr.whyt.item.WeaponType.BATON;
import static fr.whyt.item.WeaponType.BOUCLIER;
import static fr.whyt.item.WeaponType.COR_DE_GUERRE;
import static fr.whyt.item.WeaponType.DAGUE;
import static fr.whyt.item.WeaponType.EPEE;
import static fr.whyt.item.WeaponType.ESPADON;
import static fr.whyt.item.WeaponType.FOCUS;
import static fr.whyt.item.WeaponType.FUSIL;
import static fr.whyt.item.WeaponType.FUSIL_HARPON;
import static fr.whyt.item.WeaponType.HACHE;
import static fr.whyt.item.WeaponType.LANCE;
import static fr.whyt.item.WeaponType.MARTEAU;
import static fr.whyt.item.WeaponType.MASSE;
import static fr.whyt.item.WeaponType.PISTOLET;
import static fr.whyt.item.WeaponType.SCEPTRE;
import static fr.whyt.item.WeaponType.TORCHE;
import static fr.whyt.item.WeaponType.TRIDENT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.whyt.item.Bonus;
import fr.whyt.item.CraftMaterial;
import fr.whyt.item.Damage;
import fr.whyt.item.Item;
import fr.whyt.item.Rarity;
import fr.whyt.item.Stat;
import fr.whyt.item.StatType;
import fr.whyt.item.Type;
import fr.whyt.item.Weapon;
import fr.whyt.item.WeaponType;

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
			case "ARME": return ARME;
			case "ARTISANAT": return ARTISANAT;
			case "CACHET": return CACHET;
			case "COLIFICHET": return COLIFICHET;
			case "RUNE": return RUNE;
			default: return null;
		}
	}
	
	private static Rarity getScarcity (String scarcity) {
		switch (scarcity.toUpperCase()) {
			case "NORMAL": return NORMAL;
			case "RAFFINE": return RAFFINE;
			case "CHEF_D_OEUVRE": return CHEF_D_OEUVRE;
			case "RARE": return RARE;
			case "EXOTIQUE": return EXOTIQUE;
			case "ELEVE": return ELEVE;
			case "LEGENDAIRE": return LEGENDAIRE;
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
			String type = m.group("type"); // to StatType
			String s_value = m.group("value"); // to int
			StatType stattype;
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
					case ARME:
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
					case ARTISANAT:
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
