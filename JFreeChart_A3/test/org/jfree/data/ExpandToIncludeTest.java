package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpandToIncludeTest {
private Range exampleRange;

	@BeforeEach
	void setUp() throws Exception {
		exampleRange = new Range(0, 10);
	}
	//expandToInclude(Range range, double value)
    //Returns a range that includes all the values in the specified range AND contains the specified value.
	
	
	//Equivalence Class Partitioning
	@Test
  	void expandToInclude_BelowValueRange() {
		assertEquals(new Range(-100, 10), Range.expandToInclude(exampleRange, -100.0));
  	}
	@Test
  	void expandToInclude_WithinValueRange() {
		assertEquals(new Range(0, 10), Range.expandToInclude(exampleRange, 4.0));
  	}
	@Test
  	void expandToInclude_AboveValueRange() {
		assertEquals(new Range(0, 100), Range.expandToInclude(exampleRange, 100.0));
  	}
	
	//Boundary Value Analysis
	@Test
	void expandToInclude_LowerBound_Below_One() {
		assertEquals(new Range(-1, 10), Range.expandToInclude(exampleRange, -1.0));
	}
	@Test
	void expandToInclude_AtLowerBound() {
		assertEquals(new Range(0, 10), Range.expandToInclude(exampleRange, 0.0));
	}
	@Test
	void expandToInclude_LowerBound_Above_One() {
		assertEquals(new Range(0, 10), Range.expandToInclude(exampleRange, 1.0));
	}
	@Test
	void expandToInclude_UpperBound_Below_One() {
		assertEquals(new Range(0, 10), Range.expandToInclude(exampleRange, 9.0));
	}
	@Test
	void expandToInclude_AtUpperBound() {
		assertEquals(new Range(0, 10), Range.expandToInclude(exampleRange, 10.0));
	}
	@Test
	void expandToInclude_UpperBound_Above_One() {
		assertEquals(new Range(0, 11), Range.expandToInclude(exampleRange, 11.0));
	}
	
	//Should all be null because there is no range
	@ParameterizedTest
	@ValueSource(doubles = {-1, 0, 1, 9, 10, 11})
	void expandToInclude_NullRange(double value) {
	    assertEquals(new Range(value, value), Range.expandToInclude(null, value));
	}
}
