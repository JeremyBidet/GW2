package fr.whyt.parser;

import static fr.whyt.item.Scarcity.CHEF_D_OEUVRE;
import static fr.whyt.item.Scarcity.ELEVE;
import static fr.whyt.item.Scarcity.EXOTIQUE;
import static fr.whyt.item.Scarcity.LEGENDAIRE;
import static fr.whyt.item.Scarcity.NORMAL;
import static fr.whyt.item.Scarcity.RAFFINE;
import static fr.whyt.item.Scarcity.RARE;
import static fr.whyt.item.Type.ARME;
import static fr.whyt.item.Type.ARTISANAT;
import static fr.whyt.item.Type.CACHET;
import static fr.whyt.item.Type.COLIFICHET;
import static fr.whyt.item.Type.RUNE;
import static fr.whyt.item.TypeStat.ALTERATION;
import static fr.whyt.item.TypeStat.CRITIQUE;
import static fr.whyt.item.TypeStat.GUERISON;
import static fr.whyt.item.TypeStat.PRECISION;
import static fr.whyt.item.TypeStat.PUISSANCE;
import static fr.whyt.item.TypeStat.ROBUSTESSE;
import static fr.whyt.item.TypeStat.VITALITE;
import static fr.whyt.item.TypeWeapon.ARC_COURT;
import static fr.whyt.item.TypeWeapon.ARC_LONG;
import static fr.whyt.item.TypeWeapon.BATON;
import static fr.whyt.item.TypeWeapon.BOUCLIER;
import static fr.whyt.item.TypeWeapon.COR_DE_GUERRE;
import static fr.whyt.item.TypeWeapon.DAGUE;
import static fr.whyt.item.TypeWeapon.EPEE;
import static fr.whyt.item.TypeWeapon.ESPADON;
import static fr.whyt.item.TypeWeapon.FOCUS;
import static fr.whyt.item.TypeWeapon.FUSIL;
import static fr.whyt.item.TypeWeapon.FUSIL_HARPON;
import static fr.whyt.item.TypeWeapon.HACHE;
import static fr.whyt.item.TypeWeapon.LANCE;
import static fr.whyt.item.TypeWeapon.MARTEAU;
import static fr.whyt.item.TypeWeapon.MASSE;
import static fr.whyt.item.TypeWeapon.PISTOLET;
import static fr.whyt.item.TypeWeapon.SCEPTRE;
import static fr.whyt.item.TypeWeapon.TORCHE;
import static fr.whyt.item.TypeWeapon.TRIDENT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import fr.whyt.item.Bonus;
import fr.whyt.item.CraftMaterial;
import fr.whyt.item.Damage;
import fr.whyt.item.Item;
import fr.whyt.item.Scarcity;
import fr.whyt.item.Stat;
import fr.whyt.item.Type;
import fr.whyt.item.TypeStat;
import fr.whyt.item.TypeWeapon;
import fr.whyt.item.Weapon;

/**
 * Cette classe implémente {@link DBConnect}.<br>
 * Récupère chaque élément présent dans la base de données
 * et crée un objet le représentant.<br>
 * Les objets crées sont des {@link Weapon} ou {@link CraftMaterial} hérités de {@link Item}.<br>
 * <br>
 * @author WhyT
 *
 */
public class DataDBReader implements DBConnect {
	
	private static Pointer pointer;
	
	private static boolean isEmpty(String line) {
		return line.length() < 1;
	}
	
	private static boolean isCommentLine (String line) {
		return line.charAt(0) == '/' && line.charAt(1) == '/';
	}
	
	private static boolean isInvalid(String line) {
		return !line.startsWith("\"");
	}
	
	private static void getName (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (int quote=0; quote!=2; i++) {
			if (line.charAt(i) == '"') {
				quote++;
			} else {
				sb.append(line.charAt(i));
			}
		}
		pointer.setI(i);
		pointer.setObject(sb.toString());
	}
	
