package fr.whyt.persona.enums;

public enum Restriction {

	ASURA("Asura"),
	HUMAN("Human"),
	NORN("Norn"),
	CHARR("Charr"),
	SYLVARI("Sylvari"),
	GUARDIAN("Guardian"),
	WARRIOR("Warrior");

	private String name;

	private Restriction(String name) {
		this.name = name;
	}

	public static Restriction resolve(String name) {
		for (Restriction state : Restriction.values()) {
			if (state.name.equals(name)) {
				return state;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
