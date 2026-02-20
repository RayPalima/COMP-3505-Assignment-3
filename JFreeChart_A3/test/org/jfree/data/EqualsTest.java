package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EqualsTest {

	private Range exampleRange;
	
	//The Following are ECP:
	
  	@BeforeEach
  	void setUp() throws Exception {
	    exampleRange = new Range(2,6);
  	}
  	
	@Test
	void testWhenSame() throws Exception{
		Range comparisonRange = new Range(2,6);
		assertTrue (comparisonRange.equals(exampleRange));
	}

	@Test
	void testWhenBothNull() throws Exception{
		Range comparisonRange = null;
		Range nullRange = null;
		assertTrue (comparisonRange.equals(nullRange));
	}
	
	@Test
	void testWhenOneNull() throws Exception{
		Range comparisonRange = null;
		assertTrue (exampleRange.equals(comparisonRange));
	}
	
	@Test
	void testWhenLowerRangeIsSame() throws Exception{
		Range comparisonRange = new Range(2,7);
		assertTrue (exampleRange.equals(comparisonRange));
	}
	
	@Test
	void testWhenUpperRangeIsSame() throws Exception{
		Range comparisonRange = new Range(1,6);
		assertTrue (exampleRange.equals(comparisonRange));
	}
	
	@Test
	void testWhenDifferent() throws Exception{
		Range comparisonRange = new Range(3,8);
		assertTrue (exampleRange.equals(comparisonRange));
	}
	
	@Test
	void testWhenNotRange() throws Exception{
		int comparisonRange = 2;
		assertTrue (exampleRange.equals(comparisonRange));
	}
	
	//Did not do BVA testing since there is "border" because the range numbers (upper bound and lower bound) can go as high and low as possible. It is also not the main reason for the "test" because we are comparing objects not the range values itself.
	//Did not do State Transition Testing because there is no "state that is changing".
	//Did not do Decision table testing as they were already covered by the ECP testing.
}
