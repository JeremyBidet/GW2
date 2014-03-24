package fr.whyt.item.enums;

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
public enum AttributeType {

	POWER("Power"),
	PRECISION("Precision"),
	CONDITION_DAMAGE("ConditionDamage"),
	TOUGHNESS("Toughness"),
	VITALITY("Vitality"),
	CRITICAL_DAMAGE("CritDamage"),
	HEALING_POWER("Healing");

	private String type;

	private AttributeType(String type) {
		this.type = type;
	}

	public static AttributeType resolve(String type) {
		for (AttributeType state : AttributeType.values()) {
			if (state.type.equals(type)) {
				return state;
			}
		}
		throw new IllegalArgumentException(type);
	}
	
	public static String union() {
		StringBuilder sb = new StringBuilder();
		for(AttributeType t : AttributeType.values()) {
			sb.append(t.name()).append("|");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
}
