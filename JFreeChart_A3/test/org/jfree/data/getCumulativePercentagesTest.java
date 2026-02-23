package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getCumulativePercentagesTest {
	
	private DefaultKeyedValues exampleValues;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}
	
	@BeforeEach
	void setUp() throws Exception {
		exampleValues = new DefaultKeyedValues();
		exampleValues.addValue(Double.valueOf(0), 5);
		exampleValues.addValue(Double.valueOf(1), 9);
		exampleValues.addValue(Double.valueOf(2), 2);
	}
	
//	All valid values - doesn't throw an exception
	@Test
	void validValues() {
		assertDoesNotThrow(() -> {
			DataUtilities.getCumulativePercentages(exampleValues);
	    });
	}
//	Null data values - does not throw an exception
	@Test
	void nullValues() {
		DefaultKeyedValues nullValues = new DefaultKeyedValues();
		nullValues.addValue(Double.valueOf(0), null);
		nullValues.addValue(Double.valueOf(1), null);
		nullValues.addValue(Double.valueOf(2), null);
		
		assertDoesNotThrow(() -> {
			DataUtilities.getCumulativePercentages(nullValues);
	    });
	}
	
//  One null data value - does not throw an exception
	@Test
	void oneNullValue() {
		DefaultKeyedValues validValues = new DefaultKeyedValues();
		validValues.addValue(Double.valueOf(0), 5);
		validValues.addValue(Double.valueOf(1), null);
		validValues.addValue(Double.valueOf(2), 9);
		
		assertDoesNotThrow(() -> {
			DataUtilities.getCumulativePercentages(validValues);
	    });
	}
	
// 	Null key values - throws the IllegalArgumentException
	@Test
	void nullKeyValues() {
		DefaultKeyedValues invalidValues = new DefaultKeyedValues();
		invalidValues.addValue(null, 5);
		invalidValues.addValue(null, 9);
		invalidValues.addValue(null, 2);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DataUtilities.getCumulativePercentages(invalidValues);
	    });	
		
		String expectedMessage = "Null 'key' argument.";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
//	All valid values - using data from documentation to check for correct mathematical result
	@Test
	void documentationValues() {
		double value0 = 0.3125;
		double value1 = 0.875;
		double value2 = 1.0;
		
		KeyedValues result = DataUtilities.getCumulativePercentages(exampleValues);
		assertAll("Cumulative Percentages",
		() -> assertEquals(value0, result.getValue(0).doubleValue(), 0.0001),	
		() -> assertEquals(value1, result.getValue(1).doubleValue(), 0.001),
		() -> assertEquals(value2, result.getValue(2).doubleValue(), 0.1)
				);
	}

//	All valid values - using new numbers to check for correct mathematical result 
	@Test
	void newValues() {
		DefaultKeyedValues newValues = new DefaultKeyedValues();
		newValues.addValue(Double.valueOf(0), 10);
		newValues.addValue(Double.valueOf(1), 2);
		newValues.addValue(Double.valueOf(2), 7);
		newValues.addValue(Double.valueOf(3), 9);
		
		double value0 = 0.357;
		double value1 = 0.429;
		double value2 = 0.679;
		double value3 = 1.0;
		
		KeyedValues result = DataUtilities.getCumulativePercentages(newValues);
		assertAll("Cumulative Percentages",
				() -> assertEquals(value0, result.getValue(0).doubleValue(), 0.001),	
				() -> assertEquals(value1, result.getValue(1).doubleValue(), 0.001),
				() -> assertEquals(value2, result.getValue(2).doubleValue(), 0.001),
				() -> assertEquals(value3, result.getValue(3).doubleValue(), 0.1)
						);
	}

//	All valid values - testing loops to handle data with only one KeyedValue
	@Test
	void oneValidValue() {
		DefaultKeyedValues oneValue = new DefaultKeyedValues();
		oneValue.addValue(Double.valueOf(0), 10);
		
		assertDoesNotThrow(() -> {
			DataUtilities.getCumulativePercentages(oneValue);
	    });
		
	}
	
// 	All valid values - testing to check for correct mathematical result when KeyedValue has a length of one
	@Test
	void oneValidResult() {
		DefaultKeyedValues oneValue = new DefaultKeyedValues();
		oneValue.addValue(Double.valueOf(0), 10);
		
		double value0 = 1.0;
		
		KeyedValues result = DataUtilities.getCumulativePercentages(oneValue);
		assertEquals(value0, result.getValue(0).doubleValue(), 0.1);
		
	}

//	All null values - check for correct mathematical result
	@Test
	void nullValuesResult() {
		DefaultKeyedValues nullResults = new DefaultKeyedValues();
		nullResults.addValue(Double.valueOf(0), null);
		nullResults.addValue(Double.valueOf(1), null);
		nullResults.addValue(Double.valueOf(2), null);
		
		assertAll("Cumulative Percentages",
			() -> assertNull(nullResults.getValue(0)),
			() -> assertNull(nullResults.getValue(1)),
			() -> assertNull(nullResults.getValue(2))
				);
	}
	
//	One null value - check for correct mathematical result
	@Test
	void oneNullValueResult() {
		DefaultKeyedValues oneNullResult = new DefaultKeyedValues();
		oneNullResult.addValue(Double.valueOf(0), 2);
		oneNullResult.addValue(Double.valueOf(1), null);
		oneNullResult.addValue(Double.valueOf(2), 10);
		
		double value0 = 0.167;
		double value1 = 0.167;
		double value2 = 1.0;
		
		KeyedValues result = DataUtilities.getCumulativePercentages(oneNullResult);
		assertAll("Cumulative Percentages",
				() -> assertEquals(value0, result.getValue(0).doubleValue(), 0.001),
				() -> assertEquals(value1, result.getValue(1).doubleValue(), 0.001),
				() -> assertEquals(value2, result.getValue(2).doubleValue(), 0.1)
				);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}




}
