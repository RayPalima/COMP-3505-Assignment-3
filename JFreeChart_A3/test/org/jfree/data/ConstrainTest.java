package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConstrainTest {
	private Range exampleRange;
	
	@BeforeEach
  	void setUp() throws Exception {
		exampleRange = new Range(0, 10);
  	}
	
	//Equivalence Class Partitioning (ECP)
  	@Test
  	void constrain_WithinValueRange() {
 		assertEquals(4.0, exampleRange.constrain(4.0),"The Target is within Range");
  	}
	@Test
  	void constrain_AboveUpperRange() {
 		assertEquals(10.0, exampleRange.constrain(15.0),"The Target is constrained in Upper Bound");
  	}
	@Test
  	void constrain_BelowLowerRange() {
 		assertEquals(0.0, exampleRange.constrain(-10.0),"The Target is constrained in Lower Bound");
  	}
	
	//Boundary Value Analysis
	@Test
  	void constrain_LowerBound_Below_One() {
 		assertEquals(0.0, exampleRange.constrain(-1.0),"The Target is -1 on Lower Bound");
  	}
	@Test
  	void constrain_AtLowerBound() {
 		assertEquals(0.0, exampleRange.constrain(0.0),"The Target is on Lower Bound");
  	}
	@Test
  	void constrain_LowerBound_Above_One() {
 		assertEquals(1.0, exampleRange.constrain(1.0),"The Target is +1 on Lower Bound");
  	}
	@Test
  	void constrain_UpperBound_Below_One() {
 		assertEquals(9.0, exampleRange.constrain(9.0),"The Target is on -1 Upper Bound");
  	}
	@Test
  	void constrain_AtUpperBound() {
 		assertEquals(10.0, exampleRange.constrain(10.0),"The Target is on Upper Bound");
  	}
	@Test
	void constrain_UpperBound_Above_One() {
 		assertEquals(10.0, exampleRange.constrain(11.0),"The Target is on +1 Upper Bound");
  	}
	
}
