package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import static org.jfree.data.DataUtilities.createNumberArray;

import org.junit.jupiter.api.Test;

class CreateNumberArrayTest {

	@Test
	void testValidValue() {
		double[] values = {1.0};
		Number[] testArray = createNumberArray(values);
		
		assertEquals(1.0, testArray[0]);
	}

	@Test
	void testNullValue() {
		double[] values = null;
		
	    assertThrows(InvalidParameterException.class, () -> {
			createNumberArray(values);
	    });
	}
	
	@Test
	void testEmptyValue() {
		double[] values = {};
		Number[] testArray = createNumberArray(values);
		
		assertEquals(0, testArray.length);
	}
	
	@Test
	void testMultipleValue() {
		double[] values = {1.0,2.0,3.0,4.0};
		Number[] testArray = createNumberArray(values);
		
		assertEquals(1.0, testArray[0]);
		assertEquals(2.0, testArray[1]);
		assertEquals(3.0, testArray[2]);
		assertEquals(4.0, testArray[3]);
	}
	
	@Test
	void testNegativeValues() {
		double[] values = {-1.0,-2.0,-3.0,4.0};
		Number[] testArray = createNumberArray(values);
		
		assertEquals(-1.0, testArray[0]);
		assertEquals(-2.0, testArray[1]);
		assertEquals(-3.0, testArray[2]);
		assertEquals(4.0, testArray[3]);
	}
	
	@Test
	void testNonWholeNumberValues() {
		double[] values = {-1.2,2.8,3.1,-4.3};
		Number[] testArray = createNumberArray(values);
		
		assertEquals(-1.2, testArray[0]);
		assertEquals(2.8, testArray[1]);
		assertEquals(3.1, testArray[2]);
		assertEquals(-4.3, testArray[3]);
	}
}
