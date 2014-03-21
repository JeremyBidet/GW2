package fr.whyt.item;

/**
 * Enum�ration des statistiques d'objet.<br>
 * <ul>
 * <li>PUISSANCE : puissance</li>
 * <li>ROBUSTESSE : robustesse</li>
 * <li>VITALITE : vitalit�</li>
 * <li>GUERISON : gu�rison</li>
 * <li>CRITIQUE : d�g�ts critiques</li>
 * <li>PRECISION : pr�cision</li>
 * <li>ALTERATION : d�g�ts d'alt�rations</li>
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