	private static void getType (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; line.charAt(i) != ' '; i++) {
			sb.append(line.charAt(i));
		}
		Type type;
		switch (sb.toString()) {
			case "ARME": type = ARME; break;
			case "ARTISANAT": type = ARTISANAT; break;
			case "CACHET": type = CACHET; break;
			case "COLIFICHET": type = COLIFICHET; break;
			case "RUNE": type = RUNE; break;
			default: type = null; break;
		}
		pointer.setI(i);
		pointer.setObject(type);
	}
	
	private static void getScarcity (String line, int i) {
		StringBuilder sb = new StringBuilder();
		for (; line.charAt(i) != ' '; i++) {
			sb.append(line.charAt(i));
		}
		Scarcity scarcity;
		switch (sb.toString()) {
			case "NORMAL": scarcity = NORMAL; break;
			case "RAFFINE": scarcity = RAFFINE; break;
			case "CHEF_D_OEUVRE": scarcity = CHEF_D_OEUVRE; break;
			case "RARE": scarcity = RARE; break;
			case "EXOTIQUE": scarcity = EXOTIQUE; break;
			case "ELEVE": scarcity = ELEVE; break;
			case "LEGENDAIRE": scarcity = LEGENDAIRE; break;
			default: scarcity = null; break;
		}
		pointer.setI(i);
		pointer.setObject(scarcity);
	}

	private static void getLevel (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; line.charAt(i) != ' '; i++) {
			sb.append(line.charAt(i));
		}
		pointer.setI(i);
		pointer.setObject(Integer.parseInt(sb.toString()));
	}
	
	private static void getPrice (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; i<line.length() && line.charAt(i) != ' '; i++) {
			sb.append(line.charAt(i));
		}
		pointer.setI(i);
		pointer.setObject(Integer.parseInt(sb.toString()));
	}
	
	private static void getSubType (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; line.charAt(i) != ' ' && line.charAt(i) != '\n'; i++) {
			sb.append(line.charAt(i));
		}
		TypeWeapon type_weapon;
		switch (sb.toString()) {
			case "ARC_COURT": type_weapon = ARC_COURT; break;
			case "ARC_LONG": type_weapon = ARC_LONG; break;
			case "BATON": type_weapon = BATON; break;
			case "BOUCLIER": type_weapon = BOUCLIER; break;
			case "COR_DE_GUERRE": type_weapon = COR_DE_GUERRE; break;
			case "DAGUE": type_weapon = DAGUE; break;
			case "EPEE": type_weapon = EPEE; break;
			case "ESPADON": type_weapon = ESPADON; break;
			case "FOCUS": type_weapon = FOCUS; break;
			case "FUSIL": type_weapon = FUSIL; break;
			case "FUSIL_HARPON": type_weapon = FUSIL_HARPON; break;
			case "HACHE": type_weapon = HACHE; break;
			case "LANCE": type_weapon = LANCE; break;
			case "MARTEAU": type_weapon = MARTEAU; break;
			case "MASSE": type_weapon = MASSE; break;
			case "PISTOLET": type_weapon = PISTOLET; break;
			case "SCEPTRE": type_weapon = SCEPTRE; break;
			case "TORCHE": type_weapon = TORCHE; break;
			case "TRIDENT": type_weapon = TRIDENT; break;
			default: type_weapon = null; break;
		}
		pointer.setI(i);
		pointer.setObject(type_weapon);
	}
	
	private static void getDamage (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; line.charAt(i) != ' ' && line.charAt(i) != '\n'; i++) {
			sb.append(line.charAt(i));
		}
		i++;
		StringBuilder sn = new StringBuilder ();
		for (; line.charAt(i) != ' ' && line.charAt(i) != '\n'; i++) {
			sn.append(line.charAt(i));
		}
		pointer.setI(i);
		pointer.setObject(new Damage(Integer.parseInt(sb.toString()), Integer.parseInt(sn.toString())));
	}
	
	private static void getBonus (String line, int i) {
		StringBuilder sb = new StringBuilder ();
		for (; line.charAt(i) != ' ' && line.charAt(i) != '\n'; i++) {
			sb.append(line.charAt(i));
		}
		StringBuilder sn = new StringBuilder ();
		for (i++; i < line.length() && line.charAt(i) != ' '; i++) {
			sn.append(line.charAt(i));
		}
		TypeStat type_stat;
		switch (sn.toString()) {
			case "PUISSANCE": type_stat = PUISSANCE; break;
			case "ROBUSTESSE": type_stat = ROBUSTESSE; break;
			case "VITALITE": type_stat = VITALITE; break;
			case "PRECISION": type_stat = PRECISION; break;
			case "GUERISON": type_stat = GUERISON; break;
			case "ALTERATION": type_stat = ALTERATION; break;
			case "CRITIQUE": type_stat = CRITIQUE; break;
			default: type_stat = null; break;
		}
		pointer.setI(i);
		pointer.setObject(new Stat(type_stat, Integer.parseInt(sb.toString())));
	}
	
	public static Set<Item> extractData () {
		if(!data.exists() || !data.canRead()) {
			return null;
		}
		Set<Item> items = new HashSet<Item>(lines(data)-50);
		try {
			BufferedReader br = new BufferedReader(new FileReader(data));
			pointer = new Pointer();
			for (String line; (line = br.readLine()) != null; ) {
				// vide, commentaire ou invalide
				if(isEmpty(line) || isCommentLine(line) || isInvalid(line)) {
					continue;
				}
				// nom
				getName(line, 0);						String name = (String)pointer.getObject();
				// type
				getType(line, pointer.getI()+1);		Type type = (Type)pointer.getObject();
				// rareté
				getScarcity(line, pointer.getI()+1);	Scarcity scarcity = (Scarcity)pointer.getObject();
				// niveau
				getLevel(line, pointer.getI()+1);		int level = (Integer)pointer.getObject();
				// prix
				getPrice(line, pointer.getI()+1);		int price = (Integer)pointer.getObject();
				TypeWeapon type_weapon = null; Damage damage = null; Bonus bonus = null;
				if(type != ARTISANAT) {
					// sous-type
					getSubType(line, pointer.getI()+1);	type_weapon = (TypeWeapon)pointer.getObject();
					// dégâts
					getDamage(line, pointer.getI()+1);	damage = (Damage)pointer.getObject();
					// bonus
					bonus = new Bonus();
					while (pointer.getI() < line.length()) {
						getBonus(line, pointer.getI()+1);	bonus.add((Stat)pointer.getObject());
					}
				}
				switch (type) {
					case ARME: items.add(new Weapon(name, scarcity, level, price, damage, bonus, type_weapon)); break;
					case ARTISANAT: items.add(new CraftMaterial(name, scarcity, level, price)); break;
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
	
	/**
	 * Compte le nombre de lignes dans un fichier.<br>
	 * Le séparateur utilisé est l'espace.<br>
	 * <br>
	 * @param file le fichier à compter.
	 * @return le nombre de lignes dans le fichier.
	 */
	private static int lines (File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int counter;
			for (counter=0; br.readLine() != null; counter++);
			br.close();
			return counter;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
