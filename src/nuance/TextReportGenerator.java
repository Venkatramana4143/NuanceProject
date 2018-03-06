/**
 * 
 */
package nuance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nuance.constants.TextReportGeneratorConstants;

/**
 * @author VENKATRAMANA
 *
 */
public class TextReportGenerator {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = generateTextReport(TextReportGeneratorConstants.FILEPATH);
		LOGGER.info("Generating Text Report For Given Input File");
		map.forEach((k, v) -> System.out.printf("%-20s  %-20s\n", k, v));
	}

	@SuppressWarnings("resource")
	public static Map<String, Integer> generateTextReport(String path) {
		// scanner class to read the given input file
		Scanner scanner = null;
		try {
			LOGGER.info("Reading Input File");
			scanner = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			LOGGER.error("File not found");
			System.exit(0);
		}
		LOGGER.info("Creating Hashmap");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int population = 0;
		int count = 1;
		// checking the condition if there is next line in the input file
		while (scanner.hasNextLine()) {
			count++;
			// splitting the lines based on white space
			String[] columns = scanner.nextLine().split(
					TextReportGeneratorConstants.SPACE);
			// checking for valid grade(k-8)
			if (!columns[(columns.length - 1)]
					.matches(TextReportGeneratorConstants.REGEX)) {
				LOGGER.warn("column:" + count
						+ " data is invalid. Skipping to next line");
				continue;
			} else {
				LOGGER.info("Column:" + count
						+ " matched given regular expression");
				population = Integer.parseInt(columns[columns.length - 1]
						.substring(1));
			}
			// looping through the file columns for creating and updating the
			// hashmap
			for (int i = 0; i < columns.length - 1; i++) {
				if (map.get(columns[i]) == null) {
					map.put(columns[i], population);
				} else {
					map.put(columns[i], (map.get(columns[i]) + population));
				}
			}
			LOGGER.debug("Looping through input file columns");
		}
		// sorting the hashmap based on values
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		LOGGER.info("Sorting Unsorted Map Based On Values");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		LOGGER.info("Returning Sorted Map");
		return sortedMap;
	}

}
