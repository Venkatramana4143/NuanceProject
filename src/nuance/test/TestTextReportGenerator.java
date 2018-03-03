/**
 * 
 */
package nuance.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import nuance.TextReportGenerator;
import nuance.constants.TextReportGeneratorConstants;

/**
 * @author VENKATRAMANA
 *
 */
public class TestTextReportGenerator {
	
	private TextReportGenerator textReportGenerator;
	
	// test text report data
	Map<String, Integer> expectedMap = TextReportGeneratorConstants.testDataReport();

	// testing the positive case of the input
	@Test
	public void testTextReportGenerator(){
		@SuppressWarnings("static-access")
		Map<String, Integer> map = textReportGenerator.generateTextReport(TextReportGeneratorConstants.FILEPATH);
		assertEquals(expectedMap, map);
	}
	
	// testing the failure case
	@Test
	public void testBadTextReportGenerator(){
		@SuppressWarnings("static-access")
		Map<String, Integer> map = textReportGenerator.generateTextReport(TextReportGeneratorConstants.FILEPATH2);
		assertNotEquals(expectedMap, map);
	}

}
