/**
 * 
 */
package nuance.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VENKATRAMANA
 *
 */
public class TextReportGeneratorConstants {

	// constant variable for whitespace
	public static final String SPACE = " ";
	// regular expression to match grade and population value in the file
	public static final String REGEX = "^[K(1-8)][0-9]+$";

	public static final String FILEPATH = "C:/Users/VENKATRAMANA/workspace/NuanceAssignment/src/nuance/utils/nuance.txt";
	public static final String FILEPATH2 = "C:/Users/VENKATRAMANA/workspace/NuanceAssignment/src/nuance/utils/badInput.txt";

	public static Map<String, Integer> testDataReport() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Kitchener", 108);
		map.put("School3", 108);
		map.put("School2", 3000);
		map.put("School1", 3000);
		map.put("Waterloo", 6000);
		map.put("ON", 6108);
		return map;

	}

}
