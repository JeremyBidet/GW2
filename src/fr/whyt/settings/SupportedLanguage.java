package fr.whyt.settings;

/**
 * Enum of supported languages in API.<br>
 * Used to translate data from db API into JSON files.<br>
 * <ul>
 * <li>ENGLISH("en")</li>
 * <li>DEUTCH("de")</li>
 * <li>FRENCH("fr")</li>
 * <li>SPANNISH("es")</li>
 * </lu>
 * <br><br>
 * @author WhyT
 *
 */
public enum SupportedLanguage {

	ENGLISH("en"), DEUTCH("de"), FRENCH("fr"), SPANNISH("es");

	private final String code;

	private SupportedLanguage(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	public static SupportedLanguage resolve(String code) {
		for (SupportedLanguage lang : SupportedLanguage.values()) {
			if (lang.code.equals(code)) {
				return lang;
			}
		}
		return FRENCH;
	}

}
