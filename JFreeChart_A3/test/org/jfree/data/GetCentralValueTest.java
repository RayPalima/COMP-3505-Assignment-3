package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GetCentralValueTest {
	private Range exampleRange;
  	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  	}
	
	@Test
	void testNormalRange() throws Exception{
		exampleRange = new Range(100, 200);
 		assertEquals(150, exampleRange.getCentralValue(),0.1d,"The central value of (100-200) is 150");
 		
	}
	@Test
	void testDoubleRange() throws Exception{
		exampleRange= new Range(0,3);
		assertEquals(1.5, exampleRange.getCentralValue(),0.1d, "The Central value of (0-3)is 1.5");
	}
	@Test
	void testNegativePositiveRange() throws Exception{
		exampleRange = new Range(-2,3);
		assertEquals(0.5, exampleRange.getCentralValue(),0.1d, "The Central value of ((-2)-(3)) is 0.5");
	}
	@Test
	void testAllNegativeRange() throws Exception{
	    exampleRange = new Range(-10, -2);
	    assertEquals(-6, exampleRange.getCentralValue(), 0.1d, "The central value of (-10 to -2) is -6");
	}
	@Test	
	void testSinglePointRange() throws Exception {
		exampleRange = new Range (10,10);
		assertEquals(10, exampleRange.getCentralValue(),0.1d, "The Central Value of (10-10) is 10");
	}
		
	@Test
	void testLargeRangeValues() throws Exception {
	    exampleRange = new Range(1000000, 2000000);
	    assertEquals(1500000, exampleRange.getCentralValue(), 0.1d, "The Central value is 1,500,000");
	}
	
	
	
}

