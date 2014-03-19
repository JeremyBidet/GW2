/**
 * 
 */
package fr.whyt.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jeremy
 *
 */
public abstract class DBReader implements DBConnect {
	
	protected static Pointer pointer;
	
	protected final static boolean isEmpty (String line) {
		return line.length() < 1;
	}
	
	protected final static boolean isCommentLine (String line) {
		return line.length() >= 2 && line.charAt(0) == '/' && line.charAt(1) == '/';
	}
	
	protected final static boolean isInvalid (String line) {
		return !line.startsWith("\"");
	}
	
	/**
	 * Compte le nombre de lignes dans un fichier.<br>
	 * Le séparateur utilisé est l'espace.<br>
	 * <br>
	 * @param file le fichier à compter.
	 * @return le nombre de lignes dans le fichier.
	 */
	protected final static int lines (File file) {
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
