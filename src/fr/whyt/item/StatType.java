package fr.whyt.item;

/**
 * Enumération des statistiques d'objet.<br>
 * <ul>
 * <li>PUISSANCE : puissance</li>
 * <li>ROBUSTESSE : robustesse</li>
 * <li>VITALITE : vitalité</li>
 * <li>GUERISON : guérison</li>
 * <li>CRITIQUE : dégâts critiques</li>
 * <li>PRECISION : précision</li>
 * <li>ALTERATION : dégâts d'altérations</li>
 * </ul>
 * <br>
 * @author WhyT
 *
 */
public enum StatType {

	PUISSANCE,
	ROBUSTESSE,
	VITALITE,
	GUERISON,
	CRITIQUE,
	PRECISION,
	ALTERATION;
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(StatType t : StatType.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
}
