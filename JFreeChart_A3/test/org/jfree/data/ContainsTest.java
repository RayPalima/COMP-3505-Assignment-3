package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ContainsTest {
	private Range exampleRange;
  	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  	}
	
	@Test
	void testPositiveValueInRange() throws Exception{
		exampleRange = new Range(100, 500);
 		assertTrue(exampleRange.contains(167),"167 is within range");
	}
	@Test 
	void testNegativeValueInRange() throws Exception{
		exampleRange = new Range(-20,-1);
		assertTrue(exampleRange.contains(-5), " -5 is within range");
	}
	@Test
	void testPositiveToNegativeRange() throws Exception{
		exampleRange = new Range(-20, 20);
		assertTrue(exampleRange.contains(12), "12 is within range");
	}
	@Test
	void testSinglePointRange() throws Exception{
		exampleRange = new Range (10,10);
		assertTrue(exampleRange.contains(10), "10 is the range");
	}
	@Test
	void testValueAtHighBound() throws Exception{
		exampleRange = new Range(100,500);
		assertTrue(exampleRange.contains(500),"500 is at range");
	}
	@Test
	void testValueAtLowBound() throws Exception{
		exampleRange = new Range(100,500);
		assertTrue(exampleRange.contains(100),"100 is at range");
	}
	@Test
	void testInvalidUpperBound()throws Exception{
		exampleRange = new Range(5,10);
		assertTrue(exampleRange.contains(12), "12 is out of range");
	}
	@Test
	void testInvalidLowerBound()throws Exception{
		exampleRange = new Range(5,10);
		assertTrue(exampleRange.contains(1), " 1 is out of range");
	}
	@Test 
	void testLargeContainValues() throws Exception {
	    exampleRange = new Range(1000000, 2000000);
	    assertTrue(exampleRange.contains(1780000),"1,780,000 is in range");
	}
	

}



