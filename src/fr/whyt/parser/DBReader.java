/**
 * 
 */
package fr.whyt.parser;

import java.util.HashMap;
import java.util.Map;

import fr.whyt.item.Item;


/**
 * @author Jeremy
 *
 */
public interface DBReader {
	
	/* 	  <gname>	<#pgname>	<#gname>			<description>
	 * _all							0		zero or one <item> and zero or one <comment>
	 * item				0			1		? : zero or one <<crafmaterial> <weapon>>
	 * craftmaterial	1			2		? : zero or one <"<name>" <type> <scarcity> <level> <price>>
	 * name				2			3		.+ : one or more any characters
	 * type				2			4		.+ : one or more any word characters
	 * scarcity			2			5		.+ : one or more any word characters
	 * level			2			6		\d+ : one or more any digits
	 * price			2			7		\d+ : one or more any digits
	 * weapon			1			8		? : zero or one < <weapontype> <highdamage><- ><lowdamage> <bonus>>
	 * weapontype		8			9		.+ : one or more any word characters
	 * highdamage		8		   10		\d+ : one or more any digits
	 * lowdamage		8		   11		\d+ : one or more any digits
	 * bonus			8		   12		* : zero or more <<bonusvalue> <bonustype><zero or one < >>>
	 * bonusvalue	   12		   13		\d+ : one or more any digits
	 * bonustype	   12		   14		.+ : one or more any word characters end with blank space
	 * comment			0		   15		? : zero or one <\s*<content>>
	 * content		   15		   16		//.* : zero or one <// and zero or more any characters>
	 **
	 * gname : group name
	 * #pgname : parent group name number
	 * #gname : group name number
	 * description : group feature description
	 */
	public final String dataRegExp = 
			"(?<item>(?<craftmaterial>\"(?<name>.+)\" (?<type>\\w+) (?<scarcity>\\w+) (?<level>\\d+) (?<price>\\d+))"
			+ "(?<weapon> (?<weapontype>\\w+) (?<lowdamage>\\d+)[- ](?<highdamage>\\d+) (?<bonus>(?<bonusvalue>\\d+) (?<bonustype>\\w+)[ ]?)*)?)?"
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
			"(?<recipe>(?<indent>\t?)\"(?<name>.+)\"\\s*(?<quantity>\\d*))?"
			+ "(?<comment>\\s*(?<content>//.*)?)?";
	
	public Map<Integer, Item> items = new HashMap<Integer, Item>(10, .90f);
	
}
