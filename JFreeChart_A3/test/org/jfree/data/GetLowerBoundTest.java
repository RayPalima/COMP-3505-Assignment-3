package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetLowerBoundTest {
	private Range exampleRange;
	
	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  	}
  	@BeforeEach
  	void setUp() throws Exception {
  		exampleRange = new Range(1, 100);
  	}
  	
  	
  	//  ECP: Valid - Within range values.
	@Test
	void validLowerValue() {
		assertEquals(1, exampleRange.getLowerBound(),"The lower bound value is 1.");
	}
	
	//	Note: ECP below and above valid values (0 and 101) were removed as they are covered in BVA testing.

	// BVA: LB - 1
	@Test
	void LBMinusOneValue() {
		assertNotEquals(0, exampleRange.getLowerBound(), "The lower bound value is not 0.");
	}
	
	//	BVA: LB
	@Test	
	void LBValue() {
		assertEquals(1, exampleRange.getLowerBound(),"The lower bound value is 1.");
	}
	
	//	BVA: LB + 1
	@Test
	void LBPlusOneValue() {
		assertNotEquals(2, exampleRange.getLowerBound(), "The lower bound value is not 2.");
	}
	
	//	BVA: UB - 1
	@Test
	void UBMinusOneValue() {
		assertNotEquals(99, exampleRange.getLowerBound(), "The lower bound value is not 99.");
	}
	
	//	BVA: UB
	@Test
	void UBValue() {
		assertNotEquals(100, exampleRange.getLowerBound(), "The lower bound value is not 100.");
	}
	
	//	BVA: UB + 1
	@Test
	void UBPlusOneValue() {
		assertNotEquals(101, exampleRange.getLowerBound(), "The lower bound value is not 101.");
	}
	
	
	@AfterEach
  	void tearDown() throws Exception          	 {
  	}
  	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}

}
