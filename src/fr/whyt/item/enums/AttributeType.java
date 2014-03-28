package fr.whyt.item.enums;

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
public enum AttributeType {

	POWER("Power"),
	PRECISION("Precision"),
	CONDITION_DAMAGE("ConditionDamage"),
	TOUGHNESS("Toughness"),
	VITALITY("Vitality"),
	CRITICAL_DAMAGE("CritDamage"),
	HEALING_POWER("Healing");

	private String name;

	private AttributeType(String name) {
		this.name = name;
	}

	public static AttributeType resolve(String name) {
		for (AttributeType state : AttributeType.values()) {
			if (state.name.equals(name)) {
				return state;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
