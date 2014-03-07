package fr.whyt.parser;

import java.io.File;

/**
 * Interface donnant les diff�rents fichiers de la base de donn�es.<br>
 * Notemment <i>data.db</i> et <i>recipe.db</i>.<br>
 * <br>
 * @author WhyT
 *
 */
public interface DBConnect {

	public final File data = new File("db/data.db");
	public final File recipe = new File("db/recipe.db");
	
}
