/**
 * 
 */
package fr.whyt.parser;

import java.util.HashMap;
import java.util.Map;

import fr.whyt.craft.Tree;
import fr.whyt.item.Item;
import fr.whyt.item.Scarcity;
import fr.whyt.item.StatType;
import fr.whyt.item.Type;
import fr.whyt.item.WeaponType;


/**
 * @author WhyT
 *
 */
public interface DBReader {
	
	/* 	  <gname>	<#pgname>	<#gname>			<description>
	 * _all							0		zero or one <item> and zero or one <comment>
	 * item				0			1		? : zero or one full item : <crafmaterial> <weapon>
	 * craftmaterial	1			2		? : zero or one simple item : "<name>" <type> <scarcity> <level> <price>
	 * name				2			3		.+ : one or more any characters
	 * type				2			4		.+ : one or more any word characters
	 * scarcity			2			5		.+ : one or more any word characters
	 * level			2			6		\d+ : one or more any digits
	 * price			2			7		\d+ : one or more any digits
	 * weapon			1			8		? : zero or one weapon : <weapontype> <highdamage><one - or white space><lowdamage> <bonus>
	 * weapontype		8			9		.+ : one or more any word characters
	 * lowdamage		8		   10		\d+ : one or more any digits
	 * highdamage		8		   11		\d+ : one or more any digits
	 * bonuslist		8		   12		
	 * bonus		   12		   13		* : zero or more bonus : <bonusvalue> <bonustype><zero or one white space>
	 * bonusvalue	   13		   14		\d+ : one or more any digits
	 * bonustype	   13		   15		.+ : one or more any word characters
	 * comment			0		   16		? : zero or one comment : <zero or more space><content>
	 * content		   15		   17		//.* : zero or one comment line : <//><zero or more any characters>
	 **
	 * gname : group name
	 * #pgname : parent group name number
	 * #gname : group name number
	 * description : group feature description
	 */
	public final String dataRegExp = 
			"(?<item>"
				+ "(?<craftmaterial>\""
					+ "(?<name>.+)\" "
					+ "(?<type>(?i)" + Type.union() + ") "
					+ "(?<scarcity>(?i)" + Scarcity.union() + ") "
					+ "(?<level>\\d+) "
					+ "(?<price>\\d+))"
				+ "(?<weapon> "
					+ "(?<weapontype>(?i)" + WeaponType.union() + ") "
					+ "(?<lowdamage>\\d+)[- ](?<highdamage>\\d+) "
					+ "(?<bonuslist>"
						+ "(?<bonus>"
							+ "(?<bonusvalue>\\d+) "
							+ "(?<bonustype>(?i)" + StatType.union() + ")[ ]?)*))?)?"
			+ "(?<comment>\\s*(?<content>//.*)?)?";
	
	/*
	 * <gname>		<#pgname>	<#gname>	<description>
	 * _all							0		zero or one <recipe> and zero or one <comment>
	 * recipe			0			1		? : zero or one <<indent>"<name>"\s*<quantity>>
	 * indent			1			2		\t? : zero or one indent <\t> 
	 * name				1			3		.+ : one or more of any characters
	 * quantity			1			4		\d* : zero or more of any digits
	 * comment			0			5		? : zero or one <\s*<content>>
	 * content			5			6		//.* : zero or one <// and zero or more any characters>
	 **
	 * gname : group name,
	 * #pgname : parent group name number,
	 * #gname : group name number,
	 * description : group feature description
	 */
	public final String recipeRegExp = 
			"(?<recipe>"
				+ "(?<indent>\t?)\""
					+ "(?<name>.+)\""
					+ "\\s*"
					+ "(?<quantity>\\d*))?"
			+ "(?<comment>\\s*(?<content>//.*)?)?";
	
	
	/*
	 * Maps uniques des Item et Recipe : Hashcode = ID
	 */
	public Map<Integer, Item> items = new HashMap<Integer, Item>(10, .90f);
	public Map<Integer, Tree> recipes = new HashMap<Integer, Tree>(10, .90f);
	
}
