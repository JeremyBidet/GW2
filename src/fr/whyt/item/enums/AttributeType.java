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
