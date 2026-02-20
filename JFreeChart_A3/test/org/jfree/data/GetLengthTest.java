package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetLengthTest {
	private Range exampleRange;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		exampleRange = new Range(1,10);
	}
	
	//	ECP: Valid Value
	@Test
	void validValue() {
		assertEquals(10, exampleRange.getLength(),"The range length is 10.");
	}
	
	//	Note: ECP below and above valid values (9 and 11) were removed as they are covered in BVA testing.
	
	//	BVA: LB - 1 
	@Test
	void LBMinusOneValue() {
		assertNotEquals(0, exampleRange.getLength(), "The range length is not 0." );
	}
	
	//	 BVA: LB
	@Test
	void LBValue() {
		assertNotEquals(1, exampleRange.getLength(), "The range length is not 1.");
	}
	
	//	BVA: LB + 1
	@Test
	void LBPlusOneValue() {
		assertNotEquals(2, exampleRange.getLength(), "The range length is not 2.");
	}
	
	// BVA: UB - 1
	@Test
	void UBMinusOneValue() {
		assertNotEquals(9, exampleRange.getLength(), "The range length is not 9.");
	}
	
	//	BVA: UB 
	@Test
	void UBValue() {
		assertEquals(10, exampleRange.getLength(), "The range length is 10.");
	}
	
	//	BVA: UB + 1
	@Test
	void UBPlusOneValue() {
		assertNotEquals(11, exampleRange.getLength(), "The range length is not 11.");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
