package fr.whyt.parser;

/**
 * Permet de créer un pointeur sur la position actuelle du curseur<br>
 * et de renvoyer l'objet analysé par le pointeur.<br>
 * <br>
 * @author WhyT
 *
 */
public class Pointer {
	private int i;
	private Object str;
	
	public Pointer() {
		this.i = 0;
		this.str = null;
	}
	
	public Pointer(int i, Object str) {
		this.i = i;
		this.str = str;
	}

	public int getI() {
		return i;
	}

	public Object getObject() {
		return str;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public void setObject(Object str) {
		this.str = str;
	}
}
